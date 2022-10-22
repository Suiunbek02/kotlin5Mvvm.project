package com.example.kotlin5mvvmproject

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin5mvvmproject.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setUpObserves()
        setMinus()
        setPlus()
    }


    private fun setUpObserves() {
        viewModel?.data?.observe(this) { count ->
            binding.textCount.text = count.toString()
        }
    }

    private fun setMinus() {
        binding.buttonMinus.setOnClickListener {
            viewModel?.minus()
        }
    }

    private fun setPlus() {
        binding.buttonPlus.setOnClickListener {
            if (viewModel?.count!! == 9) {
                binding.buttonPlus.setBackgroundColor(Color.parseColor("#FF0000"))
                viewModel?.plus()
            } else {
                viewModel?.plus()
            }
        }
    }

}
