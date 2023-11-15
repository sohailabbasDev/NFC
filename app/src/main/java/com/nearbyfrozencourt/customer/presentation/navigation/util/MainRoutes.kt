package com.nearbyfrozencourt.customer.presentation.navigation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MainRoutes(val route : String,
                        val title: String,
                        val icon: ImageVector
){
    data object Home : MainRoutes(route = "HOME", title = "Home", icon = Icons.Default.Home)
    data object Sales : MainRoutes(route = "SALES", title = "Sales", icon = Icons.Outlined.ShoppingCart)
    data object Ledger : MainRoutes(route = "LEDGER", title = "Ledger", icon = Icons.Default.List)
    data object Payment : MainRoutes(route = "PAYMENT", title = "Payments", icon = Icons.Filled.Star)
//    object Login : MainRoutes("LOGIN")

}
