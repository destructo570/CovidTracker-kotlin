package com.destructo.corona_tracker.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.databinding.StateDataListItemViewBinding
import com.destructo.corona_tracker.model.IndiaStateStatistics
import com.destructo.corona_tracker.model.IndiaStateStats
import java.text.NumberFormat
import java.util.*

class IndiaStateAdapter(private val clickListener: StateClickListener): ListAdapter<IndiaStateStatistics,
        IndiaStateAdapter.ViewHolder>(
    IndiaStateDiffCallback()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stateData = getItem(position)
        holder.bind(stateData)
        holder.itemView.setOnClickListener {
            clickListener.onClick(stateData)
        }
    }

    class ViewHolder(val binding: StateDataListItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(stateData: IndiaStateStatistics) {
            binding.stateName.text = stateData.state_name
            if(stateData.total_cases != null ) {
                binding.stateInfectedCount.text = NumberFormat.getInstance(Locale.US).format(stateData.total_cases)
            }else{
                binding.stateInfectedCount.text = "null"
            }

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                var layoutInflater = LayoutInflater.from(parent.context)
                val binding = StateDataListItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }

    }

}

class IndiaStateDiffCallback:DiffUtil.ItemCallback<IndiaStateStatistics>(){
    override fun areItemsTheSame(oldItem: IndiaStateStatistics, newItem: IndiaStateStatistics): Boolean {
        return oldItem.state_name == newItem.state_name
    }

    override fun areContentsTheSame(oldItem: IndiaStateStatistics, newItem: IndiaStateStatistics): Boolean {
        return oldItem == newItem
    }

}

class StateClickListener(val clickListener: (state:IndiaStateStatistics) -> Unit){
    fun onClick(state: IndiaStateStatistics) = clickListener(state)
}