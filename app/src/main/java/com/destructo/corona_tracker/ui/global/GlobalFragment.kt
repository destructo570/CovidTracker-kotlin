package com.destructo.corona_tracker.ui.global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.destructo.corona_tracker.databinding.FragmentGlobalBinding
import com.destructo.corona_tracker.util.adapter.CountryAdapter
import com.destructo.corona_tracker.viewmodel.global.GlobalViewModel

class GlobalFragment : Fragment() {

    private val mglobalViewModel: GlobalViewModel by lazy {
        ViewModelProvider(this).get(GlobalViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentGlobalBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        binding.globalViewModel = mglobalViewModel


        mglobalViewModel.countryStats.observe(viewLifecycleOwner, Observer {

            val adap = CountryAdapter(
                CountryAdapter.CountryClickListener {
                    mglobalViewModel.navigationToCountryDetail(it)
                })
            adap.submitList(it)
            binding.countryRecycler.adapter = adap

        })

        mglobalViewModel.navigateToCountryDetail.observe(viewLifecycleOwner, Observer {
            if (null != it){
                this.findNavController().navigate(
                    GlobalFragmentDirections.actionGlobalFragmentToCountryDetailsFragment2(
                        it
                    )
                )
                mglobalViewModel.doneNavigationToCountryDetail() }
        })

        mglobalViewModel.globalStats.observe(viewLifecycleOwner, Observer { globalSummary ->
            if (null != globalSummary){
                binding.include.globalMoreButton.setOnClickListener{
                    this.findNavController().navigate(
                        GlobalFragmentDirections.actionGlobalFragmentToGlobalSummaryDetailsFragment(
                            globalSummary
                        )
                    )
                }
            }
        })

        return binding.root
    }

}
