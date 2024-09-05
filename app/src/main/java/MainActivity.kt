package com.example.babycorner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.babycorner.ui.theme.BabyCornerTheme



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContent {
            BabyCornerApp()
        }
    }
}

@Composable
fun BabyCornerApp() {
    BabyCornerTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController = navController)
            }
        ) { innerPadding ->
            BabyCornerNavigation.SetupNavigation(
                navController = navController,
                innerPadding = innerPadding
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BabyCornerAppPreview() {
    BabyCornerTheme {
        BabyCornerApp()
    }
}
