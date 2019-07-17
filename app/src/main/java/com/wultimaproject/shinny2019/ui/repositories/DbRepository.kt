package com.wultimaproject.shinny2019.ui.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.model.db.ContactDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


 class DbRepository @Inject constructor(val contactDao: ContactDao) {

//    private lateinit var contacts: MutableLiveData<List<Contact>>
//    var contacts: MutableLiveData<List<Contact>> = MutableLiveData()

    fun addSampleContact(entry: Contact): Job {
        return GlobalScope.launch {
            contactDao.save(entry)
        }
    }




   suspend fun loadAllContacts(): List<Contact>  {
//         GlobalScope.launch {
            return GlobalScope.async {
                contactDao.getAllContacts()
            }.await()

            }

}