package com.sidorov.mypeakscompose.data.repository.remote

import android.content.Context
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.sidorov.mypeakscompose.R
import com.sidorov.mypeakscompose.data.dto.RoutesDTO
import com.sidorov.mypeakscompose.data.network.ApiService
import com.sidorov.mypeakscompose.data.vo.RoutesVO
import com.sidorov.mypeakscompose.domain.repository.RoutesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.Single
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

class RemoteRoutesRepository @Inject constructor(
    private val apiService: ApiService,
    @ApplicationContext private val context: Context
) :
    RoutesRepository {

    override fun getRoutes(): Single<RoutesVO> {

        val ins: InputStream = context.resources.openRawResource(R.raw.routes_mock)

        return Single.just(
            Gson().fromJson<RoutesDTO>(
                JsonReader(InputStreamReader(ins)),
                RoutesDTO::class.java
            ).toVO()
        )
    }
}
