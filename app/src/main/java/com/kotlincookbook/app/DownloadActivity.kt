package com.kotlincookbook.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_download.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class DownloadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)
        Log.d(this.localClassName, "* * * ${filesDir.absolutePath} ${filesDir.canonicalPath}")

        val okHttpClient = OkHttpClient.Builder()
                .readTimeout(15000, TimeUnit.MILLISECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("https://httpbin.org/")
                .build()

        val apiService = retrofit.create(ApiService::class.java)
        apiService.getHttpBin()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response -> Log.d(this.localClassName, "* * * " + response.toString())
                }, {
                    throwable -> Log.d(this.localClassName, "* * * " + throwable.message)
                })

        btn_download_file.setOnClickListener {
            progressBar.progress = 0
            Fuel.download("https://httpbin.org/bytes/32768")
                    .fileDestination { response, request ->
                        Log.d(this.localClassName, "* * * fileDestination * * *")
                        File.createTempFile("IamTemp", ".tmp")
                    }.progress { readBytes, totalBytes ->
                        val progress = readBytes.toFloat() / totalBytes.toFloat()
                        Log.d(this.localClassName, "* * * Progress : ${progress}")
                        progressBar.progress = progress.toInt() * 100
                    }.response { request, response, result ->
                        Log.d(this.localClassName, "* * * result   : ${result.component1().toString()}")
                        Log.d(this.localClassName, "* * * response : ${response.responseMessage}")
                        Log.d(this.localClassName, "* * * request  : ${request.url}")
                    }
        }
    }
}