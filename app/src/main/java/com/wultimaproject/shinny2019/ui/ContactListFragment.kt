package com.wultimaproject.shinny2019.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.wultimaproject.shinny2019.R
import com.wultimaproject.shinny2019.databinding.FragmentContactListBinding

class ContactListFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val  binding =DataBindingUtil.inflate(inflater,
             R.layout.fragment_contact_list, container, false) as FragmentContactListBinding



        return binding.root
    }


}
