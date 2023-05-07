package com.example.bwfprojectrakha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class splashBWF : AppCompatActivity() {

    private val TIME_OUT:Long = 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_bwf)
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish() }, TIME_OUT)
    }

    
}