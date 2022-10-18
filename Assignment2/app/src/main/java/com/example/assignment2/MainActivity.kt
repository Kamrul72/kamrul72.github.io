package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var foodList = ArrayList<String>(arrayListOf ("Hamburger", "Pizza","Mexican", "American", "Chinese"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFoodBtn.setOnClickListener {
            var foodName="" +newFood.text
            foodList.add(foodName)

        }


    }

 fun clickOnDecide(view: View){
   var randFoodIndex= Random.nextInt(0,foodList.size-1)
     foodView.text="               "+ foodList.get(randFoodIndex)
 }

}