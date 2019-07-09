package com.wultimaproject.shinny2019.model.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Contact::class) , version = 1, exportSchema = false)

 abstract class ShinnyDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}