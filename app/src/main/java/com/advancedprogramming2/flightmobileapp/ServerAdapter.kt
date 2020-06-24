package com.advancedprogramming2.flightmobileapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_server_child.view.*

class ServerAdapter( private val context: Context) : RecyclerView.Adapter<ServerAdapter.ViewHolder>() {

    private var list: List<ServerEntity> = ArrayList()
    private var urlSelected: String = ""

    fun setLocationList(list: List<ServerEntity>){
        this.list = list
        notifyDataSetChanged()
    }

    fun setURLSelected(url:String){
        this.urlSelected = url
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].url
        holder.rootView.setOnClickListener {
            this.setURLSelected(list[position].url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rv_server_child,
                parent,
                false
            )
        )
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name = v.tv_server_url!!
        val rootView = v.child_root!!
    }

}