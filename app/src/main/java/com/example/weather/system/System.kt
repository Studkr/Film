package com.example.weather.system

import android.app.AlertDialog
import android.content.Context
import com.example.weather.R

fun errorDialog(context: Context, errorMessage: String, onOkClicked: () -> Unit) {
    AlertDialog.Builder(context)
        .setTitle(context.getString(R.string.error))
        .setMessage(errorMessage)
        .setPositiveButton(context.getString(R.string.ok)) { _, _ ->
            onOkClicked()
        }
        .show()
}