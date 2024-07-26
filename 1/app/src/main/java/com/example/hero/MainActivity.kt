package com.example.hero

import android.hardware.lights.Light
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonRead= findViewById<Button>(R.id.btnread)
        val buttonDark= findViewById<Button>(R.id.btndark)
        val layout= findViewById<LinearLayout>(R.id.linearLayout)

        buttonRead.setOnClickListener {
            // Change to read mode
            layout.setBackgroundResource(R.color.yellow)

        }
        buttonDark.setOnClickListener {
            // Change to dark mode
            layout.setBackgroundResource(R.color.black)

        }
    }
}