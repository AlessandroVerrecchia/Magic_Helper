package com.alessandro.magichelper.scoreBoard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MultiPlayerViewModel : ViewModel() {
    val life1LiveData = MutableLiveData<Int>()
    val life2LiveData = MutableLiveData<Int>()
    val life3LiveData = MutableLiveData<Int>()
    val life4LiveData = MutableLiveData<Int>()

    fun resetLifeTotals() {
        life1LiveData.value = 40
        life2LiveData.value = 40
        life3LiveData.value = 40
        life4LiveData.value = 40
    }

    fun removeLifeTotal(player: Int) {
        when (player) {
            1 -> life1LiveData.value = life1LiveData.value?.minus(1)
            2 -> life2LiveData.value = life2LiveData.value?.minus(1)
            3 -> life3LiveData.value = life3LiveData.value?.minus(1)
            4 -> life4LiveData.value = life4LiveData.value?.minus(1)
        }
    }

    fun addLifeTotal(player: Int) {
        when (player) {
            1 -> life1LiveData.value = life1LiveData.value?.plus(1)
            2 -> life2LiveData.value = life2LiveData.value?.plus(1)
            3 -> life3LiveData.value = life3LiveData.value?.plus(1)
            4 -> life4LiveData.value = life4LiveData.value?.plus(1)
        }
    }
}

