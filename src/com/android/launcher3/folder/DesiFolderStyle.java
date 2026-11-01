package com.android.launcher3.folder;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.launcher3.model.data.FolderInfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Remembers whether an individual home screen folder is drawn as a large folder (3x3 preview)
 * or as a classic small folder (2x2 preview).
 */
public final class DesiFolderStyle {

    private static final String PREFS = "desi_folder_style";
    private static final String KEY_SMALL = "small_folder_ids";
    private static final String KEY_LARGE = "large_folder_ids";

    private DesiFolderStyle() {
    }

    private static SharedPreferences prefs(Context context) {
        return context.getApplicationContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    public static boolean isLarge(Context context, FolderInfo info) {
        if (info == null) {
            return false;
        }
        String key = String.valueOf(info.id);
        Set<String> small = prefs(context).getStringSet(KEY_SMALL, Collections.emptySet());
        if (small.contains(key)) {
            return false;
        }
        Set<String> large = prefs(context).getStringSet(KEY_LARGE, Collections.emptySet());
        if (large.contains(key)) {
            return true;
        }
        // Default: folders that hold more apps than the classic preview can show become large.
        return info.getContents().size() > ClippedFolderIconLayoutRule.CIRCULAR_MAX_ITEMS;
    }

    public static void setLarge(Context context, FolderInfo info, boolean large) {
        if (info == null) {
            return;
        }
        String key = String.valueOf(info.id);
        SharedPreferences p = prefs(context);
        Set<String> small = new HashSet<>(p.getStringSet(KEY_SMALL, Collections.emptySet()));
        Set<String> big = new HashSet<>(p.getStringSet(KEY_LARGE, Collections.emptySet()));
        if (large) {
            small.remove(key);
            big.add(key);
        } else {
            big.remove(key);
            small.add(key);
        }
        p.edit().putStringSet(KEY_SMALL, small).putStringSet(KEY_LARGE, big).apply();
    }
}
