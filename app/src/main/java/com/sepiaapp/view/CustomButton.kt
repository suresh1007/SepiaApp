package com.sepiaapp.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import android.util.AttributeSet
import com.sepiaapp.R
import com.sepiaapp.manager.FontManager


class CustomButton : AppCompatButton {
    private val mContext: Context
    var cTypeFace: String? = null
        set(tf) {
            field = tf
            if (tf != null) {
                FontManager.setTypeFace(mContext, this, tf)
            }
        }

    constructor(context: Context, typeface: String) : super(context) {
        this.mContext = context
        cTypeFace = typeface
    }

    @SuppressLint("Recycle", "CustomViewStyleable")
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.mContext = context
        val a = context.obtainStyledAttributes(attrs, R.styleable.TextView)

        val typeface = a.getString(R.styleable.TextView_ctypeface)
        cTypeFace = typeface
    }
}
