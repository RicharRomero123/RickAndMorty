package com.example.exameparcialrickandmorty.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppCharacterDao {
    @Query("select * from Character where id=:id") // Se crea en la Entity
    fun fetchById(id: String): List<AppCharacterEntity>

    @Insert()
    fun insertProduct(appCharacterEntity: AppCharacterEntity)

    @Query("SELECT * FROM Character")
    fun getAll(): List<AppCharacterEntity>

    @Delete
    fun delete(appCharacterEntity: AppCharacterEntity)
}
