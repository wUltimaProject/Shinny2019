package com.wultimaproject.shinny2019.repositories

import com.wultimaproject.shinny2019.models.Result
import com.wultimaproject.shinny2019.models.db.Contact

interface DbRepositoryGeneralInterface {

     suspend fun addSampleContact(contact: Contact)
    suspend fun loadAllContacts() : Result<List<Contact>>
 }