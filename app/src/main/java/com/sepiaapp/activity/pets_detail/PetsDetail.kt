package com.sepiaapp.activity.pets_detail

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.sepiaapp.R
import com.sepiaapp.base.BaseActivity
import com.sepiaapp.databinding.ActivityPetsDetailBinding
import com.sepiaapp.utility.AppConstant

class PetsDetail : BaseActivity() {
    private lateinit var imageUrl:String
    private lateinit var title:String
    private lateinit var date:String
    private lateinit var mBinding:ActivityPetsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pets_detail)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_pets_detail)


        if (intent.getStringExtra(AppConstant.INTENT.IMAGE_URL)!=null){
            imageUrl = intent.getStringExtra(AppConstant.INTENT.IMAGE_URL)!!
        }
        if (intent.getStringExtra(AppConstant.INTENT.TITLE)!=null){
            title = intent.getStringExtra(AppConstant.INTENT.TITLE)!!
        }
        if (intent.getStringExtra(AppConstant.INTENT.DATE)!=null){
            date = intent.getStringExtra(AppConstant.INTENT.DATE)!!
        }

        showPetsDetail(imageUrl,title,date)


    }

    private fun showPetsDetail(imgUrl:String,title:String,date:String) {

        Glide.with(this)
            .load(imgUrl)
            .circleCrop()
            .placeholder(R.drawable.animal_default)
            .into(mBinding.petsImage)
        mBinding.petsDate.text=AppConstant.mediaDate(date)
        mBinding.petsName.text=title
        Log.d("Workinghours",AppConstant.getWorkingHours(date))

    }
}