package com.example.androidexampleyear

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.androidexampleyear.databinding.ActivityMain2Binding
import com.example.androidexampleyear.model.Tag

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    private var tag = Tag.OTHER
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = TagAdapter(
            this,
            R.layout.item_tag_dropdown,
            enumValues()
        )
        binding.editAddTaskDropdown.setAdapter(adapter)
        binding.editAddTaskDropdown.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                tag = enumValues<Tag>()[position]
            }
        binding.editAddTaskDate.setOnClickListener {
            Log.d("AppLog","Here")
        }

    }
}
class TagAdapter(context: Context, resource: Int, val items: Array<out Tag>) :
    ArrayAdapter<Tag>(context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tag_dropdown, parent, false)
        val imageView = view.findViewById<ImageView>(R.id.task_tag_color)
        imageView.setColorFilter(ContextCompat.getColor(context, items[position].resId))
        val textView = view.findViewById<TextView>(R.id.task_tag_description)
        textView.text = items[position].description
        return view
    }
}