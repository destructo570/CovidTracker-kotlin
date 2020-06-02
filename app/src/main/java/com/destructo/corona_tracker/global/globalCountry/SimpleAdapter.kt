package com.destructo.corona_tracker.global.globalCountry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.R
import com.destructo.corona_tracker.model.GlobalCountryStatistics

class SimpleAdapter(var data:List<GlobalCountryStatistics>): RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: SimpleAdapter.ViewHolder, position: Int) {
        holder.text.text = data[position].country_name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.country_name)
    }
}