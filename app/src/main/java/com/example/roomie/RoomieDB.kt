package com.example.roomie


import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [UserEntity::class, MessagingEntity::class], version = 1)
abstract class RoomieDB : RoomDatabase() {
    abstract fun userDao(): UserDao?
    abstract fun messageDao(): MessageDao?
}