package com.sepiaapp.utility

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sepiaapp.R
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("imageResource")
    fun imageResource(imageView: CircleImageView, imageUrl: String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .circleCrop()
            .placeholder(R.drawable.animal_default)
            .into(imageView)

    }
