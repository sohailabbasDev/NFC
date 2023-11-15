package com.nearbyfrozencourt.customer.presentation.navigation.util

sealed class AuthenticationRoutes(val route: String) {
//    object ForgotPassword : AuthenticationRoutes("FORGET-PASSWORD")
//    object SignUp : AuthenticationRoutes("SIGN-UP")
     object Login : AuthenticationRoutes("LOGIN")
}
