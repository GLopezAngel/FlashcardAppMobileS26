package edu.moravian.csci215.flashcardreviewer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeckOverviewScreen(
    deckId: Int,
    onNavigateToStudy: () -> Unit
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Deck Overview (ID: $deckId)", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Category: Placeholder")
            Text("Amount of Terms: 0")

            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onNavigateToStudy, modifier = Modifier.fillMaxWidth()) {
                Text("Start Studying")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* TODO: Add navigation to EditScreen with this deckId */ }, modifier = Modifier.fillMaxWidth()) {
                Text("Edit Deck")
            }
        }
    }
}