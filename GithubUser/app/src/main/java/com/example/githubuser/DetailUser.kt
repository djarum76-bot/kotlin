package com.example.githubuser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailUser : AppCompatActivity() {

    companion object{
        const val TETAP = "tetap"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val iniGambar : ImageView = findViewById(R.id.ini_gambar)
        val iniNama : TextView = findViewById(R.id.ini_nama)
        val iniUsernama: TextView = findViewById(R.id.ini_usernama)

        val agent = intent.getParcelableExtra<Agent>(TETAP) as Agent

        iniGambar.setImageResource(agent.photo)
        iniNama.text = agent.nama
        iniUsernama.text = agent.username
    }
}