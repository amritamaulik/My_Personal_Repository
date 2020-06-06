package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_select_choice.*
import com.techmArogya.aarogyaathome.QuestionMapping

class SelectChoiceActivity : AppCompatActivity() {
    private val tag = SelectChoiceActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_select_choice)
        val callerButton:String? = intent.getStringExtra("callerButton")

        showAll(false)

        when{
            "ManagerServices".equals(callerButton)->{
                Log.e(tag,"callerButton : "+callerButton)
                showAll(true)
            }//this will be removed when Bot integrated

            "Buy/HireMedicalInstruments".equals(callerButton)->{
                Log.e(tag,"callerButton : "+callerButton)
                showInstrumentsQuestionsOnly(true)
            }
            "BookHomeVisit".equals(callerButton)->{
                Log.e(tag,"callerButton : "+callerButton)
                showHomeVisitQuestionsOnly(true)

            }
        }

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

    fun showAll(showAll:Boolean ){
        Q1View.isVisible=showAll
        Q2View.isVisible=showAll
        Q3View.isVisible=showAll
        Q4View.isVisible=showAll
        Q5View.isVisible=showAll
        Q6View.isVisible=showAll
        Q7View.isVisible=showAll
        Q8View.isVisible=showAll
        Q9View.isVisible=showAll
        Q10View.isVisible=showAll
    }

    fun showInstrumentsQuestionsOnly(showInstrumentsQuestionsOnly:Boolean ){
        Q1View.isVisible=showInstrumentsQuestionsOnly
        Q2View.isVisible=showInstrumentsQuestionsOnly
        Q3View.isVisible=showInstrumentsQuestionsOnly
        Q4View.isVisible=showInstrumentsQuestionsOnly
        Q6View.isVisible=showInstrumentsQuestionsOnly
    }

    fun showHomeVisitQuestionsOnly(showHomeVisitQuestionsOnly:Boolean ){
        Q5View.isVisible=showHomeVisitQuestionsOnly
        Q7View.isVisible=showHomeVisitQuestionsOnly
        Q10View.isVisible=showHomeVisitQuestionsOnly
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
