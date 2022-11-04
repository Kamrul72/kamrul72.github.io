package com.example.assignment05prob03

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter (var context: Context, var text1 :Array<String>, var text2:Array<String>, var img:IntArray, var text3 : Array<String>,var text4 : Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)

    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.playout.tvTitle.text = text1[position]
        holder.itemView.playout.tvPrice.text = "price : "+ text2[position]
        holder.itemView.playout.tvColor.text ="Colo: r"+ text3[position]
        holder.itemView.playout.imageView.setImageResource(img[position])

         if (position%2==0)holder.itemView.playout.setBackgroundColor(Color.LTGRAY)
         else holder.itemView.playout.setBackgroundColor(Color.rgb(240,240,240))
        holder.itemView.playout.setPadding(10)

        holder.itemView.playout.setOnClickListener{
            val intent = Intent(context, ProductDetailActivity::class.java)

            var res = text1[position]
            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()

            intent.putExtra("image", img[position])
            intent.putExtra("name", text1[position])
            intent.putExtra("detail",text4[position])
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return text1.size
    }



    inner  class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}

