package com.winphyoethu.pocketo.presentation.screen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.winphyoethu.pocketo.navigation.MainScreenNavigationConfigurations
import com.winphyoethu.pocketo.presentation.component.PocketoBottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(bottomBar = {
        PocketoBottomNavigation(navController)
    }) {
        MainScreenNavigationConfigurations(navController = navController)
    }

}