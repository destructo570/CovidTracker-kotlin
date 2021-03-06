package com.destructo.corona_tracker.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.destructo.corona_tracker.util.adapter.IndiaStateAdapter
import com.destructo.corona_tracker.util.adapter.HelplineContactAdapter
import com.destructo.corona_tracker.model.ContactNumber
import com.destructo.corona_tracker.model.CountryStatistics
import com.destructo.corona_tracker.model.IndiaStateStatistics
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("stateList")
fun bindRecyclerView(recyclerView: RecyclerView, data:List<IndiaStateStatistics>?){

    val adapter = recyclerView.adapter as IndiaStateAdapter
    data?.let {
        adapter.submitList(data)
    }
}

@BindingAdapter("setGlobalCountryInfected")
fun TextView.setGlobalCountryInfectedForematted(item: CountryStatistics?){
    item?.let {
        text = NumberFormat.getNumberInstance(Locale.US).format(item.total_infected)
    }
}

@BindingAdapter("setGlobalCountry")
fun TextView.setGlobalCountryName(item: CountryStatistics?){
    item?.let {
        text = item.country_name
    }
}

@BindingAdapter("contactList")
fun bindContactList(recyclerView:RecyclerView, data:List<ContactNumber>?){
    val adapter = recyclerView.adapter as HelplineContactAdapter
    data?.let {
        adapter.submitList(data)
    }
}

@BindingAdapter("formattedInteger")
fun TextView.formatNumber(num:Int?){
    if(num != null && num >= 0) {

        text = NumberFormat.getNumberInstance(Locale.US).format(num)
    }else{
        text = "0"
    }
}

@BindingAdapter("formattedDate")
fun TextView.formatDate(date: Long){

    val dateObject = Date(date)
    val dateFormat = SimpleDateFormat("yyyy-MMM-dd hh:mm:ss a", Locale.getDefault())
    text = "LAST UPDATED ON: " + dateFormat.format(dateObject)
}
