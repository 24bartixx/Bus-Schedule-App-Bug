package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.ScheduleDao

/**
 * FACTORY CLASS
 * a factory class is meant to initialize view models
 */
class BusScheduleViewModelFactory(private val scheduleDao: ScheduleDao): ViewModelProvider.Factory {
    // boilerplate code to initialize the view model
    // method create return BusScheduleViewModelFactory with some error checking
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException ("Unknown ViewModel class")
    }
}