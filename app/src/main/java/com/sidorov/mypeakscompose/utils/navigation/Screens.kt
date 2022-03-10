package com.sidorov.mypeakscompose.utils.navigation

import com.sidorov.mypeakscompose.R

/**
 * This class describe screen navigation objects
 * @param screenName - deeplink screen representation
 * @param titleResourceId - resource to name tabbar or appbar navigation title
 */
sealed class Screen(val screenName: String, val titleResourceId: Int) {

    object Routes : Screen("routes", R.string.title_routes)
    object News : Screen("news", R.string.title_news)
    object Profile : Screen("profile", R.string.title_profile)
    object RouteDetails : Screen("route_details", R.string.title_route_details)
    object Main : Screen("main", -1)
    object User : Screen("user", -1)
    object Error : Screen("error", R.string.error)
}
