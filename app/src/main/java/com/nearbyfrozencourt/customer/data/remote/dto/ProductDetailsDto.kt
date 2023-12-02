package com.nearbyfrozencourt.customer.data.remote.dto

data class ProductDetailsDto(
    val `data`: List<Data>,
    val links: Links,
    val meta: Meta
) {
    data class Data(
        val alert_quantity: Any,
        val barcode_type: String,
        val brand: Brand,
        val business_id: Int,
        val category: Category,
        val created_by: Int,
        val enable_sr_no: Int,
        val enable_stock: Int,
        val expiry_period: Any,
        val expiry_period_type: Any,
        val id: Int,
        val image: String,
        val image_url: String,
        val is_inactive: Int,
        val name: String,
        val not_for_selling: Int,
        val preparation_time_in_minutes: Any,
        val product_custom_field1: String,
        val product_custom_field10: String,
        val product_custom_field11: String,
        val product_custom_field12: String,
        val product_custom_field13: String,
        val product_custom_field14: String,
        val product_custom_field15: String,
        val product_custom_field16: String,
        val product_custom_field17: String,
        val product_custom_field18: String,
        val product_custom_field19: String,
        val product_custom_field2: String,
        val product_custom_field20: String,
        val product_custom_field3: String,
        val product_custom_field4: String,
        val product_custom_field5: String,
        val product_custom_field6: String,
        val product_custom_field7: String,
        val product_custom_field8: String,
        val product_custom_field9: String,
        val product_description: String?,
        val product_locations: List<ProductLocation>,
        val product_tax: Any,
        val product_variations: List<ProductVariation>,
        val secondary_unit_id: Any,
        val sku: String,
        val sub_category: Any,
        val sub_unit_ids: Any,
        val type: String,
        val unit: Unit,
        val warranty_id: Any,
        val weight: String
    ) {
        data class Brand(
            val business_id: Int,
            val created_at: String,
            val created_by: Int,
            val deleted_at: Any,
            val description: Any,
            val id: Int,
            val name: String,
            val updated_at: String
        )

        data class Category(
            val business_id: Int,
            val category_type: String,
            val created_at: String,
            val created_by: Int,
            val deleted_at: Any,
            val description: Any,
            val id: Int,
            val name: String,
            val parent_id: Int,
            val short_code: Any,
            val slug: Any,
            val updated_at: String
        )

        data class ProductLocation(
            val alternate_number: Any,
            val business_id: Int,
            val city: String,
            val country: String,
            val created_at: String,
            val custom_field1: String,
            val custom_field2: Any,
            val custom_field3: Any,
            val custom_field4: Any,
            val default_payment_accounts: String,
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
            val pivot: Pivot,
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
        ) {
            data class Pivot(
                val location_id: Int,
                val product_id: Int
            )
        }

        data class ProductVariation(
            val created_at: String,
            val id: Int,
            val is_dummy: Int,
            val name: String,
            val product_id: Int,
            val updated_at: String,
            val variation_template_id: Any,
            val variations: List<Variation>
        ) {
            data class Variation(
                val combo_variations: List<Any>,
                val created_at: String,
                val default_purchase_price: String,
                val default_sell_price: String,
                val deleted_at: Any,
                val discounts: List<Any>,
                val dpp_inc_tax: String,
                val id: Int,
                val media: List<Media>,
                val name: String,
                val product_id: Int,
                val product_variation_id: Int,
                val profit_percent: String,
                val sell_price_inc_tax: String,
                val sub_sku: String,
                val updated_at: String,
                val variation_location_details: List<VariationLocationDetail>,
                val variation_value_id: Any
            ) {
                data class Media(
                    val business_id: Int,
                    val created_at: String,
                    val description: Any,
                    val display_name: String,
                    val display_url: String,
                    val file_name: String,
                    val id: Int,
                    val model_id: Int,
                    val model_media_type: Any,
                    val model_type: String,
                    val updated_at: String,
                    val uploaded_by: Int
                )

                data class VariationLocationDetail(
                    val created_at: String,
                    val id: Int,
                    val location_id: Int,
                    val product_id: Int,
                    val product_variation_id: Int,
                    val qty_available: String,
                    val updated_at: String,
                    val variation_id: Int
                )
            }
        }

        data class Unit(
            val actual_name: String,
            val allow_decimal: Int,
            val base_unit_id: Any,
            val base_unit_multiplier: Any,
            val business_id: Int,
            val created_at: String,
            val created_by: Int,
            val deleted_at: Any,
            val id: Int,
            val short_name: String,
            val updated_at: String
        )
    }

    data class Links(
        val first: String,
        val last: String,
        val next: String,
        val prev: Any
    )

    data class Meta(
        val current_page: Int,
        val from: Int,
        val last_page: Int,
        val links: List<Link>,
        val path: String,
        val per_page: Int,
        val to: Int,
        val total: Int
    ) {
        data class Link(
            val active: Boolean,
            val label: String,
            val url: String
        )
    }
}