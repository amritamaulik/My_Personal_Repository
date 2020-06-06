package com.techmArogya.aarogyaathome

import java.util.ArrayList

class QuestionMapping {
    lateinit var ultimateQuestionHashMap : HashMap<String,  MutableList<String>?>

    /*
    * Questions to keyword mapping
    * */

   public fun question2KeyWords(questionNumebr:String?): Boolean  {

        val hashMap: HashMap<String, MutableList<String>?> = HashMap<String, MutableList<String>?>() //define empty hashmap

        hashMap.put("Q1", mutableListOf("\"OximeterBuy\" , "         , "\"OximeterRent\" , "   , "\"Thermometer\""))
        hashMap.put("Q2", mutableListOf("\"SurgicalMask\" , "        , "\"N95\'"))
        hashMap.put("Q3", mutableListOf("\"PPE\" , "                 , "\"Gloves\""))
        hashMap.put("Q4", mutableListOf("\"Medicine\""))
        hashMap.put("Q5", mutableListOf("\"VirtualConsultDoc\" , "   , "\"UploadHeathParams\""))
        hashMap.put("Q6", mutableListOf("\"VirtualConsultTech\" , "  , "\"Oxygen\""))
        hashMap.put("Q7", mutableListOf("\"NurseVisit\""))
        hashMap.put("Q8", mutableListOf("\"Ambulance\""))
        hashMap.put("Q9", mutableListOf("\"ICUSetup\""))
        hashMap.put("Q10", mutableListOf("\"DoctorVisit\""))

        this.ultimateQuestionHashMap=hashMap

       return hashMap.containsKey(questionNumebr)
    }
    /*
    * questionNumber list*/

   public fun getSearchKeyWords(questionsNumList:MutableList<String>?):StringBuffer?{
         var keyWordsString : StringBuffer?=null
            for(keyWord in 0..questionsNumList!!.count()-1){
               var qKey:String? = questionsNumList!![keyWord]
                if(question2KeyWords(qKey)){
                    keyWordsString!!.append(this.ultimateQuestionHashMap[qKey])
                    keyWordsString.append(" , ")
                }
            }
        return keyWordsString
    }
}