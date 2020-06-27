package com.chaadride.Toast

import android.content.Context
import android.widget.Toast

object ToastShow {
    fun toast(context: Context, massage: String) {
        Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
    }
}