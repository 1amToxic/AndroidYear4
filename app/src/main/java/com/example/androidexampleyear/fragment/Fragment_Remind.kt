package com.example.androidexampleyear.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidexampleyear.R
import com.example.androidexampleyear.databinding.FragmentRemindBinding

class Fragment_Remind : Fragment() {
    lateinit var binding: FragmentRemindBinding

    companion object{
        var instance :  Fragment_Remind? = null
        fun newInstance() : Fragment_Remind{
            if(instance == null){
                instance = Fragment_Remind()
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
        binding = FragmentRemindBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }


}