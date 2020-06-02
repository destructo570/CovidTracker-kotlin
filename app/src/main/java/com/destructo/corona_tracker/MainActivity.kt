package com.destructo.corona_tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.destructo.corona_tracker.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

enum class DarkModeConfig {
    ENABLE,
    DISABLE,
    FOLLOW_SYSTEM
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        val navController = findNavController(R.id.nav_host_fragment)
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener {
                _, destination, _ ->

            title = when(destination.id){
                R.id.globalFragment -> "Global Statistics"
                R.id.countryFragment -> "India Statistics"
                R.id.livemapFragment -> "Live Map"
                R.id.helpFragment -> "Help and Information"
                R.id.aboutFragment -> "About App"
                R.id.globalSummaryDetailsFragment -> "Global Statistics"
                R.id.covidInfoFragment -> "Help and Information"
                R.id.indiaHelplineContact -> "Helpline Numbers"
                else -> "Covid Tracker"

            }
        }


    }

}
