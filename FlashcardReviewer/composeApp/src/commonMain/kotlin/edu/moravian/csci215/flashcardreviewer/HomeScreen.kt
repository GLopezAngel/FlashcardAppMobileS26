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
fun HomeScreen(
    onNavigateToSettings: () -> Unit,
    onNavigateToDeck: (Int) -> Unit,
    onNavigateToEdit: () -> Unit
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
            Text("Your Decks", style = androidx.compose.material3.MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(32.dp))

            // Placeholder for a list of decks
            Button(onClick = { onNavigateToDeck(1) }, modifier = Modifier.fillMaxWidth()) {
                Text("View Mock Deck 1")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToEdit, modifier = Modifier.fillMaxWidth()) {
                Text("Create New Deck")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToSettings, modifier = Modifier.fillMaxWidth()) {
                Text("Settings")
            }
        }
    }
}