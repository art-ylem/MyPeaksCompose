package com.sidorov.mypeakscompose.data.dto

import com.sidorov.mypeakscompose.data.vo.RouteVO
import com.sidorov.mypeakscompose.data.vo.RoutesVO

data class RoutesDTO(
    val routes: List<RouteDTO>
) {

    fun toVO(): RoutesVO {
        return RoutesVO(routes.map { it.toVO() })
    }
}

data class RouteDTO(
    val name: String,
    val location: String,
    val image: String,
    val difficulty: String
) {
    fun toVO(): RouteVO {
        return RouteVO(
            name = name,
            location = location,
            image = image,
            difficulty = difficulty
        )
    }
}
