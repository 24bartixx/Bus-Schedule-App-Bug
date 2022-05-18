package com.example.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query

/**
 * DAO - Data Access Object - Kotlin class that provides access to the data, it includes functions for reading
 * and manipulating data
 * Calling a function on the DAO is the equivalent of performing a SQL command od the database
 * @Dao annotation makes the interface usable with Room
 */
@Dao
interface ScheduleDao {
    // get all rows for the first RecyclerView in the first fragment
    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): List<Schedule>

    // get all rows for the second RecyclerView in the second fragment where bus_stop is equal to the parameter passed to the function
    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getByStopName(stopName: String): List<Schedule>
}