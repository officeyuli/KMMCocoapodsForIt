package com.officeyuli.kmmcocoapods

import com.officeyuli.kmmcocoapods.remote.ktor.CafeApi
import com.officeyuli.kmmcocoapods.remote.ktor.CafeApiImpl
import com.officeyuli.kmmcocoapods.remote.ktor.response.CafeResponseItem


class DataRepository {
    companion object {
        val tag = DataRepository::class.simpleName
    }

    private val ktorApi: CafeApi by lazy { CafeApiImpl() }
    suspend fun fetchCafesFromNetwork(cityName: String): List<CafeResponseItem> {
        try {
            return ktorApi.fetchCafeFromApi(cityName)
        } catch (e: Exception) {
            println(e.message)
        }
        return listOf()
    }

}