package com.example.androidexampleyear.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidexampleyear.R
import com.example.androidexampleyear.database.service.BookService
import com.example.androidexampleyear.databinding.FragmentDetailBinding
import com.example.androidexampleyear.model.Book


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    lateinit var bookDetail: Book
    lateinit var bookService: BookService
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        bookDetail = arguments?.getSerializable("book") as Book
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookService = BookService(requireContext())
        binding.editTextName.setText(bookDetail.name)
        binding.editTextContent.setText(bookDetail.content)
        binding.editTextType.setText(bookDetail.type)
        setListeners()
    }

    private fun setListeners() {
        binding.btnDelete.setOnClickListener {
            bookService.deleteBook(bookDetail)
            findNavController().navigateUp()
        }
        binding.btnUpdate.setOnClickListener {
            bookService.updateBook(
                Book(
                    bookDetail.id,
                    binding.editTextName.text.toString(),
                    binding.editTextType.text.toString(),
                    binding.editTextContent.text.toString(),
                    bookDetail.userId
                )
            )
            findNavController().navigateUp()
        }
    }
}