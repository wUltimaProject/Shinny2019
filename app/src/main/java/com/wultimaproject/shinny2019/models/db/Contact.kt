package com.wultimaproject.shinny2019.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
data class Contact(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "contactId")
//    val contactId: Long,

    @PrimaryKey val uid: Int,

    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "message")
    val message: String,
    @ColumnInfo(name = "phoneNumber")
    val phoneNumber: String
)

{
    constructor():this(-1,"","","","")
}