package com.sepiaapp.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sepiaapp.R
import com.sepiaapp.activity.home.HomeActivity
import com.sepiaapp.base.BaseActivity
import com.sepiaapp.databinding.ActivitySplashBinding
import com.sepiaapp.utility.AppConstant

class ActivitySplash : BaseActivity() {
    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        val viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)


        viewModel.state.observe(this, Observer {
            when (it) {
                AppConstant.UserState.NEW_USER -> {
                    gotoHome()
                }
               /* AppConstant.UserState.LOGGED_IN -> {
                    gotoHome()
                }*/

            }
        })

        viewModel.startTimer()

    }

    private fun gotoHome() {
        launchActivity(HomeActivity::class.java)
        this.finish()
    }


}