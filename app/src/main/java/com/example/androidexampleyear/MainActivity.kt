package com.example.androidexampleyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import com.example.androidexampleyear.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnAdd.setOnClickListener {
            if (checkValidField()) {
                binding.textResult.text =
                    binding.editSoa.text.toString().toInt()
                        .plus(binding.editSoa.text.toString().toInt())
                        .toString()
            }
        }
        binding.btnDiv.setOnClickListener {
            if (checkValidField()) {
                if (binding.editSob.text.toString() == "0") {
                    binding.editSob.error = "Can not div to 0"
                } else {
                    binding.textResult.text =
                        binding.editSoa.text.toString().toInt()
                            .div(binding.editSoa.text.toString().toInt())
                            .toString()
                }
            }
        }
        binding.btnMul.setOnClickListener {
            if (checkValidField()) {
                binding.textResult.text =
                    binding.editSoa.text.toString().toInt()
                        .times(binding.editSoa.text.toString().toInt())
                        .toString()
            }
        }
        binding.btnSub.setOnClickListener {
            if (checkValidField()) {
                binding.textResult.text =
                    binding.editSoa.text.toString().toInt()
                        .minus(binding.editSoa.text.toString().toInt())
                        .toString()
            }
        }
    }

    private fun checkValidField(): Boolean {
        if (TextUtils.isEmpty(binding.editSoa.text)) {
            binding.editSoa.error = "This field can not be empty"
            return false
        }
        if (TextUtils.isEmpty(binding.editSob.text)) {
            binding.editSob.error = "This field can not be empty"
            return false
        }
        if (!TextUtils.isDigitsOnly(binding.editSoa.text)) {
            binding.editSoa.error = "This field can only have digit"
            return false
        }
        if (!TextUtils.isDigitsOnly(binding.editSob.text)) {
            binding.editSob.error = "This field can only have digit"
            return false
        }

        return true

    }
}