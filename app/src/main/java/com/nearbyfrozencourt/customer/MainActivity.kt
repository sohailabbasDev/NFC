package com.nearbyfrozencourt.customer

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.nearbyfrozencourt.customer.presentation.bottom_bar.BottomBar
import com.nearbyfrozencourt.customer.presentation.navigation.MainNavigationGraph
import com.nearbyfrozencourt.customer.ui.theme.NFCTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            NFCTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold(bottomBar = { BottomBar(navController = navController)}) {
                    it.calculateTopPadding()
                    MainNavigationGraph(navHostController = navController)
                }
            }
        }
    }
}