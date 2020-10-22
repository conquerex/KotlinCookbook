package com.kotlincookbook.app

import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates


/**
 * Created by theseus on 21/10/17.
 */
class AndroidFlavourAdapter:RecyclerView.Adapter<AndroidFlavourAdapter.FlavourViewHolder>() {
    var flavourItems:List<AndroidFlavours> by Delegates.observable(emptyList()){
        property, oldValue, newValue ->
        notifyChanges(oldValue,newValue)
    }

    private fun notifyChanges(oldValue: List<AndroidFlavours>, newValue: List<AndroidFlavours>) {
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
                val oldFlavor=oldValue.get(oldItemPosition)
                val newFlavor=newValue.get(newItemPosition)
                val bundle=Bundle()
                if(!oldFlavor.name.equals(newFlavor.name)){
                    bundle.putString("name",newFlavor.name)
                }
                if(!oldFlavor.image.equals(newFlavor.image)){
                    bundle.putInt("image",newFlavor.image)
                }
                if(bundle.size()==0) return null
                return bundle
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldValue.get(oldItemPosition)==newValue.get(newItemPosition)
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldValue.get(oldItemPosition).name.equals(newValue.get(newItemPosition).name)&&oldValue.get(oldItemPosition).image.equals(newValue.get(newItemPosition).image)
            }

            override fun getOldListSize() = oldValue.size

            override fun getNewListSize() = newValue.size

        })

        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlavourViewHolder {
        return FlavourViewHolder(parent.inflate(R.layout.flavour_item))
    }

    override fun onBindViewHolder(holder: FlavourViewHolder, position: Int, payloads: MutableList<Any>?) {
        if (payloads != null) {
            if (payloads.isEmpty())
                return onBindViewHolder(holder,position)
            else {
                val o = payloads.get(0) as Bundle
                for (key in o.keySet()) {
                    if (key == "name") {
                        holder.name.text=o.getString("name")
                    } else if (key == "image") {
                        holder.image.loadImage(o.getInt("image"))
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int =flavourItems.size

    override fun onBindViewHolder(holder: FlavourViewHolder, position: Int) {
        holder.name.text=flavourItems.get(holder.adapterPosition).name
        holder.image.loadImage(flavourItems.get(holder.adapterPosition).image)
    }

    inner class FlavourViewHolder(var view: View):RecyclerView.ViewHolder(view){
        var name:TextView = view.findViewById(R.id.textView)
        var image:ImageView = view.findViewById(R.id.imageView)
    }
}


