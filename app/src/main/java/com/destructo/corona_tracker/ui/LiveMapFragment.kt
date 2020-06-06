package com.destructo.corona_tracker.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.destructo.corona_tracker.databinding.FragmentLiveMapBinding

/**
 * A simple [Fragment] subclass.
 */
class LiveMapFragment : Fragment() {

    private lateinit var binding: FragmentLiveMapBinding
    private lateinit var callback: OnBackPressedCallback

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveMapBinding.inflate(inflater)

        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setForceDark(
                binding.liveMapView.settings,
                WebSettingsCompat.FORCE_DARK_ON
            );
        }
        val webSettings = binding.liveMapView.settings
        webSettings.javaScriptEnabled = true
        binding.liveMapView.webViewClient = WebViewClient()
        binding.liveMapView.loadUrl("https://www.bing.com/covid")

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.liveMapView.canGoBack()) {
                    binding.liveMapView.goBack()
                } else {
                    requireActivity().finish()
                }
            }
        }
    requireActivity().onBackPressedDispatcher.addCallback(this, callback)
}
    }

