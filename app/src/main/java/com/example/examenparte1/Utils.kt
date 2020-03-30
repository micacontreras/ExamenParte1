package com.example.examenparte1

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

fun showDialog(context: Context?, title: String, message: String, positiveButton: String) {
    val builder = AlertDialog.Builder(context!!)
    builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton(positiveButton) { dialog, which ->
        Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show()
    }
    val dialog: AlertDialog = builder.create()
    dialog.show()
}

