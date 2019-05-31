package com.wultimaproject.shinny2019.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wultimaproject.shinny2019.model.Contact


@Database( entities = [Contact::class], version = 1)

abstract class DBManager : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao

}