package com.example.exameparcialrickandmorty.ui.view.FavouriteCharacter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.example.exameparcialrickandmorty.data.local.AppCharacterDao
import com.example.exameparcialrickandmorty.data.model.Character
import com.example.exameparcialrickandmorty.ui.view.CharacterViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun FavoriteAlbum(appSuperZoundDao: AppCharacterDao, viewModel: CharacterViewModel){


    Row {
        FavouriteCharacter(appSuperZoundDao, viewModel)
    }
    Spacer(modifier = Modifier.padding(4.dp))

}

@Composable
fun FavouriteCharacter(appSuperZoundDao: AppCharacterDao, viewModel: CharacterViewModel){
    val character = remember { mutableStateListOf<Character>() }
    Column() {
        Text(text = "FAVOURITE CHARACTERS",textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
        val tasks = appSuperZoundDao.getAll()
        LazyColumn{
            items(tasks){step->
                FavouriteCard(step.image,step.name ,step.species, deleteHero = {

                })
            }
        }
    }

}

@Composable
fun FavouriteCard(image: String, name: String, species: String,deleteHero: () -> Unit, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row {
            FavouriteImage(image)
            FavouriteRow(name,species,deleteHero)
        }
    }
}


@Composable
fun FavouriteRow(name: String, species: String, deleteHero: () -> Unit,modifier: Modifier = Modifier){

    Row {
        Spacer(modifier = modifier.width(8.dp))
        Column(modifier = modifier.weight(7f)) {
            Text(text = name)
            Text(text = species)
        }
        IconButton(
            modifier = modifier.weight(1f),
            onClick = {
                deleteHero()
            }) {
            Icon(
                Icons.Filled.Clear,
                contentDescription = null,
            )
        }
    }
}


@Composable
fun FavouriteImage(image: String, modifier: Modifier = Modifier){

    GlideImage(
        imageModel = {image}, // loading a network image using an URL.
        modifier = Modifier
            .size(width = 120.dp, height = 120.dp) // Ajusta el tamaño de la imagen aquí
            .then(modifier) )// Mantén otros modificadores)
}