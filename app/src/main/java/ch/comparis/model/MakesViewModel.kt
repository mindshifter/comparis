package ch.comparis.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ch.comparis.This

class MakesViewModel : ViewModel() {
    val makesLiveData = MutableLiveData<MutableList<Make>>()
    val favoritesCount = MutableLiveData<Int>()

    //For purpose of this task
    private val makesLocalRepo = This.localRepo

    init {
        refreshData()
    }


    fun addMakeToFavorite(make: Make) {
        makesLocalRepo.addMakeToFavorite(make.name)
        refreshData()
    }

    fun removeMakeFromFavorite(make: Make) {
        makesLocalRepo.removeMakeFromFavorite(make.name)
        refreshData()
    }

    fun getFavoriteCount() {
        favoritesCount.postValue(makesLocalRepo.countFavorites())
    }

    private fun refreshData() {
        makesLiveData.postValue(makesLocalRepo.getMakes())
    }
}