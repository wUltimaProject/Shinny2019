package com.wultimaproject.shinny2019.ui.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.wultimaproject.shinny2019.model.Result
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.model.db.ContactDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


// class DbRepository : DbRepositoryGeneralInterface{
 class DbRepository @Inject constructor(val contactDao: ContactDao) : DbRepositoryGeneralInterface {



     override suspend fun addSampleContact(entry: Contact) {
         GlobalScope.launch {
             contactDao.save(entry)
         }
     }


     override suspend fun loadAllContacts(): Result<List<Contact>> {
//         GlobalScope.launch {
         return GlobalScope.async {
             Result.Success(contactDao.getAllContacts())
         }.await()
     }
 }

