package com.example.usersignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usersignup.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity<userSignup> : AppCompatActivity() {
    lateinit var database : DatabaseReference
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {

            val name = binding.etname.text.toString()
            val mail = binding.etmail.text.toString()
            val uniqueId = binding.etUsername.text.toString()
            val password = binding.etpassword.text.toString()


            if (binding.chkbox.isChecked && infoValdate()) {
                val openUserRegistrationActivity = Intent(this, UserRegistrationActivity::class.java)
                uploadData(name, mail,uniqueId,password)
                startActivity(openUserRegistrationActivity)

            }else{
                Toast.makeText(this, "Something is missing", Toast.LENGTH_SHORT).show()
            }


        }
        binding.tvSignin.setOnClickListener {
            val openSigninActivity = Intent(this, SigninActivity::class.java)
            startActivity(openSigninActivity)
        }
    }

    private fun uploadData(name: String, mail: String, uniqueId: String, password: String) {
        val user = User(name,  mail, password, uniqueId)
        database= FirebaseDatabase.getInstance().getReference("Users")
        database.child(uniqueId).setValue(user).addOnSuccessListener {

            binding.etname.text?.clear()
            binding.etmail.text?.clear()
            binding.etpassword.text?.clear()
            binding.etUsername.text?.clear()

            Toast.makeText(this, "User Registrated", Toast.LENGTH_SHORT).show()
        }.addOnSuccessListener {
            Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun infoValdate(): Boolean {
        var flag:Boolean = true
        if(binding.etname.text.toString().isBlank()){
            binding.etname.hint = "* Required"
            flag = false
        }
        if(binding.etmail.text.toString().isBlank()){
            binding.etmail.hint = "* Required"
            flag = false

        }
        if(binding.etpassword.text.toString().isBlank()){
            binding.etpassword.hint = "* Required"
            flag = false

        }
        if(binding.etUsername.text.toString().isBlank()){
            binding.etUsername.hint = "* Required"
            flag = false

        }
        return flag
    }
}




