package com.example.exameparcialrickandmorty.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.exameparcialrickandmorty.data.local.AppCharacterDao
import com.example.exameparcialrickandmorty.data.local.AppCharacterEntity
import com.example.exameparcialrickandmorty.data.model.Character
import com.example.exameparcialrickandmorty.data.remote.AppCharacterResponse
import com.example.exameparcialrickandmorty.data.remote.AppCharacterService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository(
    private val characterService: AppCharacterService,
    private val characterDao: AppCharacterDao
) {
    private val _superHeroes = MutableLiveData<List<Character>>(emptyList())
    val superHeroes get() = _superHeroes
    fun fetchByName(name: String){
        val fetchByName = characterService.getAllCharacters()

        fetchByName.enqueue(object : Callback<AppCharacterResponse> { //
            override fun onResponse(
                call: Call<AppCharacterResponse>,
                response: Response<AppCharacterResponse>
            ) {
                if (response.isSuccessful){
                    if (response.body()!!.results == null){
                        _superHeroes.value = emptyList()
                    }else{
                        _superHeroes.value = response.body()!!.results!!
                        for(superHero in _superHeroes.value!!){
                            superHero.favorite = characterDao.fetchById(superHero.id).isNotEmpty()
                        }
                    }


                }

            }

            override fun onFailure(call: Call<AppCharacterResponse>, t: Throwable) {
                Log.d("SuperHeroRepository", t.message.toString())
            }

        })
    }
    fun insert(character: Character){
        val superHeroEntity = AppCharacterEntity(character.id,character.name,character.status,character.species,character.gender,character.image)
        characterDao.insertProduct(superHeroEntity)
        character.favorite = true
    }

    fun delete(character:Character){
        val superHeroEntity = AppCharacterEntity(character.id,character.name,character.status,character.species,character.gender,character.image)
        characterDao.delete(superHeroEntity)
        character.favorite = false
    }


}
