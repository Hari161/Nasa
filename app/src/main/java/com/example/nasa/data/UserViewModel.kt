package com.example.nasa.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application : Application) :AndroidViewModel(application) {
     val readAllData: LiveData<List<itemsdb>>
     val repository: UserRepository

    init {
        val userDao = NasadataBase.getdatabase(application)?.userDao()
        repository = userDao?.let { UserRepository(it) }!!
        readAllData = repository.readAllData
    }

    fun addUser(itemsdb: itemsdb){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(itemsdb)
        }
    }
}