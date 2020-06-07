package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
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
            "MainActivity".equals(callerButton)->{
                Log.i(tag,"callerButton : "+callerButton)
                showAll(true)
            }//this will be removed when Bot integrated

            "Buy/HireMedicalInstruments".equals(callerButton)->{
                Log.i(tag,"callerButton : "+callerButton)
                showInstrumentsQuestionsOnly(true)
            }
            "BookHomeVisit".equals(callerButton)->{
                Log.i(tag,"callerButton : "+callerButton)
                showHomeVisitQuestionsOnly(true)

            }
        }



    val recommendation = findViewById(R.id.nextBtn) as Button
     recommendation.setOnClickListener {
         //Questionmapping
         var questionNumLst : MutableList<String> = mutableListOf("notSelected")
         //fillQuestionNumLst(questionNumLst)

         var keyWords:StringBuffer?=null
         questionNumLst!!.clear()
         if(Q1.isChecked){
             Log.i(tag, " Q1 is Checked")
             questionNumLst.add("Q1")
             Log.i(tag, questionNumLst.indexOf("Q1").toString())
         }
         if(Q2.isChecked){
             Log.i(tag," Q2 is Checked")
             questionNumLst.add("Q2")
             Log.i(tag, questionNumLst.indexOf("Q2").toString())
         }
         if(Q3.isChecked){
             Log.i(tag," Q3 is Checked")
             questionNumLst.add("Q3")
             Log.i(tag, questionNumLst.indexOf("Q3").toString())
         }
         if(Q4.isChecked){
             Log.i(tag," Q4 is Checked")
             questionNumLst.add("Q4")
             Log.i(tag, questionNumLst.indexOf("Q4").toString())
         }
         if(Q5.isChecked){
             Log.i(tag," Q5 is Checked")
             questionNumLst.add("Q5")
             Log.i(tag, questionNumLst.indexOf("Q5").toString())
         }
         if(Q6.isChecked){
             Log.i(tag," Q6 is Checked")
             questionNumLst.add("Q6")
             Log.i(tag, questionNumLst.indexOf("Q6").toString())
         }
         if(Q7.isChecked){
             Log.i(tag," Q7 is Checked")
             questionNumLst.add("Q7")
             Log.i(tag, questionNumLst.indexOf("Q7").toString())
         }
         if(Q8.isChecked){
             Log.i(tag," Q8 is Checked")
             questionNumLst.add("Q8")
             Log.i(tag, questionNumLst.indexOf("Q8").toString())
         }
         if(Q9.isChecked){
             Log.i(tag," Q9 is Checked")
             questionNumLst.add("Q9")
             Log.i(tag, questionNumLst.indexOf("Q9").toString())
         }
         if(Q10.isChecked){
             Log.i(tag," Q10 is Checked")
             questionNumLst.add("Q10")
             Log.i(tag, questionNumLst.indexOf("Q10").toString())
         }
         keyWords = QuestionMapping().getSearchKeyWords(questionNumLst)
         Log.i(tag,"Keywords are " + keyWords.toString())


         val recommendationIntent = Intent(this, RecommendActivity::class.java)
         recommendationIntent.putExtra("Keywords",keyWords.toString())
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


}
