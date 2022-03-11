package com.sidorov.mypeakscompose.data.vo


data class RoutesVO(
    val routes: List<RouteVO>
)

data class RouteVO(
    val name: String,
    val location: String,
    val image: String,
    val difficulty: String
)
