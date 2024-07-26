package com.example.vasic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.example.vasic.databinding.ActivityMainBinding
import com.example.vasic.databinding.ActivityOrderBinding
import java.security.Key


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // creating key
    companion object{
        const val KEY = "com.example.Vasic.mainActivity.KEY"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnOrder.setOnClickListener {
            val orderPlaced= binding.eT1.text.toString() + " " + binding.eT2.text.toString() + " " +
                    binding.eT3.text.toString() + " " + binding.eT4.text

            intent= Intent(this, Order::class.java)
            intent.putExtra(KEY, orderPlaced)
            startActivity(intent)

        }

    }
}