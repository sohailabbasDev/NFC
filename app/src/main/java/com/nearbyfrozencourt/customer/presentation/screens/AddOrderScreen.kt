package com.nearbyfrozencourt.customer.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.nearbyfrozencourt.customer.data.remote.dto.BusinessDetailsDto
import com.nearbyfrozencourt.customer.presentation.OrdersViewModel
import com.nearbyfrozencourt.customer.presentation.navigation.util.MainRoutes
import com.nearbyfrozencourt.customer.ui.theme.BackColor
import com.nearbyfrozencourt.customer.util.Response
import com.nearbyfrozencourt.customer.util.Toaster

import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.sp
import com.nearbyfrozencourt.customer.data.remote.dto.ProductDetailsDto
import com.nearbyfrozencourt.customer.presentation.screens.components.ProductItem


@ExperimentalMaterial3Api
@Composable
fun AddOrderScreen(navHostController: NavHostController, ordersViewModel: OrdersViewModel = hiltViewModel()) {

    var isExpanded by remember{
        mutableStateOf(false)
    }

    var location by remember{
        mutableStateOf("All")
    }
    val context = LocalContext.current

    val businessDetailsState by ordersViewModel.businessDetailsState
    val productsState by ordersViewModel.productsState

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = MainRoutes.AddOrder.title) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BackColor, titleContentColor = Color.White),
            navigationIcon = {
                IconButton(onClick = {navHostController.popBackStack()})
                {
                    Icon(painter = rememberVectorPainter(image = MainRoutes.AddOrder.icon), contentDescription = "", tint = Color.White)
                }
            },
        )
    }){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ExposedDropdownMenuBox(
                modifier = Modifier
//                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 8.dp),
                expanded = isExpanded, onExpandedChange = {isExpanded = !isExpanded}) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    value = location, onValueChange = {}, readOnly = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black.copy(0.9f),
                    focusedBorderColor = BackColor,
                    unfocusedBorderColor = BackColor.copy(alpha = 0.7f),
                    focusedLabelColor = Color.Gray,
                    cursorColor = BackColor.copy(alpha = 0.7f),
                    selectionColors = TextSelectionColors(
                        handleColor = BackColor.copy(alpha = 0.7f), backgroundColor = BackColor.copy(alpha = 0.7f)
                    ),
                        disabledBorderColor = BackColor,
                        disabledTextColor = Color.Black.copy(0.9f)
                    ),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                    },
                    leadingIcon = {
                        Icon(painter = rememberVectorPainter(image = Icons.Default.LocationOn), contentDescription = "location", tint = BackColor)
                    },
                    textStyle = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Justify),
                    enabled = false
                )

                ExposedDropdownMenu(
                    modifier = Modifier
                        .fillMaxWidth(),
                    expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                    when(businessDetailsState){
                        is Response.Success -> {
                            repeat((businessDetailsState as Response.Success<BusinessDetailsDto>).data.data.locations.size){
                                DropdownMenuItem(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    text = { Text(text = (businessDetailsState as Response.Success<BusinessDetailsDto>).data.data.locations[it].name) },
                                    onClick = {
                                            location = (businessDetailsState as Response.Success<BusinessDetailsDto>).data.data.locations[it].name
//                                            locationId = (businessDetailsState as Response.Success<BusinessDetailsDto>).data.data.locations[it].id.toString()
                                            ordersViewModel.getProductsAsPerLocation((businessDetailsState as Response.Success<BusinessDetailsDto>).data.data.locations[it].id.toString())
                                            isExpanded = false
                                        },
                                    colors = MenuDefaults.itemColors(textColor = Color.Black)
                                )
                            }
                        }
                        is Response.Loading -> {
                            CircularProgressIndicator(color = BackColor)
                        }
                        is Response.Failure -> {
                            Toaster.toastShort(context, (businessDetailsState as Response.Failure).message ?: "Failed to load the locations")
                        }
                    }
                }
            }
            LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                when(productsState){
                    is Response.Success -> {
                        items((productsState as Response.Success<ProductDetailsDto>).data.data){item ->
                            ProductItem(product = item)
                        }
                    }
                    is Response.Loading -> {
                        item {
                            CircularProgressIndicator(color = BackColor)
                        }
                    }
                    is Response.Failure -> {
                        Toaster.toastShort(context, (productsState as Response.Failure).message ?: "Failed to load the products")
                    }
                }
            }


        }
    }
}