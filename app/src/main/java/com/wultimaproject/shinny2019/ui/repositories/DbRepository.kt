package com.wultimaproject.shinny2019.ui.repositories

import androidx.lifecycle.MutableLiveData
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.model.db.ContactDao
import javax.inject.Inject


class DbRepository @Inject constructor(val contactDao: ContactDao) {

    fun addSampleContact (contact: Contact){
        contactDao.save(contact )
    }

    fun loadAllContacts(): List<Contact> {
            return contactDao.getAllContacts()
    }


}