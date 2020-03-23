package com.example.examenparte1

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


fun AppCompatActivity.displayFragment(fragmentDestiny: String, idLayout: Int) {
    var fragInstance = Class.forName(fragmentDestiny).newInstance() as Fragment
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.add(idLayout, fragInstance).commit()
}

var statusTerms: Boolean = false

var documento = 0
var email = ""
var telefono = 0

fun saveUser(doc: Int, emai: String, tel: Int) {
    documento = doc
    email = emai
    telefono = tel
}


fun showDialog(context: Context?, title: String, message: String, positiveButton: String) {
    val builder = AlertDialog.Builder(context!!)
    builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton("Ok") { dialog, which ->
    }
    val dialog: AlertDialog = builder.create()
    dialog.show()
}

