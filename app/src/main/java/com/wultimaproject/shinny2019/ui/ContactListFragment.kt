package com.wultimaproject.shinny2019.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.wultimaproject.shinny2019.R
import com.wultimaproject.shinny2019.ShinnyApplication
import com.wultimaproject.shinny2019.databinding.FragmentContactListBinding
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import com.wultimaproject.shinny2019.ui.viewmodels.ContactListVM
import java.lang.annotation.Inherited
import javax.inject.Inject



class ContactListFragment : Fragment(){

    @Inject lateinit var dbRepository: DbRepository

    lateinit var viewModel: ContactListVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val  binding =DataBindingUtil.inflate(inflater, R.layout.fragment_contact_list, container, false) as FragmentContactListBinding

        ShinnyApplication.component.inject(this)

        binding.lifecycleOwner = this
        viewModel = ContactListVM(dbRepository)
        binding.viewModel = viewModel
        return binding.root



    }



}
