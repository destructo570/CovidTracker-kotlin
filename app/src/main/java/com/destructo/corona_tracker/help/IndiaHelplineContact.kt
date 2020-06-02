package com.destructo.corona_tracker.help

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.destructo.corona_tracker.databinding.FragmentIndiaHelplineContactBinding


/**
 * A simple [Fragment] subclass.
 */
class IndiaHelplineContact : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentIndiaHelplineContactBinding.inflate(inflater)

        binding.setLifecycleOwner(this)

        val helpLineViewModel = ViewModelProvider(this).get(HelplineViewModel::class.java)
        binding.helpLineViewModel = helpLineViewModel
        binding.helplineRecycler.adapter =
            HelplineContactAdapter(
                ContactClickListener {
                    callNumber(it.contact_number)
                })
        return binding.root
    }

    private fun callNumber(number: String){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:" + number)
        startActivity(intent)
    }

}
