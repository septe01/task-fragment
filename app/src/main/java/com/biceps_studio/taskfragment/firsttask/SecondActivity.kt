package com.biceps_studio.taskfragment.firsttask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.biceps_studio.taskfragment.Constant
import com.biceps_studio.taskfragment.R
import com.biceps_studio.taskfragment.secondtask.HomeFragment
import com.biceps_studio.taskfragment.secondtask.ProfileFragment
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setSupportActionBar(toolbar)

        toolbar.contentInsetStartWithNavigation = 0

        supportActionBar!!.title = "Tugas pertama"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        bottomNavigation.setOnNavigationItemSelectedListener {
            val bundle = Bundle()

            when (it.itemId) {
                R.id.nav_home -> {
                    it.isChecked = Constant.TRUE

                    bundle.putString(Constant.DATA, etInput.text.toString())

                    changeMenu(HomeFragment(), bundle)
                }

                R.id.nav_list -> {
                    it.isChecked = Constant.TRUE

                    bundle.putString(Constant.DATA, etInput.text.toString())

                    changeMenu(BlankFragment(), bundle)
                }

                R.id.nav_profile -> {
                    it.isChecked = Constant.TRUE

                    bundle.putString(Constant.DATA, etInput.text.toString())

                    changeMenu(ProfileFragment(), bundle)
                }
            }

            Constant.FALSE
        }
    }

    private fun changeMenu(fragment: Fragment, bundle: Bundle) {
        fragment.arguments = bundle

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
