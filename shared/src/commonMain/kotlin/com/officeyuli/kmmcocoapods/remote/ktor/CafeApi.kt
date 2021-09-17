package com.officeyuli.kmmcocoapods.remote.ktor

import com.officeyuli.kmmcocoapods.remote.ktor.response.CafeResponseItem

interface CafeApi {
    suspend fun fetchCafeFromApi(city:String): List<CafeResponseItem>
}