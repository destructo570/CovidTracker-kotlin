package com.destructo.corona_tracker.global.globalCountry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.R
import com.destructo.corona_tracker.databinding.DataListItemViewBinding
import com.destructo.corona_tracker.model.GlobalCountryStatistics
import com.destructo.corona_tracker.util.formatNumber
import kotlinx.android.synthetic.main.new_list_item.view.*

class FinalAdapter(private val onClickListener: DataClickListener):
    ListAdapter<GlobalCountryStatistics, FinalAdapter.ViewHolder>(
        CountryDiffCallback()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val countryData = getItem(position)
        holder.bind(countryData)
        holder.itemView.setOnClickListener{
            onClickListener.onCLick(countryData)
        }
    }


    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val country:TextView = itemView.findViewById(R.id.country_name_new)
        val infected:TextView = itemView.findViewById(R.id.infected_count_new)
        val increase:TextView = itemView.findViewById(R.id.new_cases_new)

        fun bind(countryData: GlobalCountryStatistics) {
            country.text = countryData.country_name
            infected.text = formatNumber(countryData.total_infected)
            if(countryData.cases_today != null && countryData.cases_today > 0) {
                increase.text = "+" + formatNumber(countryData.cases_today)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                var layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.new_list_item, parent, false)
                return ViewHolder(view)
            }
        }

    }


    class DataClickListener(val clickListener: (country: GlobalCountryStatistics) -> Unit){
        fun onCLick(country: GlobalCountryStatistics) = clickListener(country)
    }

}

class CountryDiffCallback : DiffUtil.ItemCallback<GlobalCountryStatistics>() {
    override fun areItemsTheSame(oldItem: GlobalCountryStatistics, newItem: GlobalCountryStatistics): Boolean {
        return oldItem.country_name == newItem.country_name
    }

    override fun areContentsTheSame(oldItem: GlobalCountryStatistics,
                                    newItem: GlobalCountryStatistics
    ): Boolean {
        return oldItem == newItem
    }

}