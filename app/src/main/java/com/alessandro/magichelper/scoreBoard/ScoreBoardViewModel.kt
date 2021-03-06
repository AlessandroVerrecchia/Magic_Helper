package com.alessandro.magichelper.scoreBoard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreBoardViewModel : ViewModel() {
    val lifeTotalLiveData = MutableLiveData<Int>()
    val opponentLifeTotalLiveData = MutableLiveData<Int>()

    fun resetLifeTotals() {
        opponentLifeTotalLiveData.value = 20
        lifeTotalLiveData.value = 20
    }

    fun removeLifeTotal() {
        lifeTotalLiveData.value = lifeTotalLiveData.value?.minus(1)
    }

    fun removeOpponentLifeTotal() {
        opponentLifeTotalLiveData.value = opponentLifeTotalLiveData.value?.minus(1)
    }

    fun addLifeTotal() {
        lifeTotalLiveData.value = lifeTotalLiveData.value?.plus(1)
    }

    fun addOpponentLifeTotal() {
        opponentLifeTotalLiveData.value = opponentLifeTotalLiveData.value?.plus(1)
    }

}