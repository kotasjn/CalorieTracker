package com.plcoding.calorytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.calorytracker.navigation.navigate
import com.plcoding.calorytracker.ui.theme.CaloryTrackerTheme
import com.plcoding.core.navigation.Route
import com.plcoding.onboarding.presentation.age.AgeScreen
import com.plcoding.onboarding.presentation.gender.GenderScreen
import com.plcoding.onboarding.presentation.height.HeightScreen
import com.plcoding.onboarding.presentation.weight.WeightScreen
import com.plcoding.onboarding.presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navControler = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,
                ) {
                    NavHost(
                        navController = navControler,
                        startDestination = Route.WELCOME,
                        modifier = Modifier.padding(it),
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navControler::navigate)
                        }
                        composable(Route.AGE) {
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navControler::navigate,
                            )
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navControler::navigate)
                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navControler::navigate,
                            )
                        }
                        composable(Route.WEIGHT) {
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navControler::navigate,
                            )
                        }
                        composable(Route.NUTRIENT_GOAL) {
                        }
                        composable(Route.ACTIVITY) {
                        }
                        composable(Route.GOAL) {
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                        }
                        composable(Route.SEARCH) {
                        }
                    }
                }
            }
        }
    }
}
