package com.kotlincookbook.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class HelloActivity : AppCompatActivity() {

    private val textView: TextView by lazy {
        findViewById(R.id.text_view)
    }

    val prefs: Prefs by lazy {
        App.prefs!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val btn1 = findViewById(R.id.btn1) as Button
        val btn2 = findViewById(R.id.btn2) as Button
        val btn3 = findViewById(R.id.btn3) as Button

        btn1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Toast.makeText(this@HelloActivity, "Button 1 Click !!!", Toast.LENGTH_SHORT).show()
                textView.text = "click Button 1"
            }
        })
        btn2.setOnClickListener { Toast.makeText(this@HelloActivity, "Button 2 Click !!!", Toast.LENGTH_SHORT).show() }
        btn3.setOnClickListener { Toast.makeText(this, "Button 3 Click !!!!!", Toast.LENGTH_SHORT).show() }

//        textView.text = "onCreate..."
    }
}