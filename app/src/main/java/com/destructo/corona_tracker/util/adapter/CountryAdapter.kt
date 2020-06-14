package com.destructo.corona_tracker.util.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.model.CountryStatistics
import com.destructo.corona_tracker.databinding.CountryListItemViewBinding

class CountryAdapter (private val onClickListener: CountryClickListener):
    ListAdapter<CountryStatistics, CountryAdapter.ViewHolder>(
        GlobalCountryDiffCallback()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val countryData = getItem(position)
        holder.bind(countryData)
        holder.itemView.setOnClickListener{
            onClickListener.onCLick(countryData)
        }
    }


    class ViewHolder private constructor(val binding: CountryListItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(countryData: CountryStatistics) {
            if (countryData.cases_today != null && countryData.cases_today > 0 ){
                binding.increaseIcon.visibility = View.VISIBLE
                binding.newCasesTxt.visibility = View.VISIBLE
            }else{
                binding.increaseIcon.visibility = View.GONE
                binding.newCasesTxt.visibility = View.GONE
            }
            binding.countryStatistics = countryData
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                var layoutInflater = LayoutInflater.from(parent.context)
                val binding = CountryListItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }

    }


    class CountryClickListener(val clickListener: (country:CountryStatistics) -> Unit){
        fun onCLick(country:CountryStatistics) = clickListener(country)
    }

}

class GlobalCountryDiffCallback : DiffUtil.ItemCallback<CountryStatistics>() {
    override fun areItemsTheSame(oldItem: CountryStatistics, newItem: CountryStatistics): Boolean {
        return oldItem.country_name == newItem.country_name
    }

    override fun areContentsTheSame(oldItem: CountryStatistics,
                                    newItem: CountryStatistics): Boolean {
        return oldItem == newItem
    }

}
