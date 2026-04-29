package edu.moravian.csci215.flashcardreviewer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FlashcardScreen(
    deckId: Int,
    onFinishStudy: () -> Unit
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
            Text("Studying Deck: $deckId", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(32.dp))

            // Placeholder for the animatable flashcard
            Box(
                modifier = Modifier
                    .size(300.dp, 200.dp)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("Card Front (Tap to flip)")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { /* TODO: Mark incorrect */ }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
                    Text("Incorrect")
                }
                Button(onClick = { /* TODO: Mark correct */ }, colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                    Text("Correct")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onFinishStudy) {
                Text("Finish Session")
            }
        }
    }
}