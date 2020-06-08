package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    private val PaymentDelay_DISPLAY_LENGTH = 4000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        Handler().postDelayed(Runnable { /* Create an Intent that will start the Menu-Activity. */
            payBtn.setOnClickListener {
                Toast.makeText(this,"Payment in Progress",Toast.LENGTH_SHORT).show()
                Toast.makeText(this,"Payment Successful",Toast.LENGTH_SHORT).show()
                val mainIntent = Intent(this, HomeActivity::class.java)
                this.startActivity(mainIntent)
            }
        }, PaymentDelay_DISPLAY_LENGTH)

    }
}
