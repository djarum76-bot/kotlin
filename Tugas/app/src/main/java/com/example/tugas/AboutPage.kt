package com.example.tugas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.valorant)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.title = ""
    }
}