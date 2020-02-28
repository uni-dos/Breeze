package com.the3rdwheel.breeze.reddit.authentication.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.the3rdwheel.breeze.reddit.authentication.response.AuthResponse

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey(autoGenerate = false) val userName: String,
    val karma: Int,
    @Embedded (prefix = "auth_") val authResponse: AuthResponse,
    val currentUser: Int
)