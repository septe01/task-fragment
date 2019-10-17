package com.biceps_studio.taskfragment.secondtask

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.biceps_studio.taskfragment.Constant
import com.biceps_studio.taskfragment.R
import com.biceps_studio.taskfragment.firsttask.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var backState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFirstFragment()

        initToolbar()
        initEvents()
    }

    private fun initEvents() {
        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> { getFirstFragment() }

                R.id.nav_list -> { getSecondFragment() }

                R.id.nav_profile -> { getThirdFragment() }

                R.id.nav_exit -> { finish() }
            }

            drawer_layout.closeDrawer(GravityCompat.START)

            Constant.TRUE
        }

        btnMove.setOnClickListener { startActivity(Intent(getActivity(), SecondActivity::class.java)) }
    }

    private fun getThirdFragment() {
        setFragment(thirdFragment())

        nav_view.setCheckedItem(R.id.nav_profile)
    }

    private fun thirdFragment(): Fragment {
        val bundle = Bundle()
        bundle.putString(Constant.TITLE, "Profile")
        bundle.putString(Constant.DATA, "")

        val fragment = ProfileFragment()
        fragment.arguments = bundle

        return fragment
    }

    private fun exitApplication() {
        if (backState) {
            finish()
        } else {
            Handler().postDelayed({ backState = Constant.FALSE }, Constant.THREE_SECOND)

            Toast.makeText(getActivity(), "Tekan back sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()

            backState = Constant.TRUE
        }
    }

    private fun getActivity() : Context { return this }

    private fun initToolbar() {
        setSupportActionBar(toolbar)

        toolbar.contentInsetStartWithNavigation = 0

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        val toggle = ActionBarDrawerToggle(getActivity() as Activity, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer_layout.addDrawerListener(toggle)

        toggle.syncState()
    }

    private fun getFirstFragment() {
        setFragment(firstFragment())

        nav_view.setCheckedItem(R.id.nav_home)
    }

    private fun getSecondFragment() {
        setFragment(secondFragment())

        nav_view.setCheckedItem(R.id.nav_list)
    }

    private fun firstFragment() : Fragment {
        val bundle = Bundle()
        bundle.putString(Constant.TITLE, "Home")
        bundle.putString(Constant.DATA, "")

        val fragment = HomeFragment()
        fragment.arguments = bundle

        return fragment
    }

    private fun secondFragment() : Fragment {
        val bundle = Bundle()
        bundle.putString(Constant.TITLE, "List")

        val fragment = ListFragment()
        fragment.arguments = bundle

        return fragment
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fl_root, fragment)
        fragmentTransaction.addToBackStack(Constant.NULL)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() { exitApplication() }
}
