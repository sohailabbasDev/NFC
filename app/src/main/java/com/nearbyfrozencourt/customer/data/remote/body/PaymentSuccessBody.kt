package com.nearbyfrozencourt.customer.data.remote.body

import com.google.gson.annotations.SerializedName

data class PaymentSuccessBody(
    val contact_id : String,
    val amount : String,
    val method : String,
    val paid_on : String,
    val account_id : String,
    val card_number : String,
    val card_holder_name : String,
    val card_transaction_number : String,
    val card_type : String,
    val card_month : String,
    val card_year : String,
    val card_security : String,
    val transaction_no_1 : String,
    val transaction_no_2 : String,
    val transaction_no_3 : String,
    val cheque_number : String,
    val bank_account_number : String,
    val note : String
)
