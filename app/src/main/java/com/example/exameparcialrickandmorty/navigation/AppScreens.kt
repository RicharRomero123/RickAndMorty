package com.example.exameparcialrickandmorty.navigation

sealed class AppScreens(val route: String) {

    object ListCharacter: AppScreens("ListCharacter")
    object Home: AppScreens("Home")
    object FavouriteAlbum: AppScreens("FavoriteAlbum")


}