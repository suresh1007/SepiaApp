package com.sepiaapp.model

data class PetsData(val pets:ArrayList<PetsItem>)
data class PetsItem(val image_url:String, val title:String, val content_url:String, val date_added:String)