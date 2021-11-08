package com.example.intentapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MoveDataActivity : AppCompatActivity() {
    private lateinit var dataDiterima: TextView
    companion object{
        const val NAMA = "nama"
        const val UMUR = "umur"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data)

        dataDiterima = findViewById(R.id.data_diterima)

        val nama = intent.getStringExtra(NAMA)
        val umur = intent.getIntExtra(UMUR,0)

        val akhir = "Nama = $nama\nUmur = $umur"
        dataDiterima.text = akhir
    }
}