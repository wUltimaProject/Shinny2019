package com.wultimaproject.shinny2019.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.wultimaproject.shinny2019.model.Contact


@Dao
interface ContactsDao {

    @Insert(onConflict = REPLACE)
        fun save(contact: Contact)

    @Query("SELECT * FROM contact WHERE contactId = :contactId")
    fun loadContact(contactId: Long)





}