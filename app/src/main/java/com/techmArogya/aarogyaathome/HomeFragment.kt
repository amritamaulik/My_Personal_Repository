package com.techmArogya.aarogyaathome


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ScrollView
import androidx.cardview.widget.CardView
import com.techmArogya.aarogyaathome.R.color.textColor
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private val TAG = HomeFragment::class.java.simpleName

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view :View =  inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // LaunchBot to know whether Managed Service or AlaCarta
        managedServiceBtn.setOnClickListener{
            val intent = Intent(activity,SelectChoiceActivity::class.java)
            startActivity(intent)
            Log.e(tag,"ChatBot Launched")
        }// need to integrate the things here


        // Doc on Call
        managedServiceBtn.setOnClickListener{
            val intent = Intent(activity,SelectChoiceActivity::class.java)
            startActivity(intent)
            Log.e(tag,"ChatBot Launched")
        }
        // Buy/hire Medical Instruments
        // Book a HomeVisit
        // Book Ambulance
        // Go to hospital
        managedServiceBtn.setOnClickListener{
            val intent = Intent(activity,SelectChoiceActivity::class.java)
            startActivity(intent)
            Log.e(tag,"ChatBot Launched")
        }
    }
}

