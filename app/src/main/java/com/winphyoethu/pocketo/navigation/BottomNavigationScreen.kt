package com.winphyoethu.pocketo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.ui.graphics.vector.ImageVector
import com.winphyoethu.pocketo.R

sealed class BottomNavigationScreen(val route: String, val resourceId: Int, val icon: ImageVector)

object Wallet : BottomNavigationScreen("wallet", R.string.bottom_bar_home, Icons.Filled.Wallet)

object History : BottomNavigationScreen("history", R.string.bottom_bar_history, Icons.Filled.List)

object Account :
    BottomNavigationScreen("account", R.string.bottom_bar_account, Icons.Filled.AccountCircle)