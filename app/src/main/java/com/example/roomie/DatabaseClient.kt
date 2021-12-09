package com.example.roomie


import android.content.Context
import androidx.room.Room


class DatabaseClient private constructor(private val mCtx: Context) {
    //our app database object
    val appDatabase: RoomieDB

    companion object {
        private var mInstance: DatabaseClient? = null
        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance
        }
    }

    init {

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, RoomieDB::class.java, "appDB").build()
    }

    fun getAppDb(): RoomieDB? {
        return appDatabase
    }
}