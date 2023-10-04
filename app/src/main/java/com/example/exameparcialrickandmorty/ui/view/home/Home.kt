package com.example.exameparcialrickandmorty.ui.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exameparcialrickandmorty.R
import com.example.exameparcialrickandmorty.navigation.AppScreens
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Home(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de Branding usando Glide
            GlideImage(
                imageModel = { "https://i.pinimg.com/736x/7e/32/3c/7e323c9c7a8d249b82e69e2429bb5a8e.jpg" },
                modifier = Modifier.size(200.dp),
                )
            // Espacio entre la imagen y los botones
            Spacer(modifier = Modifier.height(16.dp))

            // Botones
            Button(
                onClick = {navController.navigate(AppScreens.ListCharacter.route)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Agrega un espacio alrededor del botón
                    .clip(shape = RoundedCornerShape(8.dp)) // Redondea las esquinas del botón
                    .padding(8.dp), // Agrega un espacio interno dentro del botón
            ) {
                Text(
                    text = "List Characters",
                    color = Color.White, // Cambia el color del texto del botón
                    fontWeight = FontWeight.Bold, // Cambia el peso de la fuente
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate(AppScreens.FavouriteAlbum.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Agrega un espacio alrededor del botón
                    .clip(shape = RoundedCornerShape(8.dp)) // Redondea las esquinas del botón
                    .padding(8.dp), // Agrega un espacio interno dentro del botón
            ) {
                Text(
                    text = "Favourites Characters",
                    color = Color.White, // Cambia el color del texto del botón
                    fontWeight = FontWeight.Bold, // Cambia el peso de la fuente
                )
            }
        }
    }
}

