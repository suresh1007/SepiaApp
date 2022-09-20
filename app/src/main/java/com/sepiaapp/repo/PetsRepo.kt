package com.sepiaapp.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sepiaapp.model.PetsData
import com.sepiaapp.model.PetsItem
import java.io.IOException

internal class PetsRepo {

    fun getPetsData(context: Context,petsData:MutableLiveData<PetsData>) {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("pets_list.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("Exception",ioException.toString())
        }
        petsData.postValue(Gson().fromJson(jsonString, PetsData::class.java))
    }
}