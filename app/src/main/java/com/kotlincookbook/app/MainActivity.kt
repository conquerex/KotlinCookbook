package com.kotlincookbook.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdapter:AndroidFlavourAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter= AndroidFlavourAdapter()
        flavour_list.layoutManager=LinearLayoutManager(this)
        flavour_list.adapter=mAdapter
        var flavorList= mutableListOf<AndroidFlavours>(
                AndroidFlavours("Cupcake",R.drawable.cupcake),
                AndroidFlavours("Donut",R.drawable.donut),
                AndroidFlavours("Eclair",R.drawable.eclair),
                AndroidFlavours("Froyo",R.drawable.froyo),
                AndroidFlavours("Gingerbread",R.drawable.gingerbread),
                AndroidFlavours("HoneyComb",R.drawable.honeycomb),
                AndroidFlavours("Icecream Sandwich",R.drawable.icecream),
                AndroidFlavours("Jellybean",R.drawable.jellybean),
                AndroidFlavours("KitKat",R.drawable.kitkat),
                AndroidFlavours("Lollipop",R.drawable.lollipop))
        mAdapter.flavourItems=flavorList
        shuffle.setOnClickListener {
            mAdapter.flavourItems=flavorList.shuffle()
        }
    }
}

