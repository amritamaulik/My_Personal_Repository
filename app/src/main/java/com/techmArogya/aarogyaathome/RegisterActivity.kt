package com.techmArogya.aarogyaathome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        submitBtn.setOnClickListener {
            val mainIntent = Intent(this, HomeActivity::class.java)
            this.startActivity(mainIntent)
        }
    }
}