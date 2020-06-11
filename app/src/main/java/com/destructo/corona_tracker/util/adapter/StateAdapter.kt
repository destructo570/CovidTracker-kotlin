package com.destructo.corona_tracker.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.databinding.StateDataListItemViewBinding
import com.destructo.corona_tracker.model.IndiaStateStats
import java.text.NumberFormat
import java.util.*

class IndiaStateAdapter(private val clickListener: StateClickListener): ListAdapter<IndiaStateStats,
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

        fun bind(stateData: IndiaStateStats) {
            binding.stateName.text = stateData.state
            if(stateData.cases != null ) {
                binding.stateInfectedCount.text = NumberFormat.getInstance(Locale.US).format(stateData.cases)
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

class IndiaStateDiffCallback:DiffUtil.ItemCallback<IndiaStateStats>(){
    override fun areItemsTheSame(oldItem: IndiaStateStats, newItem: IndiaStateStats): Boolean {
        return oldItem.state == newItem.state
    }

    override fun areContentsTheSame(oldItem: IndiaStateStats, newItem: IndiaStateStats): Boolean {
        return oldItem == newItem
    }

}

class StateClickListener(val clickListener: (state:IndiaStateStats) -> Unit){
    fun onClick(state: IndiaStateStats) = clickListener(state)
}