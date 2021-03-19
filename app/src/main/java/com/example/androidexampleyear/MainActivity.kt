package com.example.androidexampleyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.androidexampleyear.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),MainActivityPresenter.MainView {
    lateinit var binding : ActivityMainBinding
    lateinit var presenter: MainActivityPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = MainActivityPresenter(this)
        binding.btnLogin.setOnClickListener{
            val user : User = User(binding.editUsername.text.toString(),binding.editPass.text.toString())
            presenter.updateUser(user)
            presenter.loginWithUser()
        }
    }

    override fun hideProgressBar() {
        binding.progressCircular.visibility = View.GONE
    }

    override fun showProgressBar() {
        binding.progressCircular.visibility = View.VISIBLE
    }

    override fun onLoginSuccess() {
        Toast.makeText(this,"Login Successfully",Toast.LENGTH_LONG).show()
    }

    override fun onLoginFailure() {
        Toast.makeText(this,"Login Failure",Toast.LENGTH_LONG).show()
    }
}