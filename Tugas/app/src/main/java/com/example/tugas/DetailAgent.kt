package com.example.tugas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailAgent : AppCompatActivity() {
    private lateinit var iniNama: TextView
    private lateinit var iniGambar: ImageView
    private lateinit var iniUlti: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_agent)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.valorant)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.title = ""

        iniNama = findViewById(R.id.ini_nama)
        iniGambar = findViewById(R.id.ini_gambar)
        iniUlti = findViewById(R.id.ini_ulti)

        val nama = intent.getStringExtra("Nama")
        val gambar = intent.getIntExtra("Gambar",0)
        val ulti = intent.getStringExtra("Ulti")

        iniNama.text = nama
        iniUlti.text = ulti
        iniGambar.setImageResource(gambar)
    }
}