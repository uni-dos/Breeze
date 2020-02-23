package com.the3rdwheel.breeze.authentication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.the3rdwheel.breeze.authentication.db.entity.Account

@Database(entities = [Account::class], version = 1)
abstract class AccountDatabase : RoomDatabase() {


    abstract fun accountDao(): AccountDao


    companion object {
        @Volatile
        private var instance: AccountDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }


        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AccountDatabase::class.java, "accounts.db"
        ).fallbackToDestructiveMigration().build()

    }
}