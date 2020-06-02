package com.destructo.corona_tracker.util

import java.text.NumberFormat
import java.util.*

fun formatNumber(num: Int?): String{

    if(num != null){
        return  NumberFormat.getNumberInstance(Locale.US).format(num)
    }else{
        return "null"
    }
}

fun formatNumber(num: Double?): String{

    if(num != null){
        return  NumberFormat.getNumberInstance(Locale.US).format(num)
    }else{
        return "null"

    }}

fun formatNumber(num: Long?): String{

    if(num != null){
        return NumberFormat.getNumberInstance(Locale.US).format(num)
    }else{
        return "null"

    }}