package com.example.assignment05prob03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.item_list.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        if(intent.hasExtra("image") && intent.hasExtra("name")&& intent.hasExtra("detail")){
            var ig =intent.getIntExtra("image",0)
            var t1 = intent.getStringExtra("name")
            var t2 = intent.getStringExtra("detail")
            name.text = t1.toString()
            desc.text = t2.toString()
            iv.setImageResource(ig)
        }

    }
}