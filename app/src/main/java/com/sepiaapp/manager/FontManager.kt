package com.sepiaapp.manager

import android.content.Context
import android.graphics.Typeface
import android.view.View
import java.io.File
import java.util.*

object FontManager {
    private val fontNames = ArrayList<String>()
    private val typeFaceStore = HashMap<String, Typeface>()

    fun getTypeface(fontName: String): Typeface? {
        var fontName = fontName
        val index = fontNames.indexOf(fontName)
        if (index == -1) {
            fontNames.add(fontName)
        } else {
            fontName = fontNames[index]
        }
        return typeFaceStore[fontName]

    }

    fun setTypeFace(context: Context, view: View, fontName: String) {
        var fontName = fontName
        if (view !is android.widget.TextView) {
            return
        }
        val index = fontNames.indexOf(fontName)
        if (index == -1) {
            fontNames.add(fontName)
        } else {
            fontName = fontNames[index]
        }
        var typeface = typeFaceStore[fontName]
        if (typeface == null) {
            typeface = findTypeface(context, fontName)
            typeFaceStore[fontName] = typeface
        }
        if (typeface != null) {
            view.typeface = typeface
        } else {
            view.typeface = Typeface.DEFAULT
        }
    }

    private fun findTypeface(context: Context,
                             typeface: String): Typeface {
        val assets = context.assets
        return Typeface.createFromAsset(assets, "font" + File.separator + typeface)
    }
}
