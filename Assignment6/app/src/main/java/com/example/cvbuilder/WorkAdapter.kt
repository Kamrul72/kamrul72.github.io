package com.example.cvbuilder

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*

class WorkAdapter ( var text1 :ArrayList<String>, var text2:ArrayList<String>, var img:ArrayList<Int>, var text3 :ArrayList<String>) : RecyclerView.Adapter<WorkAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout,parent,false)
        return MyViewHolder(view)

    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.playout.tv1.text = text1[position]
        holder.itemView.playout.tv2.text =  text2[position]
        holder.itemView.playout.tv3.text = text3[position]
        holder.itemView.playout.imageView.setImageResource(img[position])





    }

    override fun getItemCount(): Int {
        return text1.size
    }



    inner  class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}