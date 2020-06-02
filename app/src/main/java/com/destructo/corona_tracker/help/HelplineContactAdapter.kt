package com.destructo.corona_tracker.help

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.databinding.HelplineNumberItemBinding
import com.destructo.corona_tracker.model.ContactNumber

class HelplineContactAdapter(private val clickListener: ContactClickListener) :
    ListAdapter<ContactNumber, HelplineContactAdapter.ViewHolder>(
        HelplineContactDiff()
    ) {

    class ViewHolder(val binding: HelplineNumberItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HelplineNumberItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }

        fun bind(contact: ContactNumber?) {
            binding.contactNumber = contact
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNumber = getItem(position)
        holder.bind(currentNumber)
        holder.itemView.setOnClickListener {
            clickListener.onClick(currentNumber)
        }

    }

}


class HelplineContactDiff : DiffUtil.ItemCallback<ContactNumber>() {
    override fun areItemsTheSame(oldItem: ContactNumber, newItem: ContactNumber): Boolean {
        return oldItem.owner == newItem.owner
    }

    override fun areContentsTheSame(oldItem: ContactNumber, newItem: ContactNumber): Boolean {
        return oldItem == newItem
    }

}

class ContactClickListener(val contact: (ContactNumber) -> Unit) {
    fun onClick(selectedContact: ContactNumber) = contact(selectedContact)
}
