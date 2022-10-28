package com.example.assignment3problem4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.assignment3problem4.R.id.caButton

class MainActivity : AppCompatActivity() {

    lateinit var result:User
    var userList= ArrayList<User>()
    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //var userList= ArrayList<User>()
        var user1=User ("Mohammed","Islam","mkislam@miu.edu","kamrul")
        var user2=User("Mahir","Islam","maislam@fhs.edu","amerul")
        var user3=User("Sahir","Islam","saislam@fhs.edu","sislam")
        var user4=User("Kazi","Shampa","krks@fhs.edu","rahima")
        var user5=User("Lamisha","Islam","lamislam@fhs.edu","parul")

        userList.add(user1)
        userList.add(user2)
        userList.add(user3)
        userList.add(user4)
        userList.add(user5)
        //val temp=intent.getSerializableExtra("user")
       // result=temp as User
       //userList.add(result)
        val intent = getIntent()
        val userx: User? = intent.getSerializableExtra("user") as User?
        userx?.let { userList.add(it) }
        val sib = findViewById<Button>(R.id.signInButton)

        println(userList.get(0).userName)
        sib.setOnClickListener {
            val userName_sin =findViewById<EditText>(R.id.etUserName).text
            val password_sin=findViewById<EditText>(R.id.etPassword).text
            //Toast.makeText(this, userName_sin, Toast.LENGTH_LONG).show()
            for (user in userList){
                var smsg=userName_sin.toString()

               //Toast.makeText(this, smsg, Toast.LENGTH_LONG).show()
                  if (user.userName == smsg && user.password==password_sin.toString()) {
                        //println("user found")
                      Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG).show()
                      var intent=Intent(this ,ShoppingActivity::class.java)
                      intent.putExtra("mymsg",smsg)
                     startActivity(intent)

                    break;

                }
            }
        }
     val cab=findViewById<Button>(caButton)
        cab.setOnClickListener {
            var intent=Intent(this ,NewAccountActivity::class.java)

            startActivity(intent)
        }





    }

    fun onSendPassworcImplicit(view: View) {
        val userName_sin =findViewById<EditText>(R.id.etUserName).text
        for(user in userList) {
            var smsg=userName_sin.toString()
            if(user.userName == smsg){
                var input:String = user.password
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type =  "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, input)
                startActivity(intent)

            }

        }


    }
}