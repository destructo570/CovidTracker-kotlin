package com.destructo.corona_tracker.ui.global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.databinding.FragmentGlobalDetailsBinding
import com.destructo.corona_tracker.viewmodel.global.GlobalDetailsViewModel
import com.destructo.corona_tracker.viewmodel.global.GlobalDetailViewModelFactory

class GlobalDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentGlobalDetailsBinding.inflate(inflater)
        
        val globalSummary = GlobalDetailsFragmentArgs.fromBundle(
            requireArguments()
        ).globalSummary
        val viewModelFactory =
            GlobalDetailViewModelFactory(
                globalSummary,
                application
            )

        val viewModel = ViewModelProvider(this, viewModelFactory).get(GlobalDetailsViewModel::class.java)

        viewModel.globalSummaryData.observe(viewLifecycleOwner, Observer {
            binding.globalSummaryData = it
        })

        return binding.root
        }
    }

