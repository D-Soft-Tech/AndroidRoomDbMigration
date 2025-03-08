package com.hydrogen.roommigrationtestapp.data.local.repositories

import com.hydrogen.roommigrationtestapp.data.local.dao.UserDao
import com.hydrogen.roommigrationtestapp.domain.contracts.UserContract
import com.hydrogen.roommigrationtestapp.domain.model.UserContactModel
import com.hydrogen.roommigrationtestapp.utils.Mapper.toEntity
import com.hydrogen.roommigrationtestapp.utils.Mapper.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class UserRepo(private val userDao: UserDao) : UserContract {
    override fun save(user: UserContactModel) = flow {
        emit(userDao.save(user.toEntity()).toInt())
    }

    override fun getUsers(): Flow<List<UserContactModel>> = userDao.getUsers().map {
        it.map { item -> item.toModel() }
    }

//    override fun deleteUser(user: UserContactModel) = flow {
//        emit(userDao.deleteUser(user.toEntity()))
//    }
}