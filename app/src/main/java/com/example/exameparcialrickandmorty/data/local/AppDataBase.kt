package com.example.exameparcialrickandmorty.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        AppCharacterEntity::class
    ],
    version = 1
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun AppCharacterDao(): AppCharacterDao
    companion object{
        private var INSTANCE : AppDataBase? = null
        fun getInstance(context: Context): AppDataBase{
            INSTANCE = Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "app.db"
            )
                .allowMainThreadQueries()
                .build()
            return INSTANCE as AppDataBase
        }
    }
}