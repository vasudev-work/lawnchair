package app.lawnchair.qsb.providers

import com.android.launcher3.R

/**
 * Qmamu (qmamu.com) — Indian privacy-focused search engine.
 * No Android app, so this opens the website where the query is typed.
 */
data object Qmamu : QsbSearchProvider(
    id = "qmamu",
    name = R.string.search_provider_qmamu,
    icon = R.drawable.ic_qsb_search,
    packageName = "",
    website = "https://qmamu.com/",
    type = QsbSearchProviderType.WEBSITE,
)
