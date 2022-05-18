package com.example.busschedule.database.schedule

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * AppDatabase is subclass of RoomDatabase
 * App Database needs to:
 * - specify which entities are defined in the database
 * - provide access to a single instance of each DAO class
 * - perform any additional setup, such as pre-populating the database
 */

@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    // the database class allows other classes easy access other to the DAO classes
    abstract fun scheduleDao(): ScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, AppDatabase::class.java,"app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}