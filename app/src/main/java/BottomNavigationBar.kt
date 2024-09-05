package com.example.babycorner

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    Row {
        NavigationBarItem(
            icon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_home), contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("principalPage") }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_favorite), contentDescription = "Favorites") },
            label = { Text("Favorites") },
            selected = false,
            onClick = { /* Ação do botão Favorites */ }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings), contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = false,
            onClick = { /* Ação do botão Settings */ }
        )
    }
}
