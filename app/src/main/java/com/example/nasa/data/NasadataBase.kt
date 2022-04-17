package com.example.nasa.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [itemsdb::class],version = 1,exportSchema = false)
abstract class NasadataBase : RoomDatabase(){

    abstract fun userDao():UserDao

    companion object{
        @Volatile
        private var INSTANCE: NasadataBase?= null
        fun getdatabase(context : Context): NasadataBase? {
            val tempinstance = INSTANCE
            if(tempinstance != null){
            return tempinstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NasadataBase::class.java,
                    "NasamainresponseItem"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}