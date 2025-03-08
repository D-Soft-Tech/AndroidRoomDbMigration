package com.hydrogen.roommigrationtestapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val userName: String,
    val address: String,
    val phoneNumber: String,
    @ColumnInfo(defaultValue = "0")
    val age: Int
)