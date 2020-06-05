package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_choice)

    val recommendation = findViewById(R.id.nextBtn) as Button
     recommendation.setOnClickListener {
         val recommendationIntent = Intent(this, HomeActivity::class.java)
         startActivity(recommendationIntent)
    }
  }
}
