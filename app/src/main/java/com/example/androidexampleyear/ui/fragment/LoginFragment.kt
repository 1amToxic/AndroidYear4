package com.example.androidexampleyear.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.androidexampleyear.R
import com.example.androidexampleyear.database.UserDao
import com.example.androidexampleyear.database.service.UserService
import com.example.androidexampleyear.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private lateinit var userService: UserService
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userService = UserService(requireContext())
        val preF = requireActivity().getSharedPreferences("USER", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val user = userService.checkLogin(
                    binding.editUsername.text.toString(),
                    binding.editPassword.text.toString()
                )
                withContext(Dispatchers.Main){
                    if(user!=null){
                        preF.edit().putInt("id", user.id).apply()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }else{
                        Toast.makeText(requireContext(),"No valid user found",Toast.LENGTH_SHORT).show()
                    }
                }
            }



        }
        binding.btnGoToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}