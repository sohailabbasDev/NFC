package com.nearbyfrozencourt.customer.presentation.bottom_bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nearbyfrozencourt.customer.presentation.navigation.util.MainRoutes
import com.nearbyfrozencourt.customer.ui.theme.BackColor

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        MainRoutes.Home,
        MainRoutes.Ledger,
        MainRoutes.Sales,
        MainRoutes.Orders,
        MainRoutes.Payment,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if(bottomBarDestination){
        NavigationBar (modifier = Modifier.wrapContentHeight(), containerColor = MaterialTheme.colorScheme.primary) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: MainRoutes,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = BackColor,
            selectedTextColor = BackColor,
            unselectedIconColor = BackColor.copy(alpha = 0.7f),
            unselectedTextColor = BackColor.copy(alpha = 0.7f),
            indicatorColor = Color.White
        ),
//        selectedContentColor = PrimaryTextColor,
//        unselectedContentColor = PrimaryTextColor.copy(alpha = ContentAlpha.disabled),
        onClick = {
            if (screen.route != navController.currentDestination?.route){
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }

        }
    )
}