package com.alessandro.magichelper.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alessandro.scryfallapi.network.model.CardDto
import com.alessandro.scryfallapi.network.useCase.IGetCardByNameUseCase
import com.alessandro.scryfallapi.network.utils.Status
import kotlinx.coroutines.launch

class SearchViewModel(private val getCardByNameUseCase: IGetCardByNameUseCase) : ViewModel() {
    val cardLiveData = MutableLiveData<CardDto?>()
    val errorLiveData = MutableLiveData<String?>()

    fun searchCard(query: String) {
        viewModelScope.launch {
            val result = getCardByNameUseCase.execute(query)
            if (result.status == Status.SUCCESS) {
                cardLiveData.value = result.data
            } else {
                errorLiveData.value = result.message
            }
        }
    }
}