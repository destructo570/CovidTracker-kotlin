package com.destructo.corona_tracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.destructo.corona_tracker.databinding.FragmentIndiaBinding
import com.destructo.corona_tracker.util.adapter.IndiaStateAdapter
import com.destructo.corona_tracker.util.adapter.StateClickListener
import com.destructo.corona_tracker.viewmodel.IndiaViewModel

/**
 * A simple [Fragment] subclass.
 */
class IndiaFragment : Fragment() {

    private val indiaViewModel: IndiaViewModel by lazy {
        ViewModelProvider(this).get(IndiaViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finish()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentIndiaBinding.inflate(inflater)
        binding.include.globalMoreButton.visibility = View.GONE
        binding.setLifecycleOwner(this)

        binding.indiaViewModel = indiaViewModel


        binding.stateRecycler.adapter =
            IndiaStateAdapter(
                StateClickListener {
                    indiaViewModel.onNavigationToStateDetails(it)
                })


        indiaViewModel.navigateToStateDetails.observe(viewLifecycleOwner, Observer {
            if(null != it){
                this.findNavController().navigate(
                    IndiaFragmentDirections.actionCountryFragmentToStateDetailsFragment(
                        it
                    )
                )
                indiaViewModel.doneNavigationToStateDetails()
            }
        })

        return binding.root
    }

}
