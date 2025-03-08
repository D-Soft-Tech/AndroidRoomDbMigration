package com.hydrogen.roommigrationtestapp.data.local.typeConverters

import androidx.room.TypeConverter
import com.hydrogen.roommigrationtestapp.data.local.entities.User
import com.hydrogen.roommigrationtestapp.domain.model.UserContactModel
import com.hydrogen.roommigrationtestapp.utils.Mapper.toEntity
import com.hydrogen.roommigrationtestapp.utils.Mapper.toModel

class UserDbTypeConverter {
    companion object {
        @JvmStatic
        @TypeConverter
        fun fromUserToUserModel(user: User): UserContactModel = user.toModel()

        @JvmStatic
        @TypeConverter
        fun fromUserModelToUserEntity(userModel: UserContactModel): User = userModel.toEntity()
    }
}