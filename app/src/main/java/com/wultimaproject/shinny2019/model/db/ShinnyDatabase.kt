package com.wultimaproject.shinny2019.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wultimaproject.shinny2019.model.db.Contact
import com.wultimaproject.shinny2019.model.db.ContactDao

@Database(entities = arrayOf(Contact::class) , version = 1)



public abstract class ShinnyDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

}