package com.hydrogen.roommigrationtestapp.utils.di

import android.content.Context
import com.hydrogen.roommigrationtestapp.data.local.dao.UserDao
import com.hydrogen.roommigrationtestapp.data.local.db.UserDb
import com.hydrogen.roommigrationtestapp.data.local.repositories.UserRepo
import com.hydrogen.roommigrationtestapp.domain.contracts.UserContract
import com.hydrogen.roommigrationtestapp.domain.useCases.SaveUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object AppManualModule {
    fun providesIoDispatcher(): CoroutineContext = Dispatchers.IO
    private fun providesUserDao(context: Context): UserDao = UserDb.getDbInstance(context).getUserDao()
    private fun providesUserRepository(context: Context): UserContract = UserRepo(providesUserDao(context))

    fun providesSaveUserUseCase(context: Context): SaveUserUseCase = SaveUserUseCase(
        providesUserRepository(context)
    )
}