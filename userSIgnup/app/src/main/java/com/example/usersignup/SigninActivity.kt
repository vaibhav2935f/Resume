package com.example.usersignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usersignup.databinding.ActivityMainBinding
import com.example.usersignup.databinding.ActivitySigninBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding

    lateinit var databaseReference: DatabaseReference
    companion object{
        const val KEY1 = "com.example.userSignup.SigninActivity.mail"
        const val KEY2 = "com.example.userSignup.SigninActivity.name"
        const val KEY3 = "com.example.userSignup.SigninActivity.id"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn2.setOnClickListener {
            //take ref till node "User"
            val uniqueId = binding.UserName.text.toString()
            if (uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this, "Please enter user Name", Toast.LENGTH_SHORT).show()
            }
        }
    } //on Create method over

    private fun readData(uniqueId: String) {

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseReference.child(uniqueId).get().addOnSuccessListener {
            // if user exits or not
            if (it.exists()){
                //Welcomr user in your app, with intent and also pass
                val email = it.child("email").value
                val name = it.child("name").value
                val userId = it.child("uniqueId").value

                val intentWelcome = Intent(this, WelcomeActivity::class.java)
                intentWelcome.putExtra(KEY1, email.toString())
                intentWelcome.putExtra(KEY2, name.toString())
                intentWelcome.putExtra(KEY3, userId.toString())
                startActivity(intentWelcome)

            }else{
                Toast.makeText(this, "User does'nt exist", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}