package com.example.nasa.data

import androidx.lifecycle.LiveData

class UserRepository(private val userdao: UserDao) {
    val readAllData: LiveData<List<itemsdb>> = userdao.getallData()

    suspend fun addUser(itemsdb: itemsdb){
        userdao.insertData(itemsdb)
    }
}