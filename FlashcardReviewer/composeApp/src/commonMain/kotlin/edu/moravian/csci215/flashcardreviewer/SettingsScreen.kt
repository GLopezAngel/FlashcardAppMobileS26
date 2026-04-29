package edu.moravian.csci215.flashcardreviewer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Settings & Notifications", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(32.dp))

            // Placeholders for DataStore toggles
            Text("• Notification Setup")
            Text("• Language Preferences")
            Text("• App Theme Toggle")
            Text("• Sound Effects Toggle")
        }
    }
}