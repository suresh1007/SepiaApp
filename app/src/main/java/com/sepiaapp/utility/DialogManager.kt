package com.sepiaapp.utility

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.sepiaapp.R
import com.sepiaapp.view.CustomTextView


object DialogManager {

    fun showValidationDialog(activity: Context?, message: String?) {
        val dialog = Dialog(activity!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_dialog)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (!dialog.isShowing) dialog.show()
        val tvOk: CustomTextView = dialog.findViewById(R.id.tv_ok)
        val tetxt: CustomTextView = dialog.findViewById(R.id.tetxt)

        tetxt.text = message
        tvOk.setOnClickListener {
            dialog.dismiss()
        }
    }

}