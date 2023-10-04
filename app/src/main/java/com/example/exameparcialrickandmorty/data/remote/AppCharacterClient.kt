package com.example.exameparcialrickandmorty.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppCharacterClient {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"
    fun AppCharacterService(): AppCharacterService{
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(AppCharacterService::class.java)
    }
}