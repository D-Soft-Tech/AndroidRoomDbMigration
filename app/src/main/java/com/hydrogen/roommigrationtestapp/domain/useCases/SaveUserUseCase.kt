package com.hydrogen.roommigrationtestapp.domain.useCases

import com.hydrogen.roommigrationtestapp.domain.contracts.UserContract
import com.hydrogen.roommigrationtestapp.domain.model.UserContactModel
import kotlinx.coroutines.flow.Flow

class SaveUserUseCase(private val userRepo: UserContract) {

    fun invoke(userName: String, userAddress: String, userPhoneNumber: String, age: Int): Flow<Int> {
        val user = UserContactModel(null, userName, userAddress, userPhoneNumber, age, (age*2))
        return userRepo.save(user)
    }
}