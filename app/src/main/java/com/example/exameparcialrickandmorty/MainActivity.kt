package com.example.exameparcialrickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exameparcialrickandmorty.data.local.AppCharacterDao
import com.example.exameparcialrickandmorty.data.local.AppDataBase
import com.example.exameparcialrickandmorty.navigation.AppNavigation
import com.example.exameparcialrickandmorty.ui.theme.ExameParcialRickAndMortyTheme
import com.example.exameparcialrickandmorty.ui.view.CharacterViewModel

class MainActivity : ComponentActivity() {
    private lateinit var taskDao: AppCharacterDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExameParcialRickAndMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel: CharacterViewModel by viewModels()
                    val taskDatabase = AppDataBase.getInstance(applicationContext)
                    taskDao = taskDatabase.AppCharacterDao()
                    //ListAlbum(viewModel)
                    AppNavigation(taskDao, viewModel )
                    //FavoriteAlbum(taskDao, viewModel)

                }
            }
        }
    }
}
