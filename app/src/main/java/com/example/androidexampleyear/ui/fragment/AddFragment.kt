package com.example.androidexampleyear.ui.fragment

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidexampleyear.R
import com.example.androidexampleyear.database.service.BookService
import com.example.androidexampleyear.databinding.FragmentAddBinding
import com.example.androidexampleyear.model.Book


class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    lateinit var bookService: BookService
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preF = requireActivity().getSharedPreferences("USER", MODE_PRIVATE)
        bookService = BookService(requireContext())
        binding.btnConfirm.setOnClickListener {
            bookService.insertBook(
                Book(
                    0,
                    binding.editTextName.text.toString(),
                    binding.editTextType.text.toString(),
                    binding.editTextContent.text.toString(),
                    preF.getInt("id", 0)
                )
            )
            findNavController().navigateUp()
        }
    }

}