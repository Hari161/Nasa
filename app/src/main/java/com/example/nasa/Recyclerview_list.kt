package com.example.nasa

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasa.Response.NasamainresponseItem

class Recyclerview_list (
    private val response_item: ArrayList<NasamainresponseItem>, context1: Context, val onItemClickListener: OnItemClickListener

) : RecyclerView.Adapter<Recyclerview_list.ViewHolder>() {
private val context : Context = context1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listing, parent, false)
        return ViewHolder(view)
    }
    interface OnItemClickListener {
        fun onItemClick(bundle :Bundle)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.lay_click.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("hdurl",response_item[position].hdurl)
            bundle.putString("title",response_item[position].title)
            bundle.putString("date",response_item[position].date)
            bundle.putString("desc",response_item[position].explanation)
            onItemClickListener.onItemClick(bundle)}
        holder.title.text = response_item[position].title
        holder.date.text = response_item[position].date
        Glide.with(context).load(response_item[position].hdurl)
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return response_item.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image: ImageView = itemView.findViewById(R.id.img_iv)
        val title: TextView = itemView.findViewById(R.id.title_tv)
        val date: TextView = itemView.findViewById(R.id.date_tv)
        val lay_click : ConstraintLayout = itemView.findViewById(R.id.header)
    }
}