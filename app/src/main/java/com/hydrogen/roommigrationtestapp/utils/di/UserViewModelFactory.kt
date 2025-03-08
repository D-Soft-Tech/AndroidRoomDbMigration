package com.hydrogen.roommigrationtestapp.utils.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.hydrogen.roommigrationtestapp.presentation.viewModel.UserViewModel

class UserViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val saveUserUseCase = AppManualModule.providesSaveUserUseCase(context)
        val ioDispatcher = AppManualModule.providesIoDispatcher()
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(saveUserUseCase, ioDispatcher) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}