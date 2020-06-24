package com.advancedprogramming2.flightmobileapp

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.advancedprogramming2.flightmobileapp.ServerDao
import com.advancedprogramming2.flightmobileapp.ServerEntity

@Database(version = 2,entities = [ServerEntity::class], exportSchema =  false)
@TypeConverters(Converters::class)
abstract class FlightMobileDatabase  : RoomDatabase() {
    companion object {
        fun get(application: Application) : FlightMobileDatabase{
            return  Room.databaseBuilder(application,FlightMobileDatabase::class.java,"Flight")
                .fallbackToDestructiveMigration().build()
        }
    }

    abstract fun getServerDao() : ServerDao
}


