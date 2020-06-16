package com.destructo.corona_tracker.viewmodel.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.destructo.corona_tracker.model.ContactNumber


class HelplineViewModel:ViewModel() {

    private val _stateContactNumberList = MutableLiveData<List<ContactNumber>>()
    val stateContactNumberList:LiveData<List<ContactNumber>>
    get() = _stateContactNumberList

    init {
        val numbers = mutableListOf<ContactNumber>()
        numbers.add(ContactNumber("Andaman and Nicobar Islands", "+91-3192-232102"))
        numbers.add(ContactNumber("Andhra Pradesh", "+91-866-2410978"))
        numbers.add(ContactNumber("Arunachal Pradesh", "+91-9436055743"))
        numbers.add(ContactNumber("Assam", "+91-6913347770"))
        numbers.add(ContactNumber("Bihar", "104"))
        numbers.add(ContactNumber("Chandigarh", "+91-9779558282"))
        numbers.add(ContactNumber("Chhattisgarh", "104"))
        numbers.add(ContactNumber("Dadra and Nagar Haveli", "104"))
        numbers.add(ContactNumber("Daman & Diu", "104"))
        numbers.add(ContactNumber("Delhi", "+91-11-22307145"))
        numbers.add(ContactNumber("Goa", "104"))
        numbers.add(ContactNumber("Gujarat", "104"))
        numbers.add(ContactNumber("Haryana", "+91-8558893911"))
        numbers.add(ContactNumber("Himachal Pradesh", "104"))
        numbers.add(ContactNumber("Jammu and Kashmir", "+91-191-2520982"))
        numbers.add(ContactNumber("Jammu and Kashmir", "+91-194-2440283"))
        numbers.add(ContactNumber("Jharkhand", "104"))
        numbers.add(ContactNumber("Karnataka", "104"))
        numbers.add(ContactNumber("Kerala", "+91-471-2552056"))
        numbers.add(ContactNumber("Ladakh", "+91-1982-256462"))
        numbers.add(ContactNumber("Lakshadweep", "104"))
        numbers.add(ContactNumber("Madhya Pradesh", "+91-755-2527177"))
        numbers.add(ContactNumber("Maharashtra", "+91-20-26127394"))
        numbers.add(ContactNumber("Manipur", "+91-3852411668"))
        numbers.add(ContactNumber("Meghalaya", "108"))
        numbers.add(ContactNumber("Mizoram", "102"))
        numbers.add(ContactNumber("Nagaland", "+91-7005539653"))
        numbers.add(ContactNumber("Odisha", "+91-9439994859"))
        numbers.add(ContactNumber("Puducherry", "104"))
        numbers.add(ContactNumber("Punjab", "104"))
        numbers.add(ContactNumber("Rajasthan", "+91-141-2225624"))
        numbers.add(ContactNumber("Sikkim", "104"))
        numbers.add(ContactNumber("Tamil Nadu", "+91-44-29510500"))
        numbers.add(ContactNumber("Telengana", "104"))
        numbers.add(ContactNumber("Tripura", "+91-381-2315879"))
        numbers.add(ContactNumber("Uttarakhand", "104"))
        numbers.add(ContactNumber("Uttar Pradesh", "18001805145"))
        numbers.add(ContactNumber("West Bengal", "1800313444222"))
        numbers.add(ContactNumber("West Bengal", "+91-3323412600"))

        _stateContactNumberList.value = numbers

    }

}