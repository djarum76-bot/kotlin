package com.example.tugas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugas.databinding.HalamanListBinding

class ListAgentAdapter(private val listAgent: ArrayList<Agent>): RecyclerView.Adapter<ListAgentAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = HalamanListBinding.bind(itemView)

        fun detailData(data: Agent){
            binding.iniNama.text = data.nama
            binding.iniUlti.text = data.ulti
            binding.iniGambar.setImageResource(data.gambar)

            binding.iniNama.rootView.setOnClickListener {
                val pindah = Intent(itemView.context,DetailAgent::class.java)
                pindah.putExtra("Nama",data.nama)
                pindah.putExtra("Gambar",data.gambar)
                pindah.putExtra("Ulti",data.ulti)
                itemView.context.startActivity(pindah)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.halaman_list,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val agent = listAgent[position]

        Glide.with(holder.itemView.context)
            .load(agent.gambar)
            .apply(RequestOptions().override(55,55))
            .into(holder.binding.iniGambar)

        holder.binding.iniNama.text = agent.nama
        holder.binding.iniUlti.text = agent.ulti
        holder.detailData(agent)
    }

    override fun getItemCount(): Int {
        return  listAgent.size
    }
}