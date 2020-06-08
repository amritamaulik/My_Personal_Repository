package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_recommend.*

class RecommendActivity : AppCompatActivity() {
    private val tag = RecommendActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        var keywords: String? = intent.getStringExtra("Keywords")
        Log.i(tag, "Successfully transfered keywords are : " + keywords)

        var textMsOffer1: String =
            "OfferId :  WellnOffer1 Offername : Basic Home Support\n" + "VendorId : Welln12340105201  VendorName : Wellness Home Care\n" + "OfferDesc : Basic Covid Support at home  OfferPrice : Rs. 6000\n" + "Locality : Khamla,Nagpur  City : Nagpur\n" + "State : Maharashtra  Rating : 4.7/5\n"
        var textMsOffer2: String =
            "OfferId :  GN95-001 Offername : N95 Mask packet\n" + "VendorId : Goodh45670425201  VendorName : GoodHealth Pvt. Ltd\n" + "OfferDesc : 5 pieces in 1 packet  OfferPrice : Rs. 650\n" + "Locality : Hinjewadi,Pune City : Pune\n" + "State : Maharashtra  Rating : 4.5/5\n"
        var textMsOffer3: String =
            "OfferId :  WellnOffer1 Offername : Stay comfortable\n" + "VendorId : Welln12340105201  VendorName : Wellness Home Care\n" + "OfferDesc : Stay comfortable OfferPrice : Rs. 10000\n" + "Locality : Khamla,Nagpur  City : Nagpur\n" + "State : Maharashtra  Rating : 4.7/5\n"

        var textOffer1: String =
            "OfferId :  WellnOffer1 Offername : Surgical Mask packet\n" + "VendorId : Welln12340105201  VendorName : Wellness Home Care\n" + "OfferDesc : 10 pieces in 1 packet OfferPrice : Rs. 150\n" + "Locality : Khamla,Nagpur  City : Nagpur\n" + "State : Maharashtra  Rating : 4.7/5\n"
        var textOffer2: String =
            "OfferId :  GN95-001 Offername : N95 Mask packet\n" + "VendorId : Goodh45670425201  VendorName : GoodHealth Pvt. Ltd\n" + "OfferDesc : 5 pieces in 1 packet  OfferPrice : Rs. 650\n" + "Locality : Hinjewadi,Pune City : Pune\n" + "State : Maharashtra  Rating : 4.5/5\n"

        var textOffervisit1: String =
            "OfferId :  WellnOffer1 Offername : Once a day nurse visit - 2 h/7d\n" + "VendorId : Welln12340105201  VendorName : Wellness Home Care\n" + "OfferDesc : Once a day nurse visit - 2 hrs for 7 days  OfferPrice : Rs. 5000\n" + "Locality : Khamla,Nagpur  City : Nagpur\n" + "State : Maharashtra  Rating : 4.7/5\n"
        var textOffervisit2: String =
            "OfferId :  WellnOffer1 Offername : Once a day doctor visit - 1 h/7d\n" + "VendorId : Welln12340105201  VendorName : Wellness Home Care\n" + "OfferDesc : Once a day doctor visit - 1 h/7d  OfferPrice : Rs. 10000\n" + "Locality : Khamla,Nagpur  City : Nagpur\n" + "State : Maharashtra  Rating : 4.7/5\n"


        var textamb1: String = "Aditya Birla Memorial Hospital (ABMH), Pune\n call 0098919289"
        var textamb2: String = "Tata Memorial Centre, Mumbai\n call 0091452849"
        var textamb3: String = "Lilavati Hospital and Research Centre, Mumbai\n call 0092919289"

        when {
            "MainActivity".equals(intent.getStringArrayExtra("callerButton")) -> {
                Log.i(tag, "callerButton : " + intent.getStringArrayExtra("callerButton"))
                offer1.setText(textMsOffer1)
                offer2.setText(textMsOffer2)
                offer3.setText(textMsOffer3)
            }//this will be removed when Bot integrated

            "Buy/HireMedicalInstruments".equals(intent.getStringArrayExtra("callerButton")) -> {
                Log.i(tag, "callerButton : " + intent.getStringArrayExtra("callerButton"))
                offer1.setText(textOffer1)
                offer2.setText(textOffer2)
                offer3.isVisible = false
            }
            "BookHomeVisit".equals(intent.getStringArrayExtra("callerButton")) -> {
                Log.i(tag, "callerButton : " + intent.getStringArrayExtra("callerButton"))
                offer1.setText(textOffervisit1)
                offer2.setText(textOffervisit2)
                offer3.isVisible = false

            }

            "BookAmbulance".equals(intent.getStringArrayExtra("callerButton")) -> {
                Log.i(tag, "callerButton : " + intent.getStringArrayExtra("callerButton"))
                offer1.setText(textamb1)
                offer2.setText(textamb2)
                offer3.setText(textamb3)

            }

        }
        sendEnquiryBtn.setOnClickListener{
            val mainIntent = Intent(this, HomeActivity::class.java)
            this.startActivity(mainIntent)
        }
    }
}
