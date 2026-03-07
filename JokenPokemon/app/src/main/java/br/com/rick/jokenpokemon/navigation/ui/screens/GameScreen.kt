package br.com.rick.jokenpokemon.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun GameScreen(playerName: String) {
    val options = listOf("Charmander", "Bulbasaur", "Squirtle")
    var playerChoice by remember { mutableStateOf("") }
    var computerChoice by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("Escolha seu Pokémon!") }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Treinador: $playerName", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Você")
                Text(if(playerChoice.isEmpty()) "?" else playerChoice, fontWeight = FontWeight.Bold)
            }
            Text("VS")
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("CPU")
                Text(if(computerChoice.isEmpty()) "?" else computerChoice, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Text(result, style = MaterialTheme.typography.headlineMedium, color = Color.Blue)
        Spacer(modifier = Modifier.height(32.dp))

        options.forEach { pokemon ->
            Button(
                onClick = {
                    playerChoice = pokemon
                    computerChoice = options[Random.nextInt(3)]
                    result = when {
                        playerChoice == computerChoice -> "Empate!"
                        (playerChoice == "Charmander" && computerChoice == "Bulbasaur") ||
                                (playerChoice == "Bulbasaur" && computerChoice == "Squirtle") ||
                                (playerChoice == "Squirtle" && computerChoice == "Charmander") -> "Você venceu!"
                        else -> "Você perdeu!"
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) { Text(pokemon) }
        }
    }
}