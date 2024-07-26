package com.example.vasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vasic.databinding.ActivityMainBinding
import com.example.vasic.databinding.ActivityOrderBinding

class Order : AppCompatActivity() {
    lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val orderOfCustomer= intent.getStringExtra(MainActivity.KEY)

            binding.tvOrder.text=  orderOfCustomer.toString()
    }
}