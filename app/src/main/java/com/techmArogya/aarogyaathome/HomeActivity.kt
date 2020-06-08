package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.techmArogya.aarogyaathome.dataaccessors.DatabaseHandler
import com.techmArogya.aarogyaathome.dataaccessors.MSFeatureModelClass
import com.techmArogya.aarogyaathome.dataaccessors.OfferModelClass
import com.techmArogya.aarogyaathome.dataaccessors.VendorDetailsModelClass
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity()/*, HomeFragment.OnManagedServicesClickListener */{
    private val TAG = HomeActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if(savedInstanceState==null){
        //load HomeFragment by default
        loadFragment(HomeFragment())

        // load fragment on selection
        loadSelectedFragment()
        }
        val dbHandler: DatabaseHandler= DatabaseHandler(this)

        loadDbDetails(dbHandler)
    }

    /*override fun onManagedServicesClick(intent: Intent) {
        intent.setClass(this,SelectChoiceActivity::class.java)
    }*/

    private fun loadSelectedFragment() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when{
                menuItem.itemId==R.id.home ->{
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId==R.id.eligibilityCheck ->{
                    val intent = Intent(this,MainActivity::class.java)
                    intent.putExtra("callerButton","EligibilityMenuBtn")
                    startActivity(intent)
                    Log.e(TAG,"ChatBot Launched")
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId==R.id.orderStatus ->{
                    val intent = Intent(this,OrderStatusActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId==R.id.help ->{
                    val intent = Intent(this,EnquiryStatusActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                else ->{
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also{ fragmentTransaction ->
            fragmentTransaction.setTransition(TRANSIT_FRAGMENT_FADE)
            fragmentTransaction.replace(R.id.fragmetContainer,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    private fun loadDbDetails(dbHandler: DatabaseHandler){
        //val dbHandler: DatabaseHandler= DatabaseHandler(this)
        //------adding data to table_ms_offers
        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer1","basic equipment purchase","Thermometer, Pulse Oximeter, N95 Masks ( 5 ), gloves ( 5 )","Thermometer, Oximeter, N95, Gloves"))
        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer1","on-line consultation","on-line doctor / nurse consultation,","VirtualConsultDoc"))
        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer1","Share Health parameters","upload the health parameters.","UploadHeathParams"))
        var listData :List<MSFeatureModelClass> = dbHandler.viewMSOffers()
        System.out.println(listData[0].toString())

        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer2","basic equipment purchase","Thermometer, Pulse Oximeter, N95 Masks ( 5 ), gloves ( 5 )","Thermometer, Oximeter, N95, Gloves"))
        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer2","on-line consultation","on-line doctor / nurse consultation,","VirtualConsultDoc"))
        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer3","Share Health parameters","upload the health parameters.","UploadHeathParams"))
        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer2","Oxygen for 7 days","Setup of Oxygen","Oxygen"))
        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer2","Daily Nurse visit for 2 hrs.","Daily Nurse visit for 2 hrs. ","NurseVisit"))


        dbHandler.addMSOffer(MSFeatureModelClass("WellnOffer3","ICU Setup for Covid at Home -5 days ","Complete ICU setup for COVID at home ","ICUSetup"))


        dbHandler.addMSOffer(MSFeatureModelClass("GoodnOffer1","basic equipment purchase","Thermometer, Pulse Oximeter, N95 Masks ( 10), gloves ( 5 ) , 2 PPE Kit","Thermometer, Oximeter, N95, Gloves, PPE"))
        dbHandler.addMSOffer(MSFeatureModelClass("GoodnOffer1","on-line consultation","on-line doctor / nurse consultation,","VirtualConsultDoc"))
        dbHandler.addMSOffer(MSFeatureModelClass("GoodnOffer1","Share Health parameters","upload the health parameters.","UploadHeathParams"))

        //------adding data to table_offers
        dbHandler.addOffer(OfferModelClass("WellnOffer1","Welln12340105201","Basic Home Support","","Managed Service","Rs. 3000",""))
        dbHandler.addOffer(OfferModelClass("N95-001","Welln12340105201","N95 Mask packet","5 pieces in 1 packet","AlaCarte","Rs. 600","N95"))
        dbHandler.addOffer(OfferModelClass("Smask-001","Welln12340105201","Surgical Mask packet","10 pieces in 1 packet","AlaCarte","Rs. 150","SurgicalMask"))
        dbHandler.addOffer(OfferModelClass("Med-001","Welln12340105201","Vitamins for 15 days","Vitamin C, Zinc, B12, Vitamin D","AlaCarte","Rs. 700","Medicine"))
        dbHandler.addOffer(OfferModelClass("PPE-001","Welln12340105201","PPE Kit - 5 sets","Full body PPE Kit with Face cover ","AlaCarte","Rs. 3000","PPE"))
        dbHandler.addOffer(OfferModelClass("PulseO-001","Welln12340105201","Pulse Oximeter-purchase","Pulse Oximeter -1 piece","AlaCarte","Rs. 700","OximeterBuy"))
        dbHandler.addOffer(OfferModelClass("PulseO-002","Welln12340105201","Pulse Oximeter-hire- 15D","Pulse Oximeter -1 piece hire for 15 days","AlaCarte","Rs. 200","OximeterRent"))
        dbHandler.addOffer(OfferModelClass("OxyH-007","Welln12340105201","Oxygen hire - 7 days","Oxygen setup hire for 7 days","AlaCarte","Rs. 3000","Oxygen"))
        dbHandler.addOffer(OfferModelClass("NurseVisit-001","Welln12340105201","Once a day nurse visit - 2 h/7d.","Once a day nurse visit - 2 hrs for 7 days","AlaCarte","Rs. 3000","NurseVisit"))
        dbHandler.addOffer(OfferModelClass("DoctorVisit-001","Welln12340105201","Once a day doctor visit - 1 h/7d.","Once a day doctor visit - 1 h/7d.","AlaCarte","Rs. 10000","DoctorVisit"))
        dbHandler.addOffer(OfferModelClass("Vconsult-001","Welln12340105201","Virtual consultation with doctor - on demand - 7 days","Virtual consultation with doctor - on demand - 7 days","AlaCarte","Rs. 2000","VirtualConsultDoc"))
        dbHandler.addOffer(OfferModelClass("Vconsult-002","Welln12340105201","Virtual consultation with technician - on demand - 7 days","Virtual consultation with technician for equipment setup  - on demand - 7 days","AlaCarte","Rs. 500","VirtualConsultTech"))
        dbHandler.addOffer(OfferModelClass("Ambulance-001","Welln12340105201","Ambulance to hospital within  1 hr wait time.","Ambulance to hospital within  1 hr wait time.","AlaCarte","Rs. 3000","Ambulance"))

        dbHandler.addOffer(OfferModelClass("WellnOffer2","Welln12340105201","Stay comfortable","","Managed Service","Rs. 10000",""))

        dbHandler.addOffer(OfferModelClass("WellnOffer3","Welln12340105201","Advanced Home Care","","Managed Service","Rs. 2,00,000",""))

        dbHandler.addOffer(OfferModelClass("GoodnOffer1","Goodh45670425201","Level-0","Basic Covid Support at home","Managed Service","Rs. 6000",""))
        dbHandler.addOffer(OfferModelClass("GN95-001","Goodh45670425201","N95 Mask packet","5 pieces in 1 packet","AlaCarte","Rs. 650","N95"))
        dbHandler.addOffer(OfferModelClass("GSmask-001","Goodh45670425201","Surgical Mask packet","10 pieces in 1 packet","AlaCarte","Rs. 150","SurgicalMask"))
        dbHandler.addOffer(OfferModelClass("GMed-001","Goodh45670425201","Vitamins for 20 days","Vitamin C, Zinc, B12, Vitamin D","AlaCarte","Rs. 1400","Medicine"))
        dbHandler.addOffer(OfferModelClass("GPPE-001","Goodh45670425201","PPE Kit - 2 sets","Full body PPE Kit with Face cover ","AlaCarte","Rs. 1200","PPE"))
        dbHandler.addOffer(OfferModelClass("GPulseO-001","Goodh45670425201","Pulse Oximeter-purchase","Pulse Oximeter -1 piece","AlaCarte","Rs. 700","OximeterBuy"))
        dbHandler.addOffer(OfferModelClass("GOxyH-007","Goodh45670425201","Oxygen hire - 7 days","Oxygen setup hire for 7 days","AlaCarte","Rs. 3500","Oxygen"))

        //------adding data to table_vendor_details
        dbHandler.addVendorDetails(VendorDetailsModelClass("Welln12340105201","Wellness Home Care","ABCD1234","9910395987","9234566777","nvdt13513@gmail.com","Khamla,Nagpur","Khamla,Nagpur","Khamla,Nagpur","Khamla,Nagpur","Khamla,Nagpur","Khamla,Nagpur","12345356","GIF/PNG/PDF doc","4.7"))
        dbHandler.addVendorDetails(VendorDetailsModelClass("Goodh45670425201","GoodHealth Pvt. Ltd","XYXA5672","9146550838","8873356729","jmks@gmail.com","Hinjewadi,Pune","Hinjewadi,Pune","Hinjewadi,Pune","Hinjewadi,Pune","Hinjewadi,Pune","Hinjewadi,Pune","123y779","GIF/PNG/PDF doc","4.5"))
        dbHandler.addVendorDetails(VendorDetailsModelClass("Prera12342005201","Prerana Hospital ","MNQS35678","9820388204","9820378401","aditi_maz1@yahoo.co.in","Hingna,Nagpur","Hingna,Nagpur","Hingna,Nagpur","Hingna,Nagpur","Hingna,Nagpur","Hingna,Nagpur","97354r2456","GIF/PNG/PDF doc","4.4"))
    }

}
