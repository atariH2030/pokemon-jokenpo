package br.com.rick.jokenpokemon.navigation

sealed class Routes(val route: String) {
    object PlayerName : Routes("player_name")
    object Game : Routes("game/{playerName}") {
        fun createRoute(name: String) = "game/$name"
    }
}