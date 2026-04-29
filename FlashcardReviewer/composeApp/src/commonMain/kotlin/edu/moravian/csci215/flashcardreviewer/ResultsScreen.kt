package edu.moravian.csci215.flashcardreviewer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultsScreen(
    deckId: Int,
    onReturnHome: () -> Unit
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Results Summary", style = androidx.compose.material3.MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Score: 0 / 0") // Placeholder for actual results

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = { /* TODO: Restart flashcard screen with all cards */ }, modifier = Modifier.fillMaxWidth()) {
                Text("Review Whole Deck Again")
            }

            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* TODO: Restart flashcard screen with incorrect cards */ }, modifier = Modifier.fillMaxWidth()) {
                Text("Review Incorrect Only")
            }

            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onReturnHome, modifier = Modifier.fillMaxWidth()) {
                Text("Return to Home")
            }
        }
    }
}