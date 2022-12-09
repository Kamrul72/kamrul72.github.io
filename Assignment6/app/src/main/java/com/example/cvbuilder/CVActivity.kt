package com.example.cvbuilder

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.cvbuilder.R.id
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.view.MenuItem
import android.widget.TextView

class CVActivity : AppCompatActivity() {
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvactivity)

        val fa= findViewById<FloatingActionButton>(id.fab)

        fmanager = supportFragmentManager

        tx = fmanager.beginTransaction()

        tx.add(id.frame1, HomeFragment())

        tx.commit()


    }


    fun home(view: View) {
        tx = fmanager.beginTransaction()
       tx.replace(id.frame1, HomeFragment())
        tx.commit()
    }


    fun aboutMe(view: View) {
        tx = fmanager.beginTransaction()
        tx.replace(id.frame1, AboutMeFragment())
        tx.commit()
    }

    fun work(view: View) {
        tx = fmanager.beginTransaction()
        tx.replace(id.frame1, WorkFragment())
        tx.commit()
    }

    fun contact(view: View) {
        tx = fmanager.beginTransaction()
        tx.replace(id.frame1, ContactFragment())
        tx.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {

        when(item.itemId){
            R.id.m1->{

                val uri = Uri.parse( " https://www.facebook.com/kamrul.islam.5623");
                val it = Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }
            R.id.m2->{
               // val ldAddr= view.findViewById<TextView>(R.id.linkedAddress).toString()
                val uri = Uri.parse( "https://www.linkedin.com/in/mohammed-kamrul-islam-57702022a");//"http://www.google.com");
                val it = Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }
            R.id.m3->{
                val uri = Uri.parse( "http://www.google.com");//"http://www.google.com");
                val it = Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }
            R.id.m4->{
                val uri = Uri.parse( "https://github.com/Kamrul72/kamrul72.github.io");//"http://www.google.com");
                val it = Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }
        }

        Toast.makeText(
            applicationContext,
            item.title.toString(),
            Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

}

