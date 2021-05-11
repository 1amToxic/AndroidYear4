package com.example.androidexampleyear.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexampleyear.R
import com.example.androidexampleyear.databinding.ItemBookBinding
import com.example.androidexampleyear.model.Book

class BookAdapter : ListAdapter<Book, BookAdapter.BookViewHolder>(DiffBookCallBack) {

    class BookViewHolder(itemView : View ) : RecyclerView.ViewHolder(itemView) {
        private var binding: ItemBookBinding = ItemBookBinding.bind(itemView)
        fun bind(book: Book){
            with(itemView){

            }
        }

    }

    object DiffBookCallBack : DiffUtil.ItemCallback<Book>(){
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.BookViewHolder {
        return BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false))
    }

    override fun onBindViewHolder(holder: BookAdapter.BookViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}