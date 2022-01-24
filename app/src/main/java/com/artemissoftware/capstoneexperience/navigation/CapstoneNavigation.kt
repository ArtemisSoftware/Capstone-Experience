package com.artemissoftware.capstoneexperience.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.artemissoftware.capstoneexperience.screens.SplashScreen
import com.artemissoftware.capstoneexperience.screens.home.HomeScreen
import com.artemissoftware.capstoneexperience.screens.login.LoginScreen
import com.artemissoftware.capstoneexperience.screens.search.BookSearchScreen
import com.artemissoftware.capstoneexperience.screens.stats.StatsScreen

@ExperimentalComposeUiApi
@Composable
fun CapstoneNavigation() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = CapstoneScreens.SplashScreen.name
    ){

        composable(CapstoneScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(CapstoneScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }

        composable(CapstoneScreens.StatsScreen.name) {
            //val homeViewModel = hiltViewModel<HomeScreenViewModel>()
            StatsScreen(navController = navController/*, viewModel = homeViewModel*/)
        }

        composable(CapstoneScreens.HomeScreen.name) {
            //val homeViewModel = hiltViewModel<HomeScreenViewModel>()
            HomeScreen(navController = navController/*, viewModel = homeViewModel*/)
        }

        composable(CapstoneScreens.SearchScreen.name) {
            //val searchViewModel = hiltViewModel<BooksSearchViewModel>()

            BookSearchScreen(navController = navController/*, viewModel = searchViewModel*/)
        }


    }

}