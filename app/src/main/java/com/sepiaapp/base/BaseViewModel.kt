package com.sepiaapp.base

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference


open class BaseViewModel<N, R> : ViewModel() {

    private var mRepo : R? = null
    private var mNavigator : WeakReference<N>? = null

    fun getRepo(): R? {
        return mRepo
    }

    fun setRepo(repo : R) {
        this.mRepo = repo
    }

    fun getNavigator(): N? {
        return mNavigator?.get()
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }


}