package com.hydrogen.roommigrationtestapp.data.local.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hydrogen.roommigrationtestapp.utils.AppUtils.APP_DB_VERSION

object DbMigrations {
    val MIGRATION_1_2 = object : Migration(APP_DB_VERSION - 1, APP_DB_VERSION) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE user_table ADD COLUMN age INTEGER NOT NULL DEFAULT 0")
        }
    }
}