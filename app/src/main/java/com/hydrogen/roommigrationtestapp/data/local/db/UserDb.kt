package com.hydrogen.roommigrationtestapp.data.local.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hydrogen.roommigrationtestapp.data.local.dao.UserDao
import com.hydrogen.roommigrationtestapp.data.local.entities.User
import com.hydrogen.roommigrationtestapp.data.local.migrations.DbMigrations
import com.hydrogen.roommigrationtestapp.data.local.migrations.DbMigrations.MIGRATION_2_3
import com.hydrogen.roommigrationtestapp.data.local.typeConverters.UserDbTypeConverter
import com.hydrogen.roommigrationtestapp.utils.AppUtils.APP_DB_NAME
import com.hydrogen.roommigrationtestapp.utils.AppUtils.APP_DB_VERSION

@Database(
    entities = [User::class],
    version = APP_DB_VERSION,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(
            from = (APP_DB_VERSION - 1),
            to = APP_DB_VERSION,
            spec = DbMigrations.DeleteColumnSpec::class
        )
    ]
)
@TypeConverters(
    UserDbTypeConverter::class
)
abstract class UserDb : RoomDatabase() {
    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDb? = null

        fun getDbInstance(context: Context): UserDb = synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, UserDb::class.java, APP_DB_NAME)
                .build()
                .also {
                    INSTANCE = it
                }
        }
    }
}