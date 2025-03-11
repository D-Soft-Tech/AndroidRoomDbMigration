package com.hydrogen.roommigrationtestapp.domain.model

data class UserContactModel(
    val id: Int?,
    val name: String,
    val address: String,
    val phoneNumber: String,
    val age: Int,
    val ageTimes2: Int
)
