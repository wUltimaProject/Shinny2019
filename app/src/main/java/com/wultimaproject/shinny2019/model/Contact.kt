package com.wultimaproject.shinny2019.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Contact(
    @PrimaryKey private val contactId: Long,
    private val name: String,
    private val address: String,
    private val message: String,
    private val phoneNumber: String
)