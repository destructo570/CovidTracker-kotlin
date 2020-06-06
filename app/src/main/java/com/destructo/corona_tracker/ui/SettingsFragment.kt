package com.destructo.corona_tracker.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.destructo.corona_tracker.R

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val darkModeSelection = findPreference<ListPreference>("darkModeSetting")
        val creditsItem = findPreference<Preference>("credits")

        creditsItem?.setOnPreferenceClickListener {
            return@setOnPreferenceClickListener false
        }

        checkDarkMode(darkModeSelection)

        darkModeSelection?.setOnPreferenceChangeListener { _, newValue ->

            when(newValue){
                "Enabled" -> {enableDarkMode(DarkModeConfig.ENABLE)

                }
                "Disabled" -> {enableDarkMode(DarkModeConfig.DISABLE)
                }
                "System Dependent" -> {enableDarkMode(DarkModeConfig.FOLLOW_SYSTEM)
                }

            }

            return@setOnPreferenceChangeListener false
        }

    }


    fun enableDarkMode(darkModeConfig: DarkModeConfig){
        when(darkModeConfig){
            DarkModeConfig.ENABLE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            DarkModeConfig.DISABLE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            DarkModeConfig.FOLLOW_SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    private fun checkDarkMode(selected: ListPreference?){
        val mode = context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        when (mode) {
            Configuration.UI_MODE_NIGHT_YES -> {
                selected?.value = R.string.enabled.toString()
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                selected?.value = R.string.enabled.toString()
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                selected?.value = R.string.enabled.toString()
            }
        }
    }

}
