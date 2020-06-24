package com.advancedprogramming2.flightmobileapp

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData

class ServerEntityRepository(val application: Application) {

    val serverEntityList = MutableLiveData<MutableList<ServerEntity>>()

    init {
        serverEntityList.value = ArrayList()
    }

    fun populateServerEntityList() {
        var listServerEntity:MutableList<ServerEntity> = arrayListOf(
            ServerEntity( "localhost1",null), ServerEntity( "localhost2",null),
            ServerEntity( "localhost3",null), ServerEntity( "localhost4",null),
            ServerEntity( "localhost5", null)
        )
        serverEntityList.value = listServerEntity
        InsertServerEntityData(listServerEntity,application).execute()

    }

    fun addServerEntity(serverEntity:ServerEntity){
        serverEntityList.value?.add(serverEntity)
        serverEntityList.value = serverEntityList.value
        var list: MutableList<ServerEntity> = arrayListOf(serverEntity)
        InsertServerEntityData(list,application).execute()
    }

    class InsertServerEntityData(val servers: MutableList<ServerEntity>, val application: Application) :
        AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            for(serverEntity in servers){
                FlightMobileDatabase.get(application).getServerDao().insertServerEntity(serverEntity)
            }
            return null
        }

    }

}