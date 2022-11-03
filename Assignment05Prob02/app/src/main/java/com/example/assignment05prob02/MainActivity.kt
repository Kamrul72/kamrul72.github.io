package com.example.assignment05prob02

import android.annotation.SuppressLint
import android.graphics.ColorSpace.Adaptation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var electronicsArr : Array<String>
    private lateinit var foodsArr : Array<String>
    private lateinit var clothsArr : Array<String>
    private lateinit var beautiesArr : Array<String>
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ivvElectronics = findViewById<ImageView>(R.id.ivElectronics)
        var ivvfoods=findViewById<ImageView>(R.id.ivFood)
        var ivvbeauties=findViewById<ImageView>(R.id.ivBeauty)
        var ivvcloths=findViewById<ImageView>(R.id.ivClothing)
        //lvvElectronics.adapter=adapter1

        ivvElectronics.setOnClickListener {
            //val adapter1=ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,electronicsArr)
            electronicsArr = getResources().getStringArray(R.array.electronics)
            val adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,electronicsArr )
            var lvvElectronics = findViewById<ListView>(R.id.lvelec)
            lvvElectronics.adapter=adapter1

            lvvElectronics.setOnItemClickListener{ parent ,view ,position,id->
                Toast.makeText(this,
                    "Item selected is " +
                            parent.getItemAtPosition(position),
                    Toast.LENGTH_SHORT).show()


            }

        }

        ivvfoods.setOnClickListener {
            //val adapter1=ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,electronicsArr)
            foodsArr = getResources().getStringArray(R.array.foods)
            val adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,foodsArr )
            var lvvfoods= findViewById<ListView>(R.id.lvfod)
            lvvfoods.adapter=adapter1

            lvvfoods.setOnItemClickListener{ parent ,view ,position,id->
                Toast.makeText(this,
                    "Item selected is " +
                            parent.getItemAtPosition(position),
                    Toast.LENGTH_SHORT).show()


            }

        }

        ivvbeauties.setOnClickListener {
            //val adapter1=ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,electronicsArr)
            beautiesArr = getResources().getStringArray(R.array.beauties)
            val adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,beautiesArr )
            var lvvbeauty= findViewById<ListView>(R.id.lvbea)
            lvvbeauty.adapter=adapter1

            lvvbeauty.setOnItemClickListener{ parent ,view ,position,id->
                Toast.makeText(this,
                    "Item selected is " +
                            parent.getItemAtPosition(position),
                    Toast.LENGTH_SHORT).show()


            }

        }

        ivvcloths.setOnClickListener {
            //val adapter1=ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,electronicsArr)
            clothsArr = getResources().getStringArray(R.array.cloths)
            val adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,clothsArr )
            var lvvcloths= findViewById<ListView>(R.id.lvclt)
            lvvcloths.adapter=adapter1
            lvvcloths.setOnItemClickListener{ parent ,view ,position,id->
                Toast.makeText(this,
                    "Item selected is " +
                            parent.getItemAtPosition(position),
                    Toast.LENGTH_SHORT).show()


            }

        }

    }
}