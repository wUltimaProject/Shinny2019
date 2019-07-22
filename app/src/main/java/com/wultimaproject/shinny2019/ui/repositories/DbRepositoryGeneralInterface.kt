package com.wultimaproject.shinny2019.ui.repositories

import com.wultimaproject.shinny2019.model.Result
import com.wultimaproject.shinny2019.model.db.Contact

interface DbRepositoryGeneralInterface {

     suspend fun addSampleContact(contact: Contact)
    suspend fun loadAllContacts() : Result<List<Contact>>
 }