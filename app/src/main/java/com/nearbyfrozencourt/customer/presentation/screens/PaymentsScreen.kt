package com.nearbyfrozencourt.customer.presentation.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nearbyfrozencourt.customer.presentation.PaymentViewModel
import com.nearbyfrozencourt.customer.ui.theme.BackColor
import com.nearbyfrozencourt.customer.util.Response
import com.nearbyfrozencourt.customer.util.Toaster


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentsScreen(paymentViewModel: PaymentViewModel = hiltViewModel()) {

    val state by paymentViewModel.paymentState
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {

        }
    )

    LaunchedEffect(Unit){
        paymentViewModel.getPaymentDetails()
    }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Payments") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BackColor, titleContentColor = Color.White)
        )
    }) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state is Response.Success || state is Response.Failure){
                if (state is Response.Failure){
                    Toaster.toastShort(context, "Failed to load the payment details")
                }
//                OutlinedTextField(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 12.dp)
//                        .padding(top = 8.dp, bottom = 4.dp),
//                    value = paymentViewModel.payeeName.value,
//                    onValueChange = {name ->
//                        if (paymentViewModel.isDataLoaded.value.not()){
//                            paymentViewModel.payeeName.value = name
//                        }
//                    },
//                    label = { Text(text = "Payee Name")},
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        textColor = Color.Black.copy(0.9f),
//                        focusedBorderColor = BackColor,
//                        unfocusedBorderColor = BackColor.copy(alpha = 0.7f),
//                        focusedLabelColor = Color.Gray,
//                        cursorColor = BackColor.copy(alpha = 0.7f),
//                        selectionColors = TextSelectionColors(handleColor = BackColor.copy(alpha = 0.7f), backgroundColor = BackColor.copy(alpha = 0.7f))
//                    ),
//                    singleLine = true,
//                    readOnly = paymentViewModel.isDataLoaded.value
//                )
//                OutlinedTextField(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 12.dp)
//                        .padding(bottom = 4.dp),
//                    value = paymentViewModel.payeeVPA.value,
//                    onValueChange = {vpa ->
//                        if (paymentViewModel.isDataLoaded.value.not()){
//                            paymentViewModel.payeeVPA.value = vpa
//                        }
//                    },
//                    label = { Text(text = "Payee VPA Id")},
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        textColor = Color.Black.copy(0.9f),
//                        focusedBorderColor = BackColor,
//                        unfocusedBorderColor = BackColor.copy(alpha = 0.7f),
//                        focusedLabelColor = Color.Gray,
//                        cursorColor = BackColor.copy(alpha = 0.7f),
//                        selectionColors = TextSelectionColors(handleColor = BackColor.copy(alpha = 0.7f), backgroundColor = BackColor.copy(alpha = 0.7f))
//                    ),
//                    singleLine = true,
//                    readOnly = paymentViewModel.isDataLoaded.value
//                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .padding(bottom = 4.dp),
                    value = paymentViewModel.amount.value,
                    onValueChange = {amount -> paymentViewModel.amount.value = amount},
                    label = { Text(text = "Amount")},
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black.copy(0.9f),
                        focusedBorderColor = BackColor,
                        unfocusedBorderColor = BackColor.copy(alpha = 0.7f),
                        focusedLabelColor = Color.Gray,
                        cursorColor = BackColor.copy(alpha = 0.7f),
                        selectionColors = TextSelectionColors(handleColor = BackColor.copy(alpha = 0.7f), backgroundColor = BackColor.copy(alpha = 0.7f))
                    ),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .padding(bottom = 4.dp),
                    value = paymentViewModel.description.value,
                    onValueChange = {description-> paymentViewModel.description.value = description},
//                leadingIcon = {
//                    Icon(painter = rememberVectorPainter(image = Icons.Default.Person), contentDescription = "name", tint = BackColor)
//                },
                    label = { Text(text = "Description") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black.copy(0.9f),
                        focusedBorderColor = BackColor,
                        unfocusedBorderColor = BackColor.copy(alpha = 0.7f),
                        focusedLabelColor = Color.Gray,
                        cursorColor = BackColor.copy(alpha = 0.7f),
                        selectionColors = TextSelectionColors(handleColor = BackColor.copy(alpha = 0.7f), backgroundColor = BackColor.copy(alpha = 0.7f))
                    ),
                    maxLines = 3
                )
                Button(
                    onClick = {
                        if (paymentViewModel.payeeName.value.isEmpty()){
                            Toaster.toastShort(context, "Please enter the payee Name")
                            return@Button
                        }
                        if (paymentViewModel.payeeVPA.value.isEmpty()){
                            Toaster.toastShort(context, "Please enter VPA id")
                            return@Button
                        }
                        if (paymentViewModel.amount.value.isEmpty()){
                            Toaster.toastShort(context, "Please enter amount")
                            return@Button
                        }
                        val uri = Uri.Builder()
                            .scheme("upi").authority("pay")
                            .appendQueryParameter("pa", paymentViewModel.payeeVPA.value)
                            .appendQueryParameter("pn", paymentViewModel.payeeName.value)
                            .appendQueryParameter("tn", paymentViewModel.description.value)
                            .appendQueryParameter("am", paymentViewModel.amount.value)
                            .appendQueryParameter("tid", "")
                            .appendQueryParameter("tr", "")
                            .appendQueryParameter("cu", "INR")
                            .build()

                        val upiIntent = Intent(Intent.ACTION_VIEW)
                        upiIntent.data = uri
                        val chooser = Intent.createChooser(upiIntent, "Pay")
                        launcher.launch(chooser)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BackColor)
                ) {
                    Text(text = "Pay Now")
                }
            }
            if (state is Response.Loading){
                Column(modifier = Modifier.fillMaxSize().padding(bottom = it.calculateBottomPadding()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(color = BackColor)
                }
            }
        }
    }
}