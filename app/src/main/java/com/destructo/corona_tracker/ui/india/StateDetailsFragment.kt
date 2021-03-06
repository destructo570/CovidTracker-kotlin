package com.destructo.corona_tracker.ui.india

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.databinding.FragmentIndiaStateDetailsBinding
import com.destructo.corona_tracker.ui.MainActivity
import com.destructo.corona_tracker.viewmodel.india.StateDetailViewModelFactory
import com.destructo.corona_tracker.viewmodel.india.StateDetailViewModel

class StateDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentIndiaStateDetailsBinding.inflate(inflater)
        val stateSummary = StateDetailsFragmentArgs.fromBundle(
            requireArguments()
        ).stateSummary

        val viewModelFactory =
            StateDetailViewModelFactory(
                stateSummary,
                application
            )

        val viewModel = ViewModelProvider(this, viewModelFactory).get(StateDetailViewModel::class.java)

        binding.setLifecycleOwner(this)

        viewModel.stateSummary.observe(viewLifecycleOwner, Observer {
            binding.stateSummary = it
            it.state_name?.let { it1 -> setTitle(it1) }
        })

        return binding.root
        }

    private fun setTitle(title: String){
        (requireActivity() as MainActivity).title = title

    }
    }