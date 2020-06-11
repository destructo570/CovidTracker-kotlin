package com.destructo.corona_tracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.destructo.corona_tracker.databinding.FragmentCovidInfoBinding

/**
 * A simple [Fragment] subclass.
 */
class CovidInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCovidInfoBinding.inflate(inflater)
        return binding.root
    }

}