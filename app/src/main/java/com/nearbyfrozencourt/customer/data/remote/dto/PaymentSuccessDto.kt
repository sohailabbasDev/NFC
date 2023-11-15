package com.nearbyfrozencourt.customer.data.remote.dto

data class PaymentSuccessDto(
    val `data`: Data
){
    data class Data(
        val account_id: String,
        val amount: String,
        val bank_account_number: Any,
        val business_id: Int,
        val card_holder_name: Any,
        val card_month: Any,
        val card_number: Any,
        val card_security: Any,
        val card_transaction_number: Any,
        val card_type: Any,
        val card_year: Any,
        val cheque_number: Any,
        val created_at: String,
        val created_by: Int,
        val document: Any,
        val id: Int,
        val is_advance: Int,
        val method: String,
        val note: Any,
        val paid_on: String,
        val payment_for: String,
        val payment_ref_no: String,
        val payment_type: String,
        val transaction_no: Any,
        val updated_at: String
    )
}