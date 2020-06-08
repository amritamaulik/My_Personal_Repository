package com.techmArogya.aarogyaathome


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techmArogya.aarogyaathome.dataaccessors.DatabaseHandler

/**
 * A simple [Fragment] subclass.
 */
class EnquiryStatusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enquiry_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val dbHandler: DatabaseHandler= DatabaseHandler(this)
       *//* var vendorDetails: HashMap<String,String>? = dbHandler?.showMSOffers(keywords)
        val intent:Intent? = Intent(this,MainActivity::class.java)*/
    }


}
