package com.sidorov.mypeakscompose.domain.repository

import com.sidorov.mypeakscompose.data.vo.RoutesVO
import io.reactivex.Single

interface RoutesRepository {
    fun getRoutes(): Single<RoutesVO>
}
