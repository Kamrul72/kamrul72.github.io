package com.example.mdpassignment3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val badd = findViewById<Button>(R.id.add_button)
        badd.setOnClickListener {
           // Toast.makeText(this, "Add  Button Pressed", Toast.LENGTH_LONG).show()

            val tableRow = TableRow(getApplicationContext()) // this
            // Set new table row layout parameters.
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            tableRow.setLayoutParams(layoutParams)
// add values into row by calling addView()
            val tableLayoutid = findViewById<TableLayout>(R.id.table_Layoutid)

            val etVersion = findViewById<EditText>(R.id.version)
            var verText=""+ etVersion.text
            val versionTextView = TextView(this)
            versionTextView.setText(verText)
            versionTextView.textSize= 20.0F
            versionTextView.setBackgroundColor(Color.rgb(226,191,230) )
            tableRow.addView(versionTextView)
            val etCodeName = findViewById<EditText>(R.id.code_name)
            var cnText=""+ etCodeName.text
            val codeNameTextView = TextView(this)
            codeNameTextView.setText(cnText)
            codeNameTextView.textSize=20.0F
            codeNameTextView.setBackgroundColor(Color.rgb(226,191,230) )
            tableRow.addView(codeNameTextView)
            tableRow.setPadding(5)
            tableLayoutid.addView(tableRow) // id from Layout_file

        }


    }
}