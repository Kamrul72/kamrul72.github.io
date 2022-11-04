package com.example.assignment05prob03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var imageges = intArrayOf(
        R.drawable.laptop,
        R.drawable.printer,
        R.drawable.tablet,
        R.drawable.telivisin

    )
 var prices = arrayOf("$1260.7","$350.67","$760.34","$780.08")
 var titles=arrayOf("HP Flyer Red 15.7 inch Lptop", "Epson Workforce WP-2750","Samsong vayger 7 inch Android","ViZIO 70 inch clasic 4k")
    var colors= arrayOf("Red","Black","Navy Blue","Silver")

    var productDetails = //resources.getStringArray(R.array.details)
        arrayOf("Windows 11 HomeIntel® Core™ i5-1235U (up to 4.4 GHz, 12 MB L3 cache, 10 cores, 12 threads) + Intel® Iris® Xe Graphics8 GB DDR4-3200 SDRAM (2 X 4 GB)256 GB PCIe® NVMe™ M.2 SSD",
            "he printer mechanism is set to its initial state.\n" +
                    "The input data buffer and print buffer are cleared.\n" +
                    "The printer returns to the default condition last set",
            "Samsung Galaxy Tab A 10.1 (2019) ; Network, Technology, GSM / HSPA / LTE ; Launch, Announced, 2019, February 15 ; Body, Dimensions, 245.2 x 149.4 x 7.5 mm (9.65 x ...",
            "VIZIO M-Series Quantum 70\" Class (69.5\" diag) 4K HDR Smart TV | M706x-H3. VIZIO M-Series Quantum 70\" Class (69.5\" diag) 4K HDR Smart TV 4.6 out of 5 stars. Read ..")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv.layoutManager= LinearLayoutManager(this)

        val adapter = MyAdapter(this,titles , prices ,imageges,colors,productDetails )
        rv.adapter=adapter

    }
}