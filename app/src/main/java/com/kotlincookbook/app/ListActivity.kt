package com.kotlincookbook.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    val dataList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(recyclerList = updateDataList(dataList))

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView!!.canScrollVertically(1)) {
                    onScrolledToBottom()
                }
            }

            fun onScrolledToBottom() {
                val initSize = dataList.size
                updateDataList(dataList)
                val updatedSize = dataList.size
                adapter.notifyItemRangeInserted(initSize, updatedSize)
            }
        })

    }

    fun updateDataList(dataList: MutableList<Int>): List<Int> {
        repeat(30) {
            dataList.add(dataList.size + 1)
        }
        return dataList
    }
}