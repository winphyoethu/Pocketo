package com.winphyoethu.pocketo.presentation.screen.accountsetup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.winphyoethu.pocketo.navigation.Main

@Composable
fun AccountSetUpScreen(navController: NavController) {

    Column(modifier = Modifier.padding(0.dp, 32.dp, 0.dp, 0.dp)) {
        Text(text = "Set up your Account")
        TextButton(onClick = {
            navController.navigate(Main.route)
        }) {
            Text(text = "Finish")
        }
    }

}