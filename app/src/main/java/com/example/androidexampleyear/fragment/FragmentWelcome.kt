package com.example.androidexampleyear.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexampleyear.R
import com.example.androidexampleyear.databinding.FragmentWelcomeBinding


class FragmentWelcome : Fragment() {

    private lateinit var binding : FragmentWelcomeBinding
    companion object {
        private var instance : FragmentWelcome? = null
        fun newInstance(): FragmentWelcome {
            if(instance == null){
                instance = FragmentWelcome()
            }
            return instance!!
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }


}