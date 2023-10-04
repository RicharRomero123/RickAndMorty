package com.example.exameparcialrickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exameparcialrickandmorty.data.local.AppCharacterDao
import com.example.exameparcialrickandmorty.ui.view.CharacterViewModel
import com.example.exameparcialrickandmorty.ui.view.FavouriteCharacter.FavoriteAlbum
import com.example.exameparcialrickandmorty.ui.view.ListCharacter.ListCharacter
import com.example.exameparcialrickandmorty.ui.view.home.Home
import com.example.exameparcialrickandmorty.ui.view.ListCharacter.ListCharacter
@Composable
fun AppNavigation(appCharacterDao: AppCharacterDao,viewModel: CharacterViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Home.route, builder = {

        composable(route = AppScreens.ListCharacter.route){
            ListCharacter(viewModel)
        }
        composable(route = AppScreens.Home.route){
            Home(navController)
        }
        composable(route = AppScreens.FavouriteAlbum.route){
            FavoriteAlbum(appCharacterDao, viewModel)
        }
    })

}