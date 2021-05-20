package com.hermawan.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.textName)
        var textDetail: TextView = itemView.findViewById(R.id.textDetail)
        var imgHero: ImageView = itemView.findViewById(R.id.imgHero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        Glide.with(holder.itemView.context).load(hero.photo).apply(RequestOptions().override(55,55)).into(holder.imgHero)
        holder.textName.text = hero.name
        holder.textDetail.text = hero.detail
        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}