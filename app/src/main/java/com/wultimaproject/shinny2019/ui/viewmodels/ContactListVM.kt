package com.wultimaproject.shinny2019.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ContactListVM (private val dbRepository: DbRepository) : ViewModel(){
    var getContact: MutableLiveData<List<Contact>> = MutableLiveData()
    var sampleContact: Contact = Contact(3, "name", "address", "message", "phoneNumber")


    fun addSampleContact(){
        dbRepository.addSampleContact(sampleContact)
        loadContacts()
    }

//    val contacts = liveData {
//        val data = dbRepository.contactDao.getAllContacts()
//        emit(data)
//    }


    fun loadContacts() {
        GlobalScope.launch {
        getContact.postValue(dbRepository.loadAllContacts())
        }
//      var contacts = liveData {
//           val data = dbRepository.loadAllContacts()
//           emit(data)
//       }
    }
}