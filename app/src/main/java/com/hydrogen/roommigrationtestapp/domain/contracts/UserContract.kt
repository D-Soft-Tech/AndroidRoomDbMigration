package com.hydrogen.roommigrationtestapp.domain.contracts

import com.hydrogen.roommigrationtestapp.domain.model.UserContactModel
import kotlinx.coroutines.flow.Flow

interface UserContract {
    fun save(user: UserContactModel): Flow<Int>
    fun getUsers(): Flow<List<UserContactModel>>
    // fun deleteUser(user: UserContactModel): Flow<Int>
}