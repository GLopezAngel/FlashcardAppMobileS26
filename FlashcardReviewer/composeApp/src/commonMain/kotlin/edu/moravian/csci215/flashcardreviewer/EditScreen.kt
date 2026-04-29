package edu.moravian.csci215.flashcardreviewer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditScreen(
    deckId: Int?,
    cardId: Int?
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
            val titleText = if (deckId == null) "Create New Deck" else "Editing Deck $deckId"
            Text(titleText, style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))
            Text("Form fields to edit title, category, and cards will go here.")
        }
    }
}