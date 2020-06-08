package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.fragment_enquiry_status.*

class EnquiryStatusActivity : AppCompatActivity() {
    private val tag = RecommendActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_enquiry_status)

        var keywords: String? = intent?.getStringExtra("Keywords")
        Log.i(tag, "Successfully transfered keywords are : " + keywords)

        commercialNextBtn.setOnClickListener{

            val intent = Intent(this,CreateOrderActivity::class.java)

            startActivity(intent)

        }
    }
}
