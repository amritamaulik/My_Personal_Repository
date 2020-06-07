package com.techmArogya.aarogyaathome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class RecommendActivity : AppCompatActivity() {
    private val tag = RecommendActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        var keywords:String? = intent.getStringExtra("Keywords")
        Log.i(tag,"Successfully transfered keywords are : "+keywords)

    }
}
