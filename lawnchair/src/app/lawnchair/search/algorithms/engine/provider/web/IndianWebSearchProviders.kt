package app.lawnchair.search.algorithms.engine.provider.web

import android.net.Uri
import com.android.launcher3.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 * Qmamu (qmamu.com) — Indian privacy-focused search engine.
 *
 * The site exposes no public suggestion endpoint, so suggestions are left empty
 * and only the final search URL is built.
 */
object QmamuWebSearchProvider : WebSearchProvider {

    override val label = R.string.search_provider_qmamu

    override val iconRes = R.drawable.ic_qsb_search

    override val id: String = "qmamu"

    override fun getSuggestions(query: String): Flow<List<String>> = flowOf(emptyList())

    override fun getSearchUrl(query: String): String =
        "https://qmamu.com/search?q=${Uri.encode(query)}"

    override fun toString(): String = "QmamuWebSearchProvider"
}

/**
 * iBharat (ibharat.org) — Indian crawler-based search engine.
 *
 * The site exposes no public suggestion endpoint, so suggestions are left empty
 * and only the final search URL is built.
 */
object IBharatWebSearchProvider : WebSearchProvider {

    override val label = R.string.search_provider_ibharat

    override val iconRes = R.drawable.ic_qsb_search

    override val id: String = "ibharat"

    override fun getSuggestions(query: String): Flow<List<String>> = flowOf(emptyList())

    override fun getSearchUrl(query: String): String =
        "https://ibharat.org/search?q=${Uri.encode(query)}"

    override fun toString(): String = "IBharatWebSearchProvider"
}
