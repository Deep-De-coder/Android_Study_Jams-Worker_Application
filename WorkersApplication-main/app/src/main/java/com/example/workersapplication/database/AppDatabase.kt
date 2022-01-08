package com.example.workersapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workersapplication.database.workers.Workers
import com.example.workersapplication.database.workers.WorkersDao

@Database(entities = arrayOf(Workers::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun workersDao(): WorkersDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    //.createFromAsset("workers.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}