package com.example.canteenapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.canteenapp.R
import com.example.canteenapp.model.ItemModel
import java.lang.StringBuilder


public class MyItemAdapter(
    private val context: Context,
    private val list:List<ItemModel>
    ): RecyclerView.Adapter<MyItemAdapter.MyItemViewHolder>(){

        class MyItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var imageView: ImageView?=null
            var txtName: TextView?=null
            var txtPrice: TextView?=null

            init{
                imageView=itemView.findViewById(R.id.imageView) as ImageView
                txtName=itemView.findViewById(R.id.txtName) as TextView
                txtPrice=itemView.findViewById(R.id.txtPrice) as TextView
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemViewHolder {
        return MyItemViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.layout_item_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyItemViewHolder, position: Int) {
        Glide.with(context)
            .load(list[position].image)
            .into(holder.imageView!!)
        holder.txtName!!.text = StringBuilder().append(list[position].name)
        holder.txtPrice!!.text = StringBuilder("$").append(list[position].price)
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        //return list.size;
    }
}