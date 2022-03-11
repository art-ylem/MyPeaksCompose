package com.sidorov.mypeakscompose.data.repository.mock

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.sidorov.mypeakscompose.data.dto.RoutesDTO
import com.sidorov.mypeakscompose.data.vo.RoutesVO
import com.sidorov.mypeakscompose.domain.repository.RoutesRepository
import io.reactivex.Single
import java.io.FileReader

class MockRoutesRepository : RoutesRepository {

    override fun getRoutes(): Single<RoutesVO> {
        return Single.just(
            Gson().fromJson<RoutesDTO>(
                JsonReader(FileReader("routesMock.json")),
                RoutesDTO::class.java
            ).toVO()
        )
    }
}
