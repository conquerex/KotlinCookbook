package com.kotlincookbook.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.*

/**
 * Created by theseus on 21/10/17.
 */
fun ImageView.loadImage(image: Int) {
    Glide.with(context).load(image).into(this)
}

 fun ViewGroup.inflate(flavour_item: Int): View {
    return LayoutInflater.from(context).inflate(flavour_item,null,false)
}
 fun <E> List<E>.shuffle(): MutableList<E> {
    val list = this.toMutableList()
    Collections.shuffle(list)

    return list
}
