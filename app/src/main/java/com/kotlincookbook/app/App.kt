package com.kotlincookbook.app

import android.app.Application

/**
 * Created by jongkook on 2020.11.17
 * .
 * Prefs는 불필요하게 여러번 인스턴스를 생성할 필요가 없기 때문
 */

val prefs: Prefs by lazy {
    App.prefs!!
}

class App: Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(this)
        super.onCreate()
    }
}