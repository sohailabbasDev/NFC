package com.nearbyfrozencourt.customer.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.nearbyfrozencourt.customer.R
import com.nearbyfrozencourt.customer.presentation.AuthViewModel
import com.nearbyfrozencourt.customer.presentation.navigation.util.Graph
import com.nearbyfrozencourt.customer.presentation.navigation.util.MainRoutes
import com.nearbyfrozencourt.customer.ui.theme.BackColor
import com.nearbyfrozencourt.customer.util.Response
import com.nearbyfrozencourt.customer.util.Toaster

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(authViewModel: AuthViewModel, navHostController: NavHostController) {

    val loginState by authViewModel.state
    val context = LocalContext.current
//    val isLoggedIn by authViewModel.isLoggedIn

//    LaunchedEffect(isLoggedIn){
//        if (isLoggedIn){
//            navHostController.popBackStack()
//            navHostController.navigate(Graph.HOME)
//        }
//    }

    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    val icon = if (passwordVisibility){
        painterResource(id = R.drawable.baseline_visibility_24)
    }else{
        painterResource(id = R.drawable.baseline_visibility_off_24)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(loginState){
            is Response.Loading -> {
                if ((loginState as Response.Loading).loading){
                    CircularProgressIndicator(color = Color.Blue)
                }else{
//                    Image(modifier = Modifier, painter = painterResource(id = R.drawable.nfc120px), contentDescription = "logo")
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 4.dp),
                        value = authViewModel.username.value,
                        onValueChange = {value -> authViewModel.username(value)},
                        leadingIcon = {
                            Icon(painter = rememberVectorPainter(image = Icons.Default.Person), contentDescription = "name", tint = BackColor)
                        },
                        label = { Text(text = "username")},
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.Black.copy(0.9f),
                            focusedBorderColor = BackColor,
                            unfocusedBorderColor = BackColor.copy(alpha = 0.7f),
                            focusedLabelColor = Color.Gray,
                            cursorColor = BackColor.copy(alpha = 0.7f),
                            selectionColors = TextSelectionColors(handleColor = BackColor.copy(alpha = 0.7f), backgroundColor = BackColor.copy(alpha = 0.7f))
                        ),
                        singleLine = true
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                            .padding(top = 4.dp, bottom = 12.dp),
                        value = authViewModel.password.value,
                        onValueChange = {value ->authViewModel.password(value)},
                        leadingIcon = {
                            Icon(painter = rememberVectorPainter(image = Icons.Default.Lock), contentDescription = "name", tint = BackColor)
                        },
                        trailingIcon = {
                            IconButton(onClick = {passwordVisibility = !passwordVisibility}){
                                Icon(painter = icon, contentDescription = "password", tint = BackColor)
                            }
                        },
                        label = { Text(text = "password")},
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.Black.copy(0.9f),
                            focusedBorderColor = BackColor,
                            unfocusedBorderColor = BackColor.copy(alpha = 0.7f),
                            focusedLabelColor = Color.Gray,
                            cursorColor = BackColor.copy(alpha = 0.7f),
                            selectionColors = TextSelectionColors(handleColor = BackColor.copy(alpha = 0.7f), backgroundColor = BackColor.copy(alpha = 0.7f))
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        singleLine = true
                    )
                    Button(
                        onClick = { authViewModel.generateToken() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BackColor)
                    ) {
                        Text(text = "Login")
                    }
                }
            }
            is Response.Success -> {
                Toaster.toastShort(context, "Login is successful")
                LaunchedEffect(Unit){
                    navHostController.popBackStack()
                    navHostController.navigate(MainRoutes.Home.route)
                }
            }
            is Response.Failure -> {
                if ((loginState as Response.Failure).message!!.contains("400")){
                    Toaster.toastShort(context, "You have entered incorrect username or password")
                }else{
                    Toaster.toastShort(context, "Please retry again, something went wrong")
                }
            }
        }
    }
}