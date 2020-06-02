package com.destructo.corona_tracker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.destructo.corona_tracker.databinding.FragmentAboutBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {

    lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater)

        setSocialLinks()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finish()
        }
    }


    private fun setSocialLinks(){

        binding.devInsta.setOnClickListener {
            context?.getString(R.string.dev_Insta)?.let { it1 -> openLink(it1) }
        }

        binding.devTwitter.setOnClickListener {
            context?.getString(R.string.dev_Twitter)?.let { it1 -> openLink(it1) }
        }

        binding.creditOneGithub.setOnClickListener {
            context?.getString(R.string.credit_one_github)?.let { it1 -> openLink(it1) }
        }

        binding.creditTwoGithub.setOnClickListener {
            context?.getString(R.string.credit_two_github)?.let { it1 -> openLink(it1) }
        }
    }

    private fun openLink(url:String){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = (Uri.parse(url))
        startActivity(intent)
    }

}
