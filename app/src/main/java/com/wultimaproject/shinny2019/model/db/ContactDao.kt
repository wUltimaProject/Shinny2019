package com.wultimaproject.shinny2019.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface ContactDao{

    @Query("DELETE FROM contacts")
    abstract fun dropTable()

    @Insert(onConflict = REPLACE)
    abstract fun save(contact: Contact)

    @Insert(onConflict = REPLACE)
    abstract fun save(contactsList: List<Contact>)

    @Delete
    abstract fun delete(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun getAllContacts() : List<Contact>



}