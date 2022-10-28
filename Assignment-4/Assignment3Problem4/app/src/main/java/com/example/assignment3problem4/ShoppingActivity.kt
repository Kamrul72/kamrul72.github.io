package com.example.assignment3problem4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        var res2=findViewById<TextView>(R.id.res1)
        var sintent=intent
        res2.text= "Welcome " +sintent.getStringExtra("mymsg")

    }
}