package com.example.androidexampleyear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.androidexampleyear.adapter.ViewPagerAdapter
import com.example.androidexampleyear.databinding.ActivityMainBinding
import com.example.androidexampleyear.fragment.FragmentTakeNote
import com.example.androidexampleyear.fragment.FragmentWelcome
import com.example.androidexampleyear.fragment.Fragment_Remind

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    lateinit var binding: ActivityMainBinding
    lateinit var viewPagerAdapter: ViewPagerAdapter
    val listFragment = mutableListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listFragment.add(FragmentWelcome.newInstance())
        listFragment.add(FragmentTakeNote.newInstance())
        listFragment.add(Fragment_Remind.newInstance())
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, listFragment)
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        binding.pageIndicatorView.selection = position
    }

    override fun onPageSelected(position: Int) {
    }
}