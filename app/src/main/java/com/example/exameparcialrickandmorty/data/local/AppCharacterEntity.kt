package com.example.exameparcialrickandmorty.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( "Character")
data class AppCharacterEntity (
    @PrimaryKey()
    val id: String,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("status")
    val status: String,
    @ColumnInfo("species")
    val species: String,
    @ColumnInfo("entity")
    val entity: String,
    @ColumnInfo("image")
    val image: String,

)