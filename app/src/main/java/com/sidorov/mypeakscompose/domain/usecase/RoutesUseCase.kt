package com.sidorov.mypeakscompose.domain.usecase

import com.sidorov.mypeakscompose.applySchedulers
import com.sidorov.mypeakscompose.domain.repository.RoutesRepository
import javax.inject.Inject
import javax.inject.Named

class RoutesUseCase @Inject constructor(@Named("mock") private val repository: RoutesRepository) {

    fun getRoutes() = repository.getRoutes().applySchedulers()
}
