package com.hydrogen.roommigrationtestapp.data.local.migrations

import androidx.room.AutoMigration
import androidx.room.DeleteColumn
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hydrogen.roommigrationtestapp.utils.AppUtils.APP_DB_VERSION
import com.hydrogen.roommigrationtestapp.utils.AppUtils.APP_PREVIOUS_DB_VERSION

object DbMigrations {
    val MIGRATION_1_2 = object : Migration(APP_DB_VERSION - 1, APP_DB_VERSION) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE user_table ADD COLUMN age INTEGER NOT NULL DEFAULT 0")
        }
    }

    val MIGRATION_2_3 = object : Migration((APP_DB_VERSION - 1), APP_DB_VERSION) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE user_table ADD COLUMN ageTimes2 INTEGER NOT NULL DEFAULT 0")
        }
    }

    @DeleteColumn(tableName = "user_table", columnName = "ageTimes2")
    class DeleteColumnSpec : AutoMigrationSpec {
    }
}