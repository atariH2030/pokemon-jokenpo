package br.com.rick.jokenpokemon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

// IMPORTS CORRIGIDOS: Apontando para o caminho físico real das telas
import br.com.rick.jokenpokemon.navigation.ui.screens.PlayerNameScreen
import br.com.rick.jokenpokemon.navigation.ui.screens.GameScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.PlayerName.route
    ) {
        composable(Routes.PlayerName.route) {
            PlayerNameScreen { name: String ->
                navController.navigate(Routes.Game.createRoute(name))
            }
        }
        
        composable(
            route = Routes.Game.route,
            arguments = listOf(
                navArgument("playerName") { 
                    type = NavType.StringType 
                }
            )
        ) { backStackEntry ->
            val playerName = backStackEntry.arguments?.getString("playerName") ?: "Treinador"
            GameScreen(playerName = playerName)
        }
    }
}