package app.lawnchair.qsb.providers

import com.android.launcher3.R

/**
 * iBharat (ibharat.org) — Indian crawler-based search engine.
 * No search activity is exposed by its Android app, so this opens the website.
 */
data object IBharat : QsbSearchProvider(
    id = "ibharat",
    name = R.string.search_provider_ibharat,
    icon = R.drawable.ic_qsb_search,
    packageName = "",
    website = "https://ibharat.org/",
    type = QsbSearchProviderType.WEBSITE,
)
