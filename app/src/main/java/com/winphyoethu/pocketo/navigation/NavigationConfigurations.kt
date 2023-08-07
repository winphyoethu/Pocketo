package com.winphyoethu.pocketo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.winphyoethu.pocketo.presentation.screen.accountsetup.AccountSetUpScreen
import com.winphyoethu.pocketo.presentation.screen.main.MainScreen
import com.winphyoethu.pocketo.presentation.screen.welcome.WelcomeScreen

@Composable
fun NavigationConfigurations(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Welcome.route) {
        composable(Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(AccountSetUp.route) {
            AccountSetUpScreen(navController)
        }
        composable(Main.route) {
            MainScreen()
        }
    }

}