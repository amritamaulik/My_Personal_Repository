package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        val register = findViewById(R.id.registerBtn) as Button
        register.setOnClickListener {
          val reqisterIntent = Intent(this, RegisterActivity::class.java)
            startActivity(reqisterIntent)
        }

    }
}
