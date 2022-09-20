package com.sepiaapp.activity.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sepiaapp.R
import com.sepiaapp.activity.pets_detail.PetsDetail
import com.sepiaapp.base.BaseActivity
import com.sepiaapp.databinding.ActivityHomeBinding
import com.sepiaapp.listeners.OnEventClick
import com.sepiaapp.model.PetsData
import com.sepiaapp.model.PetsItem
import com.sepiaapp.repo.PetsRepo
import com.sepiaapp.utility.AppConstant

class HomeActivity : BaseActivity(), OnEventClick {
    private lateinit var petsAdapter: PetsAdapter
    private lateinit var mBinding:ActivityHomeBinding
    private lateinit var petsList:ArrayList<PetsItem>
    private lateinit var viewModel:HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.setNavigator(this)
        val repo=PetsRepo()
        viewModel.setRepo(repo)
        petsList = ArrayList()
        petsAdapter= PetsAdapter(petsList,this)
        mBinding.adapter=petsAdapter

        viewModel.getPetsData(this)

        viewModel.petsData.observe(this, Observer {
            if (it!=null && it.pets.size>0){
                   showPetsdata(it.pets)
            }
        })



        mBinding.homeViewModel=viewModel
    }

    private fun showPetsdata(pets: ArrayList<PetsItem>) {
        for (x in 0 until pets.size){
            val wHours=AppConstant.getWorkingHours(pets.get(x).date_added)
            val name=pets.get(x).title
            if (wHours.toInt()>=9 && wHours.toInt()<=18){
                petsList.add(pets.get(x))
            }
            Log.d("AllHours",wHours+" Name: "+name)
        }
        petsAdapter.notifyDataSetChanged()
    }

    override fun onclickPetsItem(position: Int) {
       val intent = Intent(this, PetsDetail::class.java)
        intent.putExtra(AppConstant.INTENT.IMAGE_URL,petsList.get(position).image_url)
        intent.putExtra(AppConstant.INTENT.TITLE,petsList.get(position).title)
        intent.putExtra(AppConstant.INTENT.DATE,petsList.get(position).date_added)
        startActivity(intent)
    }
}