package com.kotlincookbook.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineActivity : AppCompatActivity() {

    val one = GlobalScope.async { longOpOne() }
    val two = GlobalScope.async { longOpTwo() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        GlobalScope.launch {
            println("hello")
            delay(2000)
            println("world")
        }

        GlobalScope.async {
            println("정답 ::: ${one.await() + two.await()}")
        }
    }

    suspend fun longOpOne(): Int {
        delay(1000L)
        return 10
    }

    suspend fun longOpTwo(): Int {
        delay(1000L)
        return 20
    }
}