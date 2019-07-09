package com.wultimaproject.shinny2019.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)  val contactId: Long?,


    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "address")
    val address: String?,
    @ColumnInfo(name = "message")
    val message: String?,
    @ColumnInfo(name = "phoneNumber")
    val phoneNumber: String?
)

{
    constructor():this(null,"","","","")
}