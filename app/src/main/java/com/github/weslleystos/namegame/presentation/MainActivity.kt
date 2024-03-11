package com.github.weslleystos.namegame.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.weslleystos.namegame.presentation.theme.NameGameTheme
import com.github.weslleystos.namegame.presentation.ui.GameScreen
import com.github.weslleystos.namegame.presentation.ui.Screen
import com.github.weslleystos.namegame.presentation.ui.StartScreen
import com.github.weslleystos.namegame.presentation.ui.getRoute
import com.github.weslleystos.namegame.presentation.vm.GameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameGameTheme {
                AppNavHost(navController = rememberNavController())
            }
        }
    }

    @Composable
    private fun AppNavHost(
        navController: NavHostController,
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.StartScreen.route
        ) {
            composable(Screen.StartScreen.route) {
                hiltViewModel<GameViewModel>()
                StartScreen(
                    onPractice = {
                        navController.navigate(Screen.GameScreen.getRoute("practice"))
                    },
                    onTimed = {}
                )
            }
            composable(
                route = Screen.GameScreen.route,
                arguments = listOf(navArgument("type") { type = NavType.StringType })
            ) { backStackEntry ->
                val type = backStackEntry.arguments?.getString("type") ?: ""
                GameScreen(onSelected = {}, onBack = { navController.popBackStack() })
            }
        }
    }
}

