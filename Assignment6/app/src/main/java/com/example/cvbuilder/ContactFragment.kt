package com.example.cvbuilder

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_contact.view.*

class ContactFragment : Fragment() {

    lateinit var lt : LinearLayout
    lateinit var gh : LinearLayout
    lateinit var eml : LinearLayout
    lateinit var tel : LinearLayout

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_contact, container, false)
        lt = view.findViewById(R.id.linkedIn) as LinearLayout
        lt.setOnClickListener {
            val ldAddr= view.findViewById<TextView>(R.id.linkedAddress).toString()
            val uri = Uri.parse( "https://www.linkedin.com/in/mohammed-kamrul-islam-57702022a");//"http://www.google.com");
            val it = Intent(Intent.ACTION_VIEW,uri);
            startActivity(it);
        }

        gh= view.findViewById(R.id.github) as LinearLayout
            gh.setOnClickListener {
                val ldAddr= view.findViewById<TextView>(R.id.linkedAddress).toString()
                val uri = Uri.parse( "https://github.com/Kamrul72/kamrul72.github.io");//"http://www.google.com");
                val it = Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);

            }

        eml= view.findViewById(R.id.email) as LinearLayout

        eml.setOnClickListener{

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Test Email")
            startActivity(intent)
        }
        eml= view.findViewById(R.id.phone) as LinearLayout
        eml.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:6418191638")

                startActivity(intent)



        }

        return view


    }



}