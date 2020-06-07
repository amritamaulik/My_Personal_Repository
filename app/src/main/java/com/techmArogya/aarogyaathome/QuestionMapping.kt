package com.techmArogya.aarogyaathome

import android.util.Log
import java.util.ArrayList

class QuestionMapping {
    private val tag = SelectChoiceActivity::class.java.simpleName
    lateinit var ultimateQuestionHashMap : HashMap<String,  MutableList<String>?>

    /*
    * Questions to keyword mapping
    * */

   public fun question2KeyWords(questionNumebr:String?): Boolean  {

        val hashMap: HashMap<String, MutableList<String>?> = HashMap<String, MutableList<String>?>() //define empty hashmap

        hashMap.put("Q1", mutableListOf("OximeterBuy", "OximeterRent","Thermometer"))
        hashMap.put("Q2", mutableListOf("SurgicalMask" , "N95"))
        hashMap.put("Q3", mutableListOf("PPE","Gloves"))
        hashMap.put("Q4", mutableListOf("Medicine"))
        hashMap.put("Q5", mutableListOf("VirtualConsultDoc","UploadHeathParams"))
        hashMap.put("Q6", mutableListOf("VirtualConsultTech", "Oxygen"))
        hashMap.put("Q7", mutableListOf("NurseVisit"))
        hashMap.put("Q8", mutableListOf("Ambulance"))
        hashMap.put("Q9", mutableListOf("ICUSetup"))
        hashMap.put("Q10", mutableListOf("DoctorVisit"))

        this.ultimateQuestionHashMap=hashMap

       return hashMap.containsKey(questionNumebr)
    }
    /*
    * questionNumber list*/

   public fun getSearchKeyWords(questionsNumList:MutableList<String>?):StringBuffer{
         var keyWordsString : StringBuffer=StringBuffer(" ")
       Log.e(tag,"Size of seleted checkboxes " + questionsNumList?.size)
           for(i in 0..questionsNumList!!.size-1){
               var qKey:String = questionsNumList[i]
               Log.e(tag,"Question Key is : " + qKey)
               if(question2KeyWords(qKey)){
                   var keywordslst:MutableList<String>?=this.ultimateQuestionHashMap.get(qKey)
                   for(keyNum in 0..keywordslst!!.size-1){
                       keyWordsString.append("\"")
                       keyWordsString.append(keywordslst.get(keyNum))
                               keyWordsString.append("\",")
                   }
               }
           }
       Log.e(tag,"Keywords are " + keyWordsString.toString())
        return keyWordsString
    }
}