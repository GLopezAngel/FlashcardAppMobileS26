package edu.moravian.csci215.flashcardreviewer

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

// 1. Define type-safe routes representing your 6 screens
@Serializable
object HomeRoute

@Serializable
data class DeckOverviewRoute(val deckId: Int) // Example of passing an ID to the detail screen

@Serializable
data class EditRoute(val deckId: Int? = null, val cardId: Int? = null) // Nullable for new vs. existing

@Serializable
data class FlashcardRoute(val deckId: Int)

@Serializable
data class ResultsRoute(val deckId: Int)

@Serializable
object SettingsRoute

@Composable
fun App() {
    MaterialTheme {
        // 2. Initialize the NavController to manage navigation state
        val navController = rememberNavController()

        // 3. Define the NavHost and link your UI screens to the routes
        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ) {

            composable<HomeRoute> {
                HomeScreen(
                    onNavigateToSettings = { navController.navigate(SettingsRoute) },
                    onNavigateToDeck = { id -> navController.navigate(DeckOverviewRoute(id)) },
                    onNavigateToEdit = { navController.navigate(EditRoute()) }
                )
            }

            composable<DeckOverviewRoute> { backStackEntry ->
                // Extract the arguments using toRoute()
                val route = backStackEntry.toRoute<DeckOverviewRoute>()
                DeckOverviewScreen(
                    deckId = route.deckId,
                    onNavigateToStudy = { navController.navigate(FlashcardRoute(route.deckId)) }
                )
            }

            composable<EditRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<EditRoute>()
                EditScreen(deckId = route.deckId, cardId = route.cardId)
            }

            composable<FlashcardRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<FlashcardRoute>()
                FlashcardScreen(
                    deckId = route.deckId,
                    onFinishStudy = { navController.navigate(ResultsRoute(route.deckId)) }
                )
            }

            composable<ResultsRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<ResultsRoute>()
                ResultsScreen(
                    deckId = route.deckId,
                    onReturnHome = {
                        navController.navigate(HomeRoute) {
                            popUpTo(HomeRoute) { inclusive = true } // Clears the backstack
                        }
                    }
                )
            }

            composable<SettingsRoute> {
                SettingsScreen()
            }
        }
    }
}
