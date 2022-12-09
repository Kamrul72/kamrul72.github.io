package com.example.cvbuilder

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dialog_work.*
import kotlinx.android.synthetic.main.fragment_work.*


class WorkFragment : Fragment() {
    var imageges = ArrayList<Int>(arrayListOf( R.drawable.amazon, R.drawable.cognizant, R.drawable.dewa, R.drawable.google, R.drawable.kforce, R.drawable.meta ))
    var companies = ArrayList<String>(arrayListOf("Amazon Cloud","Cognizant Technology","Dubai Electricity","Google YouTube","Kforce ", "Facebook"))
    var designations = ArrayList<String>(arrayListOf("Chief Executive Officer","Executive Vice President","Director-IT","Head of Technical Service","Team Lead", "Sr.Developer"))
    var durations = ArrayList<String>(arrayListOf("2022-current","2020-2022","2018-2020","2016-2018","2010-2016", "2002-2010"))
    lateinit var rv : RecyclerView
    lateinit var adapt: WorkAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // rv.layoutManager= LinearLayoutManager(/* context = */ WorkFragment.class)
        var view =inflater.inflate(R.layout.fragment_work, container, false)

        var rv=view.findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager=LinearLayoutManager( context)
         adapt = WorkAdapter(companies , designations,imageges,durations )
        rv.adapter=adapt
        return view



    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fab.setOnClickListener{


                 val builder = AlertDialog.Builder(context)
                // Get the layout inflater
                //val inflater = requireActivity().layoutInflater
            builder.setTitle("Work Experience :")
             val editTextName1 =  EditText(context)
            editTextName1.setHint(" Company Name ");
            val editTextName2 =  EditText(context)
            editTextName2.setHint(" Position");
            val editTextName3 =  EditText(context)
            editTextName3.setHint(" Duration");

            builder.setView(editTextName1)
            builder.setView(editTextName2)
            builder.setView(editTextName3)


            val layoutName = LinearLayout(context)
            layoutName.orientation = LinearLayout.VERTICAL
            layoutName.addView(editTextName1) // displays the user input bar
            layoutName.addView(editTextName2)
            layoutName.addView(editTextName3)
            builder.setView(layoutName)
                .setPositiveButton("Add",
                    DialogInterface.OnClickListener { dialog, which ->
                        var txt1=editTextName1
                        var txt2=editTextName2
                        var txt3=editTextName3

                        val title =txt1?.text.toString()
                        val position = txt2?.text.toString()
                        val duration=txt3?.text.toString()
                        println(title)
                        println(position)
                        println(duration)
                        companies.add(title)
                        designations.add(position)
                        durations.add(duration)
                        imageges.add(R.drawable.miu)
                        println(companies)
                        println(designations)
                        println(durations)
                        println(imageges)

                        adapt.notifyDataSetChanged()


                        dialog.dismiss()


                    })


                .setNegativeButton("cancel",
                        DialogInterface.OnClickListener { dialog, id ->
                            //dialog.getDialog()?.cancel()
                            dialog.dismiss()
                        })
                val dialoc: AlertDialog = builder.create()
                dialoc.show()

            }



    }



    fun validate(title: String, position: String, duration: String){
        if(title.isEmpty()){
            Toast.makeText(context, "Enter title", Toast.LENGTH_LONG).show()
            return
        }
        if(position.isEmpty()){
            Toast.makeText(context, "Enter position", Toast.LENGTH_LONG).show()
            return
        }
        if(duration.isEmpty()){
            Toast.makeText(context, "Enter duration", Toast.LENGTH_LONG).show()
            return
        }
    }

}