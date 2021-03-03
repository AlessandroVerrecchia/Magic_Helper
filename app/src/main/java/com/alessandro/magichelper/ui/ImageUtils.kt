package com.alessandro.magichelper.ui

import android.widget.ImageView
import com.alessandro.magichelper.R
import com.bumptech.glide.Glide

fun loadImage(imageView: ImageView?, url: String?) {
    imageView ?: return
    Glide.with(imageView.context)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.glide_card_placeholder)
        .into(imageView)
}