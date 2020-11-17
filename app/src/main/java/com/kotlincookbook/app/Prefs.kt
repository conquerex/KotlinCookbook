package com.kotlincookbook.app

import android.content.Context

/**
 * Created by jongkook on 2020.11.17
 */
class Prefs(mContext: Context) {
    val sharedpreferences = mContext.getSharedPreferences("com.kotlincookbook.app", Context.MODE_PRIVATE)
    val PREF_USERNAME = "pref_username"

    var username: String
        get() = sharedpreferences.getString(PREF_USERNAME, null)
        set(value) = sharedpreferences.edit().putString(PREF_USERNAME, value).apply()


}