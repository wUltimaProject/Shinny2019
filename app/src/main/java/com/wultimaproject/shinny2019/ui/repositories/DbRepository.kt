package com.wultimaproject.shinny2019.ui.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.model.db.ContactDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


class DbRepository @Inject constructor(val contactDao: ContactDao) {

//    fun addSampleContact (contact: Contact){
//        contactDao.save(contact)
//    }

    fun addSampleContact(entry: Contact): Job {
        return GlobalScope.launch {
            contactDao.save(entry)
        }
    }

    fun loadAllContacts()  {

         GlobalScope.launch {
          var contacts =  contactDao.getAllContacts()

        }
    }


}