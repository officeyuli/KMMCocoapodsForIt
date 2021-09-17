package com.officeyuli.kmmcocoapods.android

import androidx.lifecycle.*
import com.officeyuli.kmmcocoapods.DataRepository
import com.officeyuli.kmmcocoapods.remote.ktor.response.CafeResponseItem
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val dataRepository: DataRepository = DataRepository()
    private val cafeList = MutableLiveData<List<CafeResponseItem>>()
    val cafeListLiveData: LiveData<List<CafeResponseItem>> = Transformations.map(cafeList) { it }

    fun fetchCafeData(city: String = "") {
        viewModelScope.launch() {
            val result = async { dataRepository.fetchCafesFromNetwork(city) }
            cafeList.value = result.await()
        }
    }
}