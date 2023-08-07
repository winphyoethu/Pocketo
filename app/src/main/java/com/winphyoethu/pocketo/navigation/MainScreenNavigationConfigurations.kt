package com.winphyoethu.pocketo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.winphyoethu.pocketo.presentation.screen.account.AccountScreen
import com.winphyoethu.pocketo.presentation.screen.history.HistoryScreen
import com.winphyoethu.pocketo.presentation.screen.home.HomeScreen

@Composable
fun MainScreenNavigationConfigurations(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Wallet.route) {
        composable(Wallet.route) {
            HomeScreen()
        }
        composable(History.route) {
            HistoryScreen()
        }
        composable(Account.route) {
            AccountScreen()
        }
    }

}