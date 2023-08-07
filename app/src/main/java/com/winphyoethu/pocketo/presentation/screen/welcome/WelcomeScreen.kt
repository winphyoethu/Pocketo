package com.winphyoethu.pocketo.presentation.screen.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.winphyoethu.pocketo.navigation.AccountSetUp

@Composable
fun WelcomeScreen(navController: NavController) {

    Column(modifier = Modifier.padding(0.dp, 32.dp, 0.dp, 0.dp)) {
        Text(text = "Pocketo!")
        Text(text = "Track your expenses in one place.")
        TextButton(onClick = {
            navController.navigate(AccountSetUp.route)
        }) {
            Text(text = "Set up")
        }
    }

}