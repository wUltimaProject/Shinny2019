package com.wultimaproject.shinny2019.repositories

import com.wultimaproject.shinny2019.models.Result
import com.wultimaproject.shinny2019.models.db.Contact
import com.wultimaproject.shinny2019.models.db.ContactDao
import kotlinx.coroutines.GlobalScope
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

