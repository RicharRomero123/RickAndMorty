package com.example.exameparcialrickandmorty.ui.view

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.exameparcialrickandmorty.data.local.AppDataBase
import com.example.exameparcialrickandmorty.data.model.Character
import com.example.exameparcialrickandmorty.data.remote.AppCharacterClient
import com.example.exameparcialrickandmorty.repository.CharacterRepository

class CharacterViewModel (application: Application): AndroidViewModel(application) {

    private var superHeroService = AppCharacterClient.AppCharacterService()
    private var superHeroDao = AppDataBase.getInstance(application)
    val database = superHeroDao.AppCharacterDao()
    private var superHeroRepository = CharacterRepository(superHeroService,database)
    private var _superHeroes= superHeroRepository.superHeroes

    val superHeroes get()= _superHeroes

    private var _name = MutableLiveData<String>()
    val name get() = _name


    fun update(name: String){
        _name.value = name
    }

    fun fetchByName(){
        superHeroRepository.fetchByName(name.value!!)
        _superHeroes.value = superHeroRepository.superHeroes.value
    }

    fun insert(superZound: Character){
        superHeroRepository.insert(superZound)
    }

    fun delete(character: Character){
        superHeroRepository.delete(character)
    }
    fun getFavoriteCharacters(): List<Character> {
        return superHeroes.value?.filter { it.favorite } ?: emptyList()
    }


}

