package com.wultimaproject.shinny2019.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface ContactDao{

    @Query("DELETE FROM contacts")
     fun dropTable()

    @Insert(onConflict = REPLACE)
     fun save(vararg contact: Contact)

    @Insert(onConflict = REPLACE)
     fun saveList(contactsList: List<Contact>)

    @Delete
     fun delete(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getAllContacts() : List<Contact>



}