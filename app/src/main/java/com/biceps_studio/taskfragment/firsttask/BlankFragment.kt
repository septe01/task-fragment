package com.biceps_studio.taskfragment.firsttask

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.biceps_studio.taskfragment.Constant
import com.biceps_studio.taskfragment.R
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setTextFromEditText()
    }

    @SuppressLint("SetTextI18n")
    private fun setTextFromEditText() {
        tvBlank.text = "Blank Fragment: ${arguments!!.getString(Constant.DATA)}"
    }
}
