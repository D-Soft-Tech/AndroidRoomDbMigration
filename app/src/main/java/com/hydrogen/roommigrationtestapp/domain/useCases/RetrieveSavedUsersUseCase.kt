package com.hydrogen.roommigrationtestapp.domain.useCases

import com.hydrogen.roommigrationtestapp.domain.contracts.UserContract

class RetrieveSavedUsersUseCase(private val repo: UserContract) {
    operator fun invoke() = repo.getUsers()
}