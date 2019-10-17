package com.biceps_studio.taskfragment.secondtask

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.biceps_studio.taskfragment.Constant
import com.biceps_studio.taskfragment.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setTitleActivity()
        setTextFromEditText()
    }

    @SuppressLint("SetTextI18n")
    private fun setTextFromEditText() {
        tvProfile.text = "Profile Fragment: ${arguments!!.getString(Constant.DATA)}"
    }


    private fun setTitleActivity() {
        if (arguments!!.getString(Constant.TITLE) != null) {
            (activity as AppCompatActivity).supportActionBar!!.title = arguments!!.getString(Constant.TITLE)
        }
    }
}
