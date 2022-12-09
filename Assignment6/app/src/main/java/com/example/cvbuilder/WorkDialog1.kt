package com.example.cvbuilder
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_work.*

class WorkDialog1: DialogFragment()  {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog_work1, null))
                // Add action buttons
                .setPositiveButton("Add",
                    DialogInterface.OnClickListener { dialog, id ->
                        // sign in the user ...
                        val title = et_dialog_company.text.toString().trim()
                        val position = et_dialog_position.text.toString().trim()
                        val duration = et_dialog_duration.text.toString().trim()
                        validate(title, position, duration)


                    })
                .setNegativeButton("cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
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