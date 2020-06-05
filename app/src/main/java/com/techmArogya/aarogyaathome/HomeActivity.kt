package com.techmArogya.aarogyaathome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //load HomeFragment by default
        loadFragment(HomeFragment())

        // load fragment on selection
        loadSelectedFragment()

    }

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
            fragmentTransaction.replace(R.id.fragmetContainer,fragment)
            fragmentTransaction.commit()
        }
    }
}
