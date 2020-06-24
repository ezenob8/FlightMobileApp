package com.advancedprogramming2.flightmobileapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ServerActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository  = ServerEntityRepository(application)
    val serverEntityList : LiveData<MutableList<ServerEntity>>
    val currentURL: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        this.serverEntityList = this.repository.serverEntityList
    }

    fun populateServersList(){
        repository.populateServerEntityList()
    }

    fun addServerEntity(serverEntity: ServerEntity){
        repository.addServerEntity(serverEntity)
    }

    fun setCurrentURL(url:String){
        this.currentURL.value = url
        this.currentURL.value = this.currentURL.value
    }

}