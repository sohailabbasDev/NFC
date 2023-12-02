package com.nearbyfrozencourt.customer.data.remote.dto

data class BusinessDetailsDto(
    val `data`: Data
){
    data class BankTransfer(
        val account: String,
        val is_enabled: String
    )

    data class Card(
        val account: Any
    )

    data class Cash(
        val account: String,
        val is_enabled: String
    )

    data class Cheque(
        val account: Any
    )

    data class CommonSettings(
        val default_credit_limit: String,
        val default_datatable_page_entries: String,
        val is_product_image_required: String
    )

    data class Contact(
        val custom_field_1: Any,
        val custom_field_10: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any,
        val custom_field_5: Any,
        val custom_field_6: Any,
        val custom_field_7: Any,
        val custom_field_8: Any,
        val custom_field_9: Any
    )

    data class Currency(
        val code: String,
        val country: String,
        val created_at: Any,
        val currency: String,
        val decimal_separator: String,
        val id: Int,
        val symbol: String,
        val thousand_separator: String,
        val updated_at: Any
    )

    data class CustomLabels(
        val contact: Contact,
        val location: Location,
        val payments: Payments,
        val product: Product,
        val product_cf_details: List<ProductCfDetail>,
        val purchase: Purchase,
        val purchase_shipping: PurchaseShipping,
        val sell: Sell,
        val shipping: Shipping,
        val types_of_service: TypesOfService,
        val user: User
    )

    data class CustomPay1(
        val account: String,
        val is_enabled: String
    )

    data class CustomPay2(
        val account: Any
    )

    data class CustomPay3(
        val account: Any,
        val is_enabled: String
    )

    data class Data(
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
        val currency: Currency,
        val currency_id: Int,
        val currency_precision: Int,
        val currency_symbol_placement: String,
        val custom_labels: CustomLabels,
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
        val keyboard_shortcuts: KeyboardShortcuts,
        val locations: List<LocationX>,
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
        val pos_settings: PosSettings,
        val printers: List<Printer>,
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

    data class DefaultPaymentAccounts(
        val bank_transfer: BankTransfer,
        val card: Card,
        val cash: Cash,
        val cheque: Cheque,
        val custom_pay_1: CustomPay1,
        val custom_pay_2: CustomPay2,
        val custom_pay_3: CustomPay3,
        val custom_pay_4: CustomPay2,
        val custom_pay_5: CustomPay2,
        val custom_pay_6: CustomPay2,
        val custom_pay_7: CustomPay2,
        val other: Other
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
    data class KeyboardShortcuts(
        val pos: Pos
    )

    data class Location(
        val custom_field_1: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any
    )
    data class LocationX(
        val alternate_number: Any,
        val business_id: Int,
        val city: String,
        val country: String,
        val created_at: String,
        val custom_field1: String,
        val custom_field2: Any,
        val custom_field3: Any,
        val custom_field4: Any,
        val default_payment_accounts: DefaultPaymentAccounts,
        val deleted_at: Any,
        val email: Any,
        val featured_products: Any,
        val id: Int,
        val invoice_layout_id: Int,
        val invoice_scheme_id: Int,
        val is_active: Int,
        val landmark: String,
        val location_id: String,
        val mobile: String,
        val name: String,
        val print_receipt_on_invoice: Int,
        val printer_id: Any,
        val receipt_printer_type: String,
        val sale_invoice_layout_id: Int,
        val sale_invoice_scheme_id: Int,
        val selling_price_group_id: Any,
        val state: String,
        val updated_at: String,
        val website: String,
        val zip_code: String
    )

    data class Other(
        val account: Any
    )

    data class Payments(
        val custom_pay_1: String,
        val custom_pay_2: String,
        val custom_pay_3: String,
        val custom_pay_4: Any,
        val custom_pay_5: Any,
        val custom_pay_6: Any,
        val custom_pay_7: Any
    )

    data class Pos(
        val add_new_product: String,
        val add_payment_row: String,
        val cancel: String,
        val draft: String,
        val edit_discount: String,
        val edit_order_tax: String,
        val express_checkout: String,
        val finalize_payment: String,
        val pay_n_ckeckout: String,
        val recent_product_quantity: String,
        val weighing_scale: Any
    )

    data class PosSettings(
        val allow_overselling: String,
        val amount_rounding_method: String,
        val cash_denominations: Any,
        val cmmsn_calculation_type: String,
        val disable_discount: Int,
        val disable_draft: Int,
        val disable_express_checkout: Int,
        val disable_order_tax: Int,
        val disable_pay_checkout: Int,
        val enable_cash_denomination_for_payment_methods: List<String>,
        val enable_cash_denomination_on: String,
        val enable_payment_link: String,
        val enable_sales_order: String,
        val hide_product_suggestion: Int,
        val hide_recent_trans: Int,
        val is_pos_subtotal_editable: String,
        val razor_pay_key_id: String,
        val razor_pay_key_secret: String,
        val show_invoice_layout: String,
        val stripe_public_key: Any,
        val stripe_secret_key: Any
    )

    data class Printer(
        val business_id: Int,
        val capability_profile: String,
        val char_per_line: String,
        val connection_type: String,
        val created_at: String,
        val created_by: Int,
        val id: Int,
        val ip_address: String,
        val name: String,
        val path: String,
        val port: String,
        val updated_at: String
    )

    data class Product(
        val custom_field_1: Any,
        val custom_field_10: Any,
        val custom_field_11: Any,
        val custom_field_12: Any,
        val custom_field_13: Any,
        val custom_field_14: Any,
        val custom_field_15: Any,
        val custom_field_16: Any,
        val custom_field_17: Any,
        val custom_field_18: Any,
        val custom_field_19: Any,
        val custom_field_2: Any,
        val custom_field_20: Any,
        val custom_field_3: Any,
        val custom_field_4: Any,
        val custom_field_5: Any,
        val custom_field_6: Any,
        val custom_field_7: Any,
        val custom_field_8: Any,
        val custom_field_9: Any
    )

    data class ProductCfDetail(
        val dropdown_options: Any,
        val type: Any
    )

    data class Purchase(
        val custom_field_1: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any
    )

    data class PurchaseShipping(
        val custom_field_1: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any,
        val custom_field_5: Any
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

    data class Sell(
        val custom_field_1: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any
    )

    data class Shipping(
        val custom_field_1: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any,
        val custom_field_5: Any
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

    data class TypesOfService(
        val custom_field_1: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any,
        val custom_field_5: Any,
        val custom_field_6: Any
    )

    data class User(
        val custom_field_1: Any,
        val custom_field_2: Any,
        val custom_field_3: Any,
        val custom_field_4: Any
    )

    data class WeighingScaleSetting(
        val label_prefix: Any,
        val product_sku_length: String,
        val qty_length: String,
        val qty_length_decimal: String
    )
}