package com.destructo.corona_tracker.util.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.databinding.DataListItemViewBinding
import com.destructo.corona_tracker.model.GlobalCountryStatistics

class GlobalCountryAdapter (private val onClickListener: GlobalClickListener):
    ListAdapter<GlobalCountryStatistics, GlobalCountryAdapter.ViewHolder>(
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


    class ViewHolder private constructor(val binding: DataListItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(countryData: GlobalCountryStatistics) {
            if (countryData.cases_today != null && countryData.cases_today > 0 ){
                binding.increaseIcon.visibility = View.VISIBLE
                binding.newCasesTxt.visibility = View.VISIBLE
            }else{
                binding.increaseIcon.visibility = View.GONE
                binding.newCasesTxt.visibility = View.GONE
            }
            binding.globalCountryData = countryData
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                var layoutInflater = LayoutInflater.from(parent.context)
                val binding = DataListItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }

    }


    class GlobalClickListener(val clickListener: (country:GlobalCountryStatistics) -> Unit){
        fun onCLick(country:GlobalCountryStatistics) = clickListener(country)
    }

}

class GlobalCountryDiffCallback : DiffUtil.ItemCallback<GlobalCountryStatistics>() {
    override fun areItemsTheSame(oldItem: GlobalCountryStatistics, newItem: GlobalCountryStatistics): Boolean {
        return oldItem.country_name == newItem.country_name
    }

    override fun areContentsTheSame(oldItem: GlobalCountryStatistics,
     newItem: GlobalCountryStatistics): Boolean {
        return oldItem == newItem
    }

}
