package com.sepiaapp.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sepiaapp.utility.AppConstant
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class SplashViewModel : ViewModel(){
    var state = MutableLiveData<Int>()

    fun startTimer() {
        GlobalScope.launch {
            delay(AppConstant.SPLASH_TIME)
            moveToNext()
        }
    }

    private fun moveToNext() {
       /* if (PrefKeeper.isLoggedIn) {
            state.postValue(AppConstant.UserState.LOGGED_IN)
        }else {
            state.postValue(AppConstant.UserState.NEW_USER)
        }*/

        state.postValue(AppConstant.UserState.NEW_USER)
    }
}