package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_select_choice.*
import com.techmArogya.aarogyaathome.QuestionMapping

class SelectChoiceActivity : AppCompatActivity() {
    private val tag = SelectChoiceActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_choice)
        //Questionmapping
        var questionNumLst : MutableList<String>?= mutableListOf("notSelected")
        //fillQuestionNumLst(questionNumLst)
        var keywords :StringBuffer?=fillQuestionNumLst(questionNumLst)
        Log.e(tag,keywords.toString())

    val recommendation = findViewById(R.id.nextBtn) as Button
     recommendation.setOnClickListener {
         val recommendationIntent = Intent(this, RecommendActivity::class.java)
         startActivity(recommendationIntent)
    }
  }

    fun fillQuestionNumLst(questionNumLst :  MutableList<String>?):StringBuffer?{
        var keyWords:StringBuffer?=null
        Q1.setOnClickListener(View.OnClickListener {
            if (Q1.isChecked) {
                Log.i(tag," Q1 is Checked")
                questionNumLst!!.clear()
                questionNumLst!!.add("Q1")
                    Log.i(tag, questionNumLst.indexOf("Q1").toString())
                var qm : QuestionMapping? = null
                keyWords=qm!!.getSearchKeyWords(questionNumLst)

                Log.e(tag,"Keywords are " + keyWords.toString())
            }
        })

        return keyWords
    }

}
