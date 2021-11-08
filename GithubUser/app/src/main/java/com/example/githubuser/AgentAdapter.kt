package com.example.githubuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.githubuser.databinding.ItemAgentBinding

class AgentAdapter internal constructor(private val context: Context): BaseAdapter(){
    internal var agents = arrayListOf<Agent>()
    override fun getCount(): Int {
        return agents.size
    }

    override fun getItem(position: Int): Any {
        return agents[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_agent, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val agent = getItem(position) as Agent
        viewHolder.bind(agent)
        return itemView
    }

    inner class ViewHolder internal constructor(view: View){
        val binding =  ItemAgentBinding.bind(view)

        internal fun bind(agent: Agent){
            binding.txtName.text = agent.nama
            binding.txtDeskripsi.text = agent.deskripsi
            binding.txtUsernama.text = agent.username
            binding.imgPhoto.setImageResource(agent.photo)
        }
    }
}