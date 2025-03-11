package com.hydrogen.roommigrationtestapp.utils

object AppUtils {
    const val APP_DB_VERSION = 4
    val APP_PREVIOUS_DB_VERSION get() = (APP_DB_VERSION - 1)
    const val APP_DB_NAME = "User_db"
}