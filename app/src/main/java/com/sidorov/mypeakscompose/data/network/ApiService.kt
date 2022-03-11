package com.sidorov.mypeakscompose.data.network

import com.sidorov.mypeakscompose.data.dto.RoutesDTO
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("general/routes")
    fun getRoutes(): Single<RoutesDTO>
}
