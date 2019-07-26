package com.wultimaproject.shinny2019.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.wultimaproject.shinny2019.R
import com.wultimaproject.shinny2019.ShinnyApplication
import com.wultimaproject.shinny2019.databinding.FragmentContactListBinding
import com.wultimaproject.shinny2019.models.db.Contact
import com.wultimaproject.shinny2019.repositories.DbRepository
import com.wultimaproject.shinny2019.viewmodels.ContactListVM
import javax.inject.Inject



class ContactListFragment : BaseFragment(){

    @Inject lateinit var dbRepository: DbRepository

    lateinit var viewModel: ContactListVM



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val  binding =DataBindingUtil.inflate(inflater, R.layout.fragment_contact_list, container, false) as FragmentContactListBinding
        ShinnyApplication.component.inject(this)
        binding.lifecycleOwner = this
        viewModel = ContactListVM(dbRepository)
        binding.viewModel = viewModel

        setCurrentFragment(this)
        setCurrentVM(viewModel)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupObservers()
    }


    fun setupObservers(){
        viewModel.getContact.observe(this, Observer { contacts: List<Contact> ->
            Log.d("TAG", "contacts size: "+ contacts.size)
            }
        )
    }



}
