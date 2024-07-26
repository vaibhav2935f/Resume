package com.example.usersignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.usersignup.databinding.ActivityUserRegistrationBinding

class UserRegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn1.setOnClickListener {
            val openSigninActivity = Intent(this, SigninActivity::class.java)
            startActivity(openSigninActivity)
        }
        binding.btn2.setOnClickListener {
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
    }
}

