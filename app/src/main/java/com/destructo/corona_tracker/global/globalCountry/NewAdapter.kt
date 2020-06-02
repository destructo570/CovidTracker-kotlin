package com.destructo.corona_tracker.global.globalCountry

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.R
import com.destructo.corona_tracker.model.GlobalCountryStatistics
import com.destructo.corona_tracker.util.formatNumber

class NewAdapter(var data:List<GlobalCountryStatistics>, val listener: CountryClickListener): RecyclerView.Adapter<NewAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val country: TextView = itemView.findViewById(R.id.data_name)
        val infected: TextView = itemView.findViewById(R.id.infected_count)
        val increaseImg: ImageView = itemView.findViewById(R.id.increase_icon)
        //val increaseTxt: TextView = itemView.findViewById(R.id.new_cases_txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_list_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val countryData = data[position]
        holder.country.text = countryData.country_name
        holder.infected.text = formatNumber(countryData.total_infected)
        //holder.increaseTxt.text = formatNumber(countryData.cases_today)
        if (countryData.cases_today != null && countryData.cases_today > 0 ){
            holder.increaseImg.visibility = View.VISIBLE
            //holder.increaseTxt.visibility = View.VISIBLE
        }else{
            holder.increaseImg.visibility = View.GONE
            //holder.increaseTxt.visibility = View.GONE
        }
        holder.itemView.setOnClickListener{
            listener.onCLick(countryData)
        }

    }
}


class CountryClickListener(val clickListener: (country:GlobalCountryStatistics) -> Unit){
    fun onCLick(country:GlobalCountryStatistics) = clickListener(country)
}