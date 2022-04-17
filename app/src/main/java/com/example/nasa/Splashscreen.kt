package com.example.nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        if (supportActionBar != null) supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 2000)
    }
}