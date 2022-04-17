package com.example.nasa.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(items : itemsdb)

    @Query("SELECT * FROM NasamainresponseItem")
    fun getallData():LiveData<List<itemsdb>>
}