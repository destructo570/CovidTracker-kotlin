package com.destructo.corona_tracker.ui.help

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.Navigation
import com.destructo.corona_tracker.R
import com.destructo.corona_tracker.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHelpBinding.inflate(inflater)

        binding.learnMoreButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_helpFragment_to_covidInfoFragment)
        }

        binding.indiaHelplineButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_helpFragment_to_indiaHelplineContact)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finish()
        }
    }

}
