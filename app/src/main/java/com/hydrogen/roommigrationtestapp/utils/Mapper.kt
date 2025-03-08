package com.hydrogen.roommigrationtestapp.utils

import com.hydrogen.roommigrationtestapp.data.local.entities.User
import com.hydrogen.roommigrationtestapp.domain.model.UserContactModel

object Mapper {
    fun UserContactModel.toEntity(): User = User(id, name, address, phoneNumber, age)
    fun User.toModel(): UserContactModel = UserContactModel(id, userName, address, phoneNumber, age)
}