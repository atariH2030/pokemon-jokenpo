package br.com.rick.jokenpokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import br.com.rick.jokenpokemon.navigation.AppNavGraph
import br.com.rick.jokenpokemon.navigation.ui.theme.JokenPokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JokenPokemonTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}