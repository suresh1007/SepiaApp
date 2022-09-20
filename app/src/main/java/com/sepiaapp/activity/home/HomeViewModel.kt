package com.sepiaapp.activity.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.sepiaapp.base.BaseViewModel
import com.sepiaapp.listeners.OnEventClick
import com.sepiaapp.model.PetsData
import com.sepiaapp.repo.PetsRepo

internal class HomeViewModel : BaseViewModel<OnEventClick, PetsRepo>(){
    var petsData= MutableLiveData<PetsData>()

    fun getPetsData(context:Context){
        getRepo()?.getPetsData(context,petsData)
    }

}