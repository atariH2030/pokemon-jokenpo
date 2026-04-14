package br.com.rick.jokenpokemon.navigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen(playerName: String) {
    val options = listOf("Charmander", "Bulbasaur", "Squirtle")
    
    var playerChoice by remember { mutableStateOf("") }
    var computerChoice by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("Faça sua jogada!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "JokenPokemon",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Treinador: $playerName",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SelectionBox(label = "Sua Escolha", choice = playerChoice)
            
            Text(
                text = "VS",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.secondary
            )
            
            SelectionBox(label = "Escolha da CPU", choice = computerChoice)
        }

        Spacer(modifier = Modifier.height(48.dp))

        val resultColor = when {
            resultText.contains("venceu") -> Color(0xFF4CAF50)
            resultText.contains("perdeu") -> Color.Red
            else -> MaterialTheme.colorScheme.onSurface
        }

        Text(
            text = resultText,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = resultColor
        )

        Spacer(modifier = Modifier.weight(1f))

        options.forEach { pokemon ->
            Button(
                onClick = {
                    playerChoice = pokemon
                    computerChoice = options.random()
                    resultText = checkResult(playerChoice, computerChoice)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(text = pokemon)
            }
        }
    }
}

@Composable
fun SelectionBox(label: String, choice: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, style = MaterialTheme.typography.labelSmall)
        Text(
            text = choice.ifEmpty { "?" },
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

fun checkResult(p: String, c: String): String {
    return when {
        p == c -> "Empate!"
        (p == "Charmander" && c == "Bulbasaur") ||
        (p == "Bulbasaur" && c == "Squirtle") ||
        (p == "Squirtle" && c == "Charmander") -> "Você venceu!"
        else -> "Você perdeu!"
    }
}