package com.example.cvbuilder

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun register(view: View) {

        val spf = getSharedPreferences("login", Context.MODE_PRIVATE)

        val spe = spf.edit()

        spe.putString("name", etr1.text.toString())
        spe.putString("pass", etr2.text.toString())
        spe.putString("phone", etr3.text.toString())
        spe.putString("email", etr4.text.toString())
        spe.apply()
        Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show()
        // Once finished writing we need to go back to the main activity to show the Login
        finish() // automatically destroy the activity and give the visibility of Main Activity
    }
}