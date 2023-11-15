package com.nearbyfrozencourt.customer.util

import android.content.Context
import android.widget.Toast

object Toaster {

    fun toastShort(context: Context, value : String){
        Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
    }
}