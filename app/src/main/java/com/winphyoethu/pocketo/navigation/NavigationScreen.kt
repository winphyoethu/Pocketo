package com.winphyoethu.pocketo.navigation

import com.winphyoethu.pocketo.R

sealed class NavigationScreen(val route: String, val resourceId: Int)

object Welcome : NavigationScreen("welcome", R.string.app_name)

object AccountSetUp : NavigationScreen("account_setup", R.string.app_name)

object Main : NavigationScreen("main", R.string.app_name)
