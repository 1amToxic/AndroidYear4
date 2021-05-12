package com.example.androidexampleyear.ui.fragment

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexampleyear.R
import com.example.androidexampleyear.database.AppDatabase
import com.example.androidexampleyear.database.service.BookService
import com.example.androidexampleyear.databinding.FragmentHomeBinding
import com.example.androidexampleyear.model.Book
import com.example.androidexampleyear.ui.adapter.BookAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    lateinit var adapterR: BookAdapter
    lateinit var bookService: BookService
    var listBook = mutableListOf<Book>()
    lateinit var preF : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookService = BookService(requireContext())
        preF = requireActivity().getSharedPreferences("USER",MODE_PRIVATE)
        initView()
        setListeners()
    }

    private fun setListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
    }
    private fun initView() {
        adapterR = BookAdapter{
            onClickItem(it)
        }
        GlobalScope.launch(Dispatchers.IO) {
            listBook.clear()
            listBook.addAll(bookService.getAllBook(preF.getInt("id",0)))
            withContext(Dispatchers.Main){
                adapterR.submitList(listBook)
            }
        }
        binding.recyclerBook.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterR
        }
    }

    private fun onClickItem(it: Book) {
        val bundle = Bundle()
        bundle.putSerializable("book",it)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)
    }
}