package com.biceps_studio.taskfragment.secondtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.biceps_studio.taskfragment.Constant
import com.biceps_studio.taskfragment.R
import kotlinx.android.synthetic.main.fragment_offline.*

class OfflineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_offline, container, Constant.FALSE)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvOffline.text = arguments!!.getString(Constant.DATA)
    }
}
