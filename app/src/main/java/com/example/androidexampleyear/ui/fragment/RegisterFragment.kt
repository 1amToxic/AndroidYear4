package com.example.androidexampleyear.ui.fragment

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.androidexampleyear.R
import com.example.androidexampleyear.database.service.UserService
import com.example.androidexampleyear.databinding.FragmentRegisterBinding
import com.example.androidexampleyear.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding
    lateinit var userService : UserService
    lateinit var preF : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preF = requireActivity().getSharedPreferences("USER",MODE_PRIVATE)
        userService = UserService(requireContext())
        binding.btnRegister.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val user = userService.checkLogin(
                    binding.editUsernameR.text.toString(),
                    binding.editPasswordR.text.toString()
                )
                withContext(Dispatchers.Main){
                    if(user == null){
                        userService.insertUser(User(0,
                            binding.editUsernameR.text.toString(),
                            binding.editPasswordR.text.toString()))
                        val userRe = userService.checkLogin(
                            binding.editUsernameR.text.toString(),
                            binding.editPasswordR.text.toString()
                        )
                        withContext(Dispatchers.Main){
                         preF.edit().putInt("id", userRe!!.id).apply()
                        }
                        findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
                    }else{
                        Toast.makeText(requireContext(),"This user is exist",Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
                    }
                }
            }


        }
    }
}