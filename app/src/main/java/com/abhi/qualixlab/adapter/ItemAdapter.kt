package com.abhi.qualixlab.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.abhi.qualixlab.AdapterOnClick
import com.abhi.qualixlab.R

class ItemAdapter (val optionArrayList: ArrayList<String>,val context: Activity,val adapterOnClick: AdapterOnClick) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_option, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return optionArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.optionTittle.text=optionArrayList[position]
        holder.lnOptionView.setOnClickListener {

        adapterOnClick.onClick(optionArrayList[position])}
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val optionTittle = itemView.findViewById(R.id.tvOption) as TextView
        val lnOptionView = itemView.findViewById(R.id.lnOptionView) as LinearLayout


    }
}