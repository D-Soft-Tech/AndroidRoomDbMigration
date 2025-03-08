package com.hydrogen.roommigrationtestapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hydrogen.roommigrationtestapp.data.local.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: User): Long

    @Query("SELECT * FROM user_table")
    fun getUsers(): Flow<List<User>>

//    @Delete
//    suspend fun deleteUser(user: User): Int
}