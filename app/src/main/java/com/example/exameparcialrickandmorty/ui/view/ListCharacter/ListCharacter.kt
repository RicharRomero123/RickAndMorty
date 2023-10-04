package com.example.exameparcialrickandmorty.ui.view.ListCharacter

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exameparcialrickandmorty.data.model.Character
import com.example.exameparcialrickandmorty.data.remote.AppCharacterClient
import com.example.exameparcialrickandmorty.data.remote.AppCharacterResponse
import com.example.exameparcialrickandmorty.ui.view.CharacterViewModel
import com.skydoves.landscapist.glide.GlideImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ListCharacter(viewModel: CharacterViewModel,modifier: Modifier = Modifier) {

    val character = remember { mutableStateListOf<Character>() }
    var characterService = AppCharacterClient.AppCharacterService()
    val response = characterService.getAllCharacters()

    response.enqueue(object : Callback<AppCharacterResponse> {
        override fun onResponse(
            call: Call<AppCharacterResponse>,
            response: Response<AppCharacterResponse>
        ) {
            if (response.isSuccessful) {
                character.addAll(response.body()!!.results)
            }
        }

        override fun onFailure(call: Call<AppCharacterResponse>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })

    Column() {
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Text(text = "LIST ALBUM",textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        LazyColumn(modifier = modifier) {
            items( character) {character->
                ListAlbumCard(character, insertHero = { viewModel.insert(character) }, deleteHero = {
                    viewModel.delete(character)
                })
            }
        }
    }

}

@Composable
fun ListAlbumCard(Character: Character,
                  insertHero: () -> Unit,
                  deleteHero: () -> Unit,
                  modifier: Modifier = Modifier
){
    val isFavorite = remember {
        mutableStateOf(false)
    }
    isFavorite.value = Character.favorite

    Card(modifier = modifier
        .fillMaxSize()
        .padding(4.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AlbumImage(Character)
            Spacer(modifier = Modifier.padding(horizontal = 9.dp))
            AlbumItem(Character)
            Spacer(modifier = Modifier.padding(horizontal = 15.dp))
            IconButton(

                onClick = {
                    if (isFavorite.value) { //TRUE
                        deleteHero()
                    } else {
                        insertHero()
                    }
                    isFavorite.value = !isFavorite.value
                }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    tint = if (isFavorite.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
            }
        }

    }
}


@Composable
fun AlbumImage(Character: Character ,modifier: Modifier = Modifier){
    GlideImage(
        imageModel = { Character.image },
        modifier = Modifier
            .size(width = 120.dp, height = 120.dp) // Ajusta el tamaño de la imagen aquí
            .then(modifier) // Mantén otros modificadores
    )
}

@Composable
fun AlbumItem(Character: Character, modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = Character.name , textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Text(text = Character.species, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Text(text = Character.status, textAlign = TextAlign.Center)
    }
}

