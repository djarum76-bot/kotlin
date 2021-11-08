package com.example.tugas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var iniRV: RecyclerView
    private val list: ArrayList<Agent> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.valorant)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.title = ""

        iniRV = findViewById(R.id.ini_rv)
        iniRV.setHasFixedSize(true)

        list.addAll(AgentData.listData)
        tampilanRecycler()
    }

    private fun tampilanRecycler() {
        iniRV.layoutManager = LinearLayoutManager(this)
        val listAgentAdapter = ListAgentAdapter(list)
        iniRV.adapter = listAgentAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.ini_about){
            val about = Intent(this@MainActivity, AboutPage::class.java)
            startActivity(about)
        }
        return super.onOptionsItemSelected(item)
    }
}