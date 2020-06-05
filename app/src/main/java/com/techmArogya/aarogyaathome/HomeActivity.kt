package com.techmArogya.aarogyaathome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity()/*, HomeFragment.OnManagedServicesClickListener */{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if(savedInstanceState==null){
        //load HomeFragment by default
        loadFragment(HomeFragment())

        // load fragment on selection
        loadSelectedFragment()
        }
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
                    loadFragment(EligibilityCheckFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId==R.id.orderStatus ->{
                    loadFragment(OrderStatusFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId==R.id.help ->{
                    loadFragment(EnquiryStatusFragment())
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

}
