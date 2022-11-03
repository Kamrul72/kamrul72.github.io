package com.example.assignment5prob01

import android.annotation.SuppressLint
import android.icu.util.Calendar
import android.icu.util.Calendar.getInstance
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    var cbhi = false
    var cbf=false
    var  cbst=false
    var q1:String=""
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var hi=findViewById<CheckBox>(R.id.hiCheckBox)
        var f=findViewById<CheckBox>(R.id.fCheckBox)
        var st=findViewById<CheckBox>(R.id.stCheckBox)
        var fun1 =findViewById<RadioButton>(R.id.funButton)
        var function1 =findViewById<RadioButton>(R.id.functionButton)
        var define =findViewById<RadioButton>(R.id.defineButton)
        hi.setOnCheckedChangeListener { buttonView, isChecked ->
           cbhi=isChecked
           // Toast.makeText(this,isChecked.toString(),Toast.LENGTH_SHORT).show()
        }
        f.setOnCheckedChangeListener { buttonView, isChecked ->
            cbf=isChecked
           // Toast.makeText(this,isChecked.toString(),Toast.LENGTH_SHORT).show()
        }

        st.setOnCheckedChangeListener { buttonView, isChecked ->
            cbst=isChecked
          //  Toast.makeText(this,isChecked.toString(),Toast.LENGTH_SHORT).show()
        }
      var rgroup= findViewById<RadioGroup>(R.id.rg)
        rgroup.setOnCheckedChangeListener{ group,checkedID->
            val clicked=group.findViewById(checkedID) as RadioButton
            val checked=clicked.isChecked
            if (checked){
                q1=clicked.text.toString()
                //Toast.makeText(this,clicked.text.toString(),Toast.LENGTH_SHORT).show()
            }

        }


        var cb = findViewById<Button>(R.id.clearButton)
        cb.setOnClickListener {

            hi.isChecked=false
            f.isChecked=false
            st.isChecked=false
            fun1.isChecked=false
            function1.isChecked= false
            define.isChecked=false

        }
        var sb = findViewById<Button>(R.id.submitButton)
        sb.setOnClickListener {
        var mark =0
            if (q1=="fun")mark +=50
            if (!cbhi&&cbf&&cbst) mark +=50


            val time = Calendar.getInstance().time
            val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
            val current = formatter.format(time)

            // Toast.makeText(this,"You achieved ${mark} %",Toast.LENGTH_SHORT).show()
          var builder= AlertDialog.Builder(this)
            if (mark>0) builder.setTitle("Congratulation")
            else builder.setTitle("Sorry")
            builder.setMessage("You submitted on ${current} , You achieved ${mark} %")
           builder.setPositiveButton("Exit"){dialogInterface ,which->
              dialogInterface.dismiss()
              finish()

               }
            builder.setNegativeButton("Cancel"){ dialogInterface ,which->
                dialogInterface.dismiss()
            }

          val dialog:AlertDialog=builder.create()
            dialog.show()

        }


    }
}