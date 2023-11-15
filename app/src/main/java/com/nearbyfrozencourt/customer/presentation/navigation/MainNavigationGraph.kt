package com.nearbyfrozencourt.customer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nearbyfrozencourt.customer.presentation.AuthViewModel
import com.nearbyfrozencourt.customer.presentation.navigation.util.AuthenticationRoutes
import com.nearbyfrozencourt.customer.presentation.navigation.util.Graph
import com.nearbyfrozencourt.customer.presentation.navigation.util.MainRoutes
import com.nearbyfrozencourt.customer.presentation.screens.LoginScreen
import com.nearbyfrozencourt.customer.presentation.screens.PaymentsScreen

@Composable
fun MainNavigationGraph(navHostController: NavHostController, authViewModel: AuthViewModel = hiltViewModel()) {
//    val isLoggedIn by authViewModel.isLoggedIn
    NavHost(navController = navHostController, route = Graph.MAIN, startDestination = if (authViewModel.isLoggedIn.value) Graph.HOME else Graph.AUTHENTICATION)
    {
        navigation(startDestination = AuthenticationRoutes.Login.route, route = Graph.AUTHENTICATION){
            composable(route = AuthenticationRoutes.Login.route){
                LoginScreen(navHostController = navHostController, authViewModel = authViewModel)
            }
        }
        navigation(startDestination = MainRoutes.Home.route, route = Graph.HOME ){
            composable(route = MainRoutes.Home.route){

            }
            composable(route = MainRoutes.Ledger.route){

            }
            composable(route = MainRoutes.Sales.route){

            }
            composable(route = MainRoutes.Payment.route){
                PaymentsScreen()
            }
        }

    }
}