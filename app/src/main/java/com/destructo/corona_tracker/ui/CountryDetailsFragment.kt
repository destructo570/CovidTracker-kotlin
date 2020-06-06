package com.destructo.corona_tracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.databinding.FragmentCountryDetailsBinding
import com.destructo.corona_tracker.viewmodel.CountryDetailViewModelFactory
import com.destructo.corona_tracker.viewmodel.GlobalCountryDetailViewModel

/**
 * A simple [Fragment] subclass.
 */
class CountryDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentCountryDetailsBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        val selectedCountry = CountryDetailsFragmentArgs.fromBundle(
            requireArguments()
        ).countrySummary
        val viewModelFactory =
            CountryDetailViewModelFactory(
                selectedCountry,
                application
            )

        val viewModel = ViewModelProvider(this, viewModelFactory).get(GlobalCountryDetailViewModel::class.java)

        viewModel.SelectedCountry.observe(viewLifecycleOwner, Observer {
            binding.countrySummaryData = it
            setTitle(it.country_name)
        })




        return binding.root
    }

    private fun setTitle(title: String) {
        (requireActivity() as MainActivity).title = title
    }

}
