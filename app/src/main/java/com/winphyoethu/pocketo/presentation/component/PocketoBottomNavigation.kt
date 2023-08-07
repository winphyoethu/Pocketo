package com.winphyoethu.pocketo.presentation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.winphyoethu.pocketo.navigation.Account
import com.winphyoethu.pocketo.navigation.History
import com.winphyoethu.pocketo.navigation.Wallet

@Composable
fun PocketoBottomNavigation(navController: NavHostController) {

    val bottomNavigationItems = listOf(Wallet, History, Account)

    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar() {
        bottomNavigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                },
                icon = { Icon(item.icon, contentDescription = item.route) },
                label = { Text(stringResource(id = item.resourceId)) }
            )
        }
    }

}