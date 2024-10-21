package com.elflin.visualprogramming_20241.route

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elflin.visualprogramming_20241.view.ListMovieView
import com.elflin.visualprogramming_20241.view.MovieDetailView

enum class listScreen(){
    ListMovie,
    MovieDetail,
}

@Composable
fun AppRouting(){

    val navController = rememberNavController()

    Scaffold(

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = listScreen.ListMovie.name,
            modifier = Modifier.padding(innerPadding)
        ){
            // Mengassign view dengan nama route
            composable(route = listScreen.ListMovie.name) {
                ListMovieView(navController = navController)
            }

            //.../MovieDetail/JudulFilm
            composable(route = listScreen.MovieDetail.name+"/{title}",
                arguments = listOf(
                    navArgument("title") {type = NavType.StringType}
                )
            ) { backStackEntry ->
                val title = backStackEntry.arguments?.getString("title")
                MovieDetailView(title!!)
            }
        }
    }
}