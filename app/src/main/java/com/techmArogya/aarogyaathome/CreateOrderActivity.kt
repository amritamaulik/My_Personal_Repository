package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_order.*
import kotlinx.android.synthetic.main.activity_payment.*

class CreateOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_order)
       // displayDetails.setText(intent.getStringExtra("orderSelected"))
        createOrderBtn.setOnClickListener {
        val mainIntent = Intent(this, PaymentActivity::class.java)
        this.startActivity(mainIntent)
        }
    }
}
