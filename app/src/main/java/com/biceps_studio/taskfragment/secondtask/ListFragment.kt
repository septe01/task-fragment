package com.biceps_studio.taskfragment.secondtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.biceps_studio.taskfragment.Constant
import com.biceps_studio.taskfragment.R
import kotlinx.android.synthetic.main.fragment_list.*

@Suppress("DEPRECATION")
class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, Constant.FALSE)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setTitleActivity()
        setLayout()
    }

    private fun setLayout() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(OnlineFragment(), "Online")
        adapter.addFragment(OfflineFragment(), "Offline")

        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setTitleActivity() {
        (activity as AppCompatActivity).supportActionBar!!.title = arguments!!.getString(Constant.TITLE)
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private var fragmentList: ArrayList<Fragment> = ArrayList()
        private var fragmentTitleList: ArrayList<String> = ArrayList()

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            val fragment: Fragment = fragmentList[position]
            val bundle = Bundle()

            bundle.putString(Constant.DATA, fragmentTitleList[position])

            fragment.arguments = bundle

            return fragment
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList[position]
        }
    }
}
