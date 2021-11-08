package com.example.intentapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MoveWithObjectActivity : AppCompatActivity() {
    private lateinit var objectDiterima: TextView
    companion object{
        const val ORANG = "orang"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        objectDiterima = findViewById(R.id.object_diterima)

        val person = intent.getParcelableExtra<Person>(ORANG) as Person
        val teks = "Nama = ${person.nama}\nUmur = ${person.umur}\nEmail = ${person.email}\nKota = ${person.city}"
        objectDiterima.text = teks
    }
}