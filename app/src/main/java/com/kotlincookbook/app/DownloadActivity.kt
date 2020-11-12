package com.kotlincookbook.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_download.*
import java.io.File

class DownloadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)
        Log.d(this.localClassName, "* * * ${filesDir.absolutePath} ${filesDir.canonicalPath}")

        btn_download_file.setOnClickListener {
            progressBar.progress = 0
            Fuel.download("https://httpbin.org/bytes/32768")
                    .fileDestination { response, request ->
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