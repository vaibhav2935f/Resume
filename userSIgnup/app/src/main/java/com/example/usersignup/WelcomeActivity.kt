package com.example.usersignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usersignup.databinding.ActivitySigninBinding
import com.example.usersignup.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(SigninActivity.KEY2)
        val mail = intent.getStringExtra(SigninActivity.KEY1)
        val userId = intent.getStringExtra(SigninActivity.KEY3)

        binding.tWelcome.text = "Welcome:  $name"
        binding.tvMail.text = "Mail:  $mail"
        binding.tvUnique.text = "UserId:   $userId"
    }
}