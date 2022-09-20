package com.sepiaapp.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.View
import com.sepiaapp.R
import com.sepiaapp.manager.FontManager


class CustomTextView : AppCompatTextView {
    var cTypeFace: String? = null
        set(tf) {
            field = tf
            if (tf != null) {
                FontManager.setTypeFace(mContext!!, this, tf)
            }
        }
    private var mContext: Context? = null

    val isVisible: Boolean
        get() = visibility == View.VISIBLE

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
