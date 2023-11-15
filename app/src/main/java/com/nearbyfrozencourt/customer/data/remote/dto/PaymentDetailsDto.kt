package com.nearbyfrozencourt.customer.data.remote.dto

data class PaymentDetailsDto(
    val data : List<Data>?
){
    data class Data(
        val account_details: List<AccountDetail>?,
        val account_number: String?,
        val account_type_id: Int?,
        val business_id: Int?,
        val created_at: String?,
        val created_by: Int?,
        val deleted_at: Any?,
        val id: Int?,
        val is_closed: Int?,
        val name: String?,
        val note: Any?,
        val updated_at: String?
    )

    data class AccountDetail(
        val label: String?,
        val value: String?
    )
}