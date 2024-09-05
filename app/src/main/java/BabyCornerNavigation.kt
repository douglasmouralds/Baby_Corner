package com.example.babycorner

import MenuApp.History.StoryPage
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.babycorner.MenuApp.PrincipalPage
import com.example.babycorner.MenuApp.StoriesList
import com.example.babycorner.Schedule.EventListScreen
import com.example.babycorner.Schedule.EventScreen

object BabyCornerNavigation {
    @Composable
    fun SetupNavigation(navController: NavHostController, innerPadding: PaddingValues) {
        NavHost(
            navController = navController,
            startDestination = "principalPage",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("principalPage") { PrincipalPage(navController) }
            composable("storiesList") { StoriesList(navController) }
            composable("storyPage/{storyId}") { backStackEntry ->
                val storyId = backStackEntry.arguments?.getString("storyId")?.toIntOrNull()
                storyId?.let {
                    StoryPage(navController, it)
                }
            }
            composable("event_list") { EventListScreen(navController) }
            composable("event/{eventId}") { backStackEntry ->
                val eventId = backStackEntry.arguments?.getString("eventId")?.toIntOrNull()
                EventScreen(navController, eventId)
            }
        }
    }
}

