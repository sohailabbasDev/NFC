package com.nearbyfrozencourt.customer.data.remote.dto

data class LoggedInUserDto(
    val `data`: Data
){
    data class Business(
        val accounting_method: String,
        val amount_for_unit_rp: String,
        val code_1: Any,
        val code_2: Any,
        val code_label_1: Any,
        val code_label_2: Any,
        val common_settings: CommonSettings,
        val created_at: String,
        val created_by: Any,
        val crm_settings: String,
        val currency_id: Int,
        val currency_precision: Int,
        val currency_symbol_placement: String,
        val custom_labels: String,
        val date_format: String,
        val default_profit_percent: Int,
        val default_sales_discount: String,
        val default_sales_tax: Any,
        val default_unit: Any,
        val email_settings: EmailSettings,
        val enable_brand: Int,
        val enable_category: Int,
        val enable_editing_product_from_purchase: Int,
        val enable_inline_tax: Int,
        val enable_lot_number: Int,
        val enable_position: Int,
        val enable_price_tax: Int,
        val enable_product_expiry: Int,
        val enable_purchase_status: Int,
        val enable_racks: Int,
        val enable_row: Int,
        val enable_rp: Int,
        val enable_sub_category: Int,
        val enable_sub_units: Int,
        val enable_tooltip: Int,
        val enabled_modules: List<String>,
        val expiry_type: String,
        val fy_start_month: Int,
        val id: Int,
        val is_active: Int,
        val item_addition_method: Int,
        val keyboard_shortcuts: String,
        val logo: String,
        val max_redeem_point: Any,
        val max_rp_per_order: Any,
        val min_order_total_for_redeem: String,
        val min_order_total_for_rp: String,
        val min_redeem_point: Any,
        val name: String,
        val on_product_expiry: String,
        val owner_id: Int,
        val p_exchange_rate: String,
        val pos_settings: String,
        val purchase_currency_id: Any,
        val purchase_in_diff_currency: Int,
        val quantity_precision: Int,
        val redeem_amount_per_unit_rp: String,
        val ref_no_prefixes: RefNoPrefixes,
        val rp_expiry_period: Any,
        val rp_expiry_type: String,
        val rp_name: String,
        val sales_cmsn_agnt: String,
        val sell_price_tax: String,
        val sku_prefix: Any,
        val sms_settings: SmsSettings,
        val start_date: String,
        val stock_expiry_alert_days: Int,
        val stop_selling_before: Int,
        val tax_label_1: Any,
        val tax_label_2: Any,
        val tax_number_1: Any,
        val tax_number_2: Any,
        val theme_color: Any,
        val time_format: String,
        val time_zone: String,
        val transaction_edit_days: Int,
        val updated_at: String,
        val weighing_scale_setting: WeighingScaleSetting
    )

    data class CommonSettings(
        val default_credit_limit: String,
        val default_datatable_page_entries: String,
        val is_product_image_required: String
    )


    data class Data(
        val address: Any,
        val all_permissions: List<Any>,
        val allow_login: Int,
        val alt_number: Any,
        val available_at: Any,
        val bank_details: Any,
        val blood_group: Any,
        val business: Business,
        val business_id: Int,
        val cmmsn_percent: String,
        val contact_no: String,
        val contact_number: Any,
        val created_at: String,
        val crm_contact_id: Int,
        val crm_department: Any,
        val crm_designation: Any,
        val current_address: Any,
        val custom_field_1: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any,
        val deleted_at: Any,
        val dob: Any,
        val email: String,
        val family_number: Any,
        val fb_link: Any,
        val first_name: String,
        val gender: Any,
        val guardian_name: Any,
        val id: Int,
        val id_proof_name: Any,
        val id_proof_number: Any,
        val is_admin: Boolean,
        val is_cmmsn_agnt: Int,
        val language: String,
        val last_name: Any,
        val marital_status: Any,
        val max_sales_discount_percent: Any,
        val paused_at: Any,
        val permanent_address: Any,
        val selected_contacts: Int,
        val social_media_1: Any,
        val social_media_2: Any,
        val status: String,
        val surname: Any,
        val twitter_link: Any,
        val updated_at: String,
        val user_type: String,
        val username: String
    )

    data class EmailSettings(
        val mail_driver: String,
        val mail_encryption: String,
        val mail_from_address: String,
        val mail_from_name: String,
        val mail_host: String,
        val mail_password: String,
        val mail_port: String,
        val mail_username: String
    )

    data class RefNoPrefixes(
        val business_location: String,
        val contacts: String,
        val draft: Any,
        val expense: String,
        val expense_payment: Any,
        val purchase: String,
        val purchase_order: Any,
        val purchase_payment: String,
        val purchase_requisition: Any,
        val purchase_return: Any,
        val sales_order: Any,
        val sell_payment: String,
        val sell_return: String,
        val stock_adjustment: String,
        val stock_transfer: String,
        val subscription: Any,
        val username: Any
    )

    data class SmsSettings(
        val header_1: Any,
        val header_2: Any,
        val header_3: Any,
        val header_val_1: Any,
        val header_val_2: Any,
        val header_val_3: Any,
        val msg_param_name: String,
        val nexmo_from: Any,
        val nexmo_key: Any,
        val nexmo_secret: Any,
        val param_1: Any,
        val param_10: Any,
        val param_2: Any,
        val param_3: Any,
        val param_4: Any,
        val param_5: Any,
        val param_6: Any,
        val param_7: Any,
        val param_8: Any,
        val param_9: Any,
        val param_val_1: Any,
        val param_val_10: Any,
        val param_val_2: Any,
        val param_val_3: Any,
        val param_val_4: Any,
        val param_val_5: Any,
        val param_val_6: Any,
        val param_val_7: Any,
        val param_val_8: Any,
        val param_val_9: Any,
        val request_method: String,
        val send_to_param_name: String,
        val sms_service: String,
        val twilio_from: Any,
        val twilio_sid: Any,
        val twilio_token: Any,
        val url: Any
    )

    data class WeighingScaleSetting(
        val label_prefix: Any,
        val product_sku_length: String,
        val qty_length: String,
        val qty_length_decimal: String
    )
}