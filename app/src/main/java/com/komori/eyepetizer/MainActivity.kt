package com.komori.eyepetizer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.komori.home.HomeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
