package com.wultimaproject.shinny2019.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.ui.repositories.DbRepository



class ContactListVM (private val dbRepository: DbRepository) : ViewModel(){

    fun addSampleContact(){
        dbRepository.addSampleContact(Contact(1, "name", "address", "message", "phoneNumber"))
        Log.d("tag", "contactAdded")
    }



    fun loadContacts(){
        dbRepository.loadAllContacts()
    }



}