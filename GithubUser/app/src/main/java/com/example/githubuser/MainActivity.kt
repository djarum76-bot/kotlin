package com.example.githubuser

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AgentAdapter
    private lateinit var dataNama: Array<String>
    private lateinit var dataDeskripsi: Array<String>
    private lateinit var dataFoto: TypedArray
    private lateinit var dataUser: Array<String>
    private var agents = arrayListOf<Agent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AgentAdapter(this)
        binding.lvList.adapter = adapter

        binding.lvList.setOnClickListener {
            for (position in dataNama.indices){
                val data = agents[position]
                val go = Intent(applicationContext, DetailUser::class.java)
                go.putExtra(DetailUser.TETAP, data)
                startActivity(go)
            }
        }

        prepare()
        addItem()
    }

    private fun addItem() {
        for(position in dataNama.indices){
            val agent = Agent(
                dataNama[position],
                dataUser[position],
                dataDeskripsi[position],
                dataFoto.getResourceId(position,-1),
            )
            agents.add(agent)
        }
        adapter.agents = agents
    }

    private fun prepare() {
        dataNama = resources.getStringArray(R.array.data_name)
        dataUser = resources.getStringArray(R.array.data_username)
        dataDeskripsi = resources.getStringArray(R.array.data_description)
        dataFoto = resources.obtainTypedArray(R.array.data_photo)
    }
}