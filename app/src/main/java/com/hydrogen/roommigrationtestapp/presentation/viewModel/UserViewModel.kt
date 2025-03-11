package com.hydrogen.roommigrationtestapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hydrogen.roommigrationtestapp.domain.useCases.RetrieveSavedUsersUseCase
import com.hydrogen.roommigrationtestapp.domain.useCases.SaveUserUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(
    private val saveUserUseCase: SaveUserUseCase,
    private val retrieveUserUseCase: RetrieveSavedUsersUseCase,
    private val ioDispatcher: CoroutineContext
) : ViewModel() {
    val users = retrieveUserUseCase.invoke()

    fun saveUser(name: String, address: String, phoneNumber: String, age: Int) {
        viewModelScope.launch(ioDispatcher) {
            saveUserUseCase.invoke(name, address, phoneNumber, age)
                .collectLatest {
                    Log.d("SAVE_USER_RESULT", it.toString())
                }
        }
    }

}