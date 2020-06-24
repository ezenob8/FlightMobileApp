package com.advancedprogramming2.flightmobileapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Ezequiel
 */
@Dao
interface ServerDao {

    @Query("SELECT * FROM server_entity")
    fun getAllServers() : List<ServerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertServerEntity(serverEntity: ServerEntity)

//    @Insert
//    fun addServer(serverEntity: ServerEntity)
}