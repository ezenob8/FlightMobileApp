package com.advancedprogramming2.flightmobileapp

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "server_entity")
 data class ServerEntity(
    val url: String,
    @Nullable
    val lastConnection : Date?
){
    @NonNull
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

