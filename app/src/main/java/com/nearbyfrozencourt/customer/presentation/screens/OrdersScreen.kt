package com.nearbyfrozencourt.customer.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import com.nearbyfrozencourt.customer.presentation.navigation.util.MainRoutes
import com.nearbyfrozencourt.customer.ui.theme.BackColor

@ExperimentalMaterial3Api
@Composable
fun OrdersScreen(navHostController: NavHostController, bottomPadding : Dp) {

    Scaffold(
        modifier = Modifier.padding(bottom = bottomPadding),
        topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Orders") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BackColor, titleContentColor = Color.White)
        )
    },
        floatingActionButton = {
            Button(
                modifier = Modifier.padding(bottom = bottomPadding),
                colors = ButtonDefaults.buttonColors(
                containerColor = BackColor
            ), onClick = { navHostController.navigate(MainRoutes.AddOrder.route) }) {
                Icon(painter = rememberVectorPainter(image = Icons.Default.Add), contentDescription = "Add")
                Text(text = "Add Order request")
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ){it.calculateBottomPadding()
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "No Orders Yet!!", color = Color.Gray, textAlign = TextAlign.Center)
        }
    }
}