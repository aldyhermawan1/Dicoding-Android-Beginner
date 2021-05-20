package com.hermawan.valorantagent

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AgentAdapter(private val listAgents: ArrayList<Agents>) : RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class AgentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_detail)
        var tvRole: TextView = itemView.findViewById(R.id.tv_role)
        var imgAgent: ImageView = itemView.findViewById(R.id.img_agent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_agents, parent, false)
        return AgentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = listAgents[position]
        Glide.with(holder.itemView.context).load(agent.photo).into(holder.imgAgent)
        holder.tvName.text = agent.name
        holder.tvDetail.text = agent.bio
        holder.tvRole.text = agent.role
        if (position % 2 == 1){
            holder.itemView.setBackgroundColor(Color.parseColor("#dcdcdc"))
        }

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listAgents[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listAgents.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Agents)
    }
}