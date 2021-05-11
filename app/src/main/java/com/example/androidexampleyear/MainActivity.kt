package com.example.androidexampleyear

import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.androidexampleyear.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val prefLanguage = getSharedPreferences("LANG", MODE_PRIVATE)
        val langNow  = prefLanguage.getString("lang",null)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        langNow?.let {
            updateResource(langNow)
            navController.navigate(R.id.detailFragment)
        }
    }
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun updateResource(s: String) {
        val locale = Locale(s)
        Locale.setDefault(locale)
        var configuration = Configuration(resources.configuration)
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration,resources.displayMetrics)
        val prefLang = getSharedPreferences("LANG", MODE_PRIVATE)
        prefLang.edit().putString("lang",s).apply()
    }
}