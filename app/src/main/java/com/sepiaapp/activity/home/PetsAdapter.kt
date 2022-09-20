package com.sepiaapp.activity.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sepiaapp.BR
import com.sepiaapp.R
import com.sepiaapp.databinding.LayoutInflatePetsItemBinding
import com.sepiaapp.listeners.OnEventClick
import com.sepiaapp.model.PetsItem

class PetsAdapter (private val petsList: List<PetsItem>, val onEventClick: OnEventClick) : RecyclerView.Adapter<PetsAdapter.PetsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetsViewHolder {
        val binding: LayoutInflatePetsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_inflate_pets_item, parent, false)
        return PetsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PetsViewHolder, position: Int) {
        val files = petsList.get(position)
        holder.bind(files)
        holder.petsItemBinding.rlMember.setOnClickListener {
            onEventClick.onclickPetsItem(position)
        }
    }

    override fun getItemCount(): Int {
        return petsList.size
    }

    inner class PetsViewHolder(var petsItemBinding: LayoutInflatePetsItemBinding) : RecyclerView.ViewHolder(petsItemBinding.root) {
        fun bind(obj: Any?) {
            petsItemBinding.setVariable(BR.petsItem, obj)
            petsItemBinding.executePendingBindings()
        }

    }

}