package com.wultimaproject.shinny2019.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey private val contactId: Long,
    private val name: String,
    private val address: String,
    private val message: String,
    private val phoneNumber: String
)