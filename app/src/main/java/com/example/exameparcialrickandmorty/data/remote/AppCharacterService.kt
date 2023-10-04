package com.example.exameparcialrickandmorty.data.remote

import com.example.exameparcialrickandmorty.data.model.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AppCharacterService {
    @GET("character")
    fun getAllCharacters(): Call<AppCharacterResponse>

    @GET("character/{id}")
    fun getCharacterById(@Path("id")id:String): Call<Character>
}