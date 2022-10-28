package com.example.assignment3problem4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NewAccountActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)

        val ncab = findViewById<Button>(R.id.createAccountBtn)
        ncab.setOnClickListener {
            val firstName_sin =findViewById<EditText>(R.id.fName).text
            val lastName_sin=findViewById<EditText>(R.id.lName).text
            val userName_sin =findViewById<EditText>(R.id.uName).text
            val password_sin=findViewById<EditText>(R.id.uPassword).text
            Toast.makeText(this, userName_sin, Toast.LENGTH_LONG).show()
            val userAccount = User (firstName_sin.toString(),lastName_sin.toString(),userName_sin.toString(),password_sin.toString() )
           val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("user",userAccount)
            startActivity(intent)

        }


    }
}