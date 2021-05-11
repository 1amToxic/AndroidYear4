package com.example.androidexampleyear.fragment

import android.content.Context.MODE_PRIVATE
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.androidexampleyear.R
import com.example.androidexampleyear.databinding.FragmentStartBinding
import java.util.*


class StartFragment : Fragment() {
    private lateinit var binding : FragmentStartBinding

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(inflater,container,false)


        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun updateResource(s: String) {
        val locale = Locale(s)
        Locale.setDefault(locale)
        var configuration = Configuration(resources.configuration)
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration,resources.displayMetrics)
        val prefLang = requireActivity().getSharedPreferences("LANG", MODE_PRIVATE)
        prefLang.edit().putString("lang",s).apply()
        findNavController().navigate(R.id.detailFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConfirm.setOnClickListener {
            if(binding.rbVietnam.isChecked){
                Toast.makeText(requireContext(),"VI",Toast.LENGTH_SHORT).show()
                updateResource("vi")
            }
            if(binding.rbEnglish.isChecked){
                Toast.makeText(requireContext(),"EN",Toast.LENGTH_SHORT).show()
                updateResource("en")
            }
            if(binding.rbGermany.isChecked){
                Toast.makeText(requireContext(),"DE",Toast.LENGTH_SHORT).show()
                updateResource("de")
            }
        }
    }
}