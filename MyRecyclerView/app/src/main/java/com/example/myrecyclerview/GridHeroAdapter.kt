package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.databinding.ItemGridHeroBinding

class GridHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {
    private var onItemClickCallBack: OnItemClickCallBack? = null

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroAdapter.GridViewHolder {
        val binding = ItemGridHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridHeroAdapter.GridViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class GridViewHolder(private val binding: ItemGridHeroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero){
            with(binding){
                Glide.with(itemView.context)
                        .load(hero.photo)
                        .apply(RequestOptions().override(350,550))
                        .into(imgItemPhoto)

                itemView.setOnClickListener { onItemClickCallBack?.onItemClicked(hero) }
            }
        }
    }

    interface OnItemClickCallBack {
        fun onItemClicked(hero: Hero)
    }
}