package br.com.rick.jokenpokemon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import br.com.rick.jokenpokemon.ui.screens.*

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.PlayerName.route) {
        composable(Routes.PlayerName.route) {
            PlayerNameScreen { name -> navController.navigate(Routes.Game.createRoute(name)) }
        }
        composable(
            route = Routes.Game.route,
            arguments = listOf(navArgument("playerName") { type = NavType.StringType })
        ) { backStack ->
            GameScreen(backStack.arguments?.getString("playerName") ?: "Treinador")
        }
    }
}