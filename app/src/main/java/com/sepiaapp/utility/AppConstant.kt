package com.sepiaapp.utility

import java.text.SimpleDateFormat
import java.util.*

class AppConstant {

    object UserState {
        const val NEW_USER = 1
        const val LOGGED_IN = 2
    }


    object PrefsName {

        val LOGGED_IN = "loggedIn"
        val AUTH_TOKEN = "auth_token"
    }


    object MESSAGES {
        val API_ERROR = "Something went wrong"
        val SUBSCRIPTION_ERROR_MESSAGE = "You don't have active Subscription."

    }

    companion object {
        var SPLASH_TIME: Long = 3000
        var IMAGE_SIDE: Long = 4500000
        val GALLERY:Int = 1
        val CAMERA:Int = 2

        fun mediaDate(date: String?):String {
            var dateString:String=""
            if(date!=null){
                try {
                    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
                    val outputFormat = SimpleDateFormat("dd MMM yyyy")
                    val date: Date = inputFormat.parse(date)
                    dateString = outputFormat.format(date)
                    return dateString
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }else{
                return dateString
            }
            return dateString
        }

        fun getWorkingHours(date: String?):String {
            var dateString:String=""
            if(date!=null){
                try {
                    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
                    val outputFormat = SimpleDateFormat("HH")
                    val date: Date = inputFormat.parse(date)
                    dateString = outputFormat.format(date)
                    return dateString
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }else{
                return dateString
            }
            return dateString
        }
    }

     object INTENT{
        val IMAGE_URL="image_url"
         val TITLE="title"
         val DATE="date"

     }
}
