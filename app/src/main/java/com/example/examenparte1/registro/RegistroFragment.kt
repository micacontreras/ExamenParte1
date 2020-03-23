package com.example.examenparte1.registro


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examenparte1.*
import com.example.examenparte1.invalidCreds.inCredsActivity
import com.example.examenparte1.main.MainActivity
import com.example.examenparte1.terms.TermsActivity
import kotlinx.android.synthetic.main.fragment_registro.*


/**
 * A simple [Fragment] subclass.
 */
class RegistroFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cross.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        })
        btn_aceptar.setOnClickListener(View.OnClickListener {
            if (et_dni.text.isNullOrEmpty() || et_email.text.isNullOrEmpty() || et_telefono.text.isNullOrEmpty()) {
                showDialog(
                    context,
                    "Campos obligatorios",
                    "Debe completar todos los campos antes de continuar",
                    "Ok"
                )
            } else {
                registerUser()
                val intent = Intent(activity, inCredsActivity::class.java)
                startActivity(intent)
            }
        })
        checkStatusTerms()
        goToTerms()
        seeCreds()
    }


    private fun seeCreds() {
        if (documento != 0) {
            et_dni?.setText(documento.toString())
        }
        if (!email.isNullOrEmpty()) {
            et_email?.setText(email)
        }
        if (telefono != 0) {
            et_telefono?.setText(telefono.toString())
        }
    }


    private fun checkStatusTerms() {
        if (statusTerms) {
            checkBox.isChecked = true
        }
    }

    fun goToTerms() {
        var textToChange = tv_goTerms.text

        if (textToChange.isNotEmpty()) {
            var ss = SpannableString(textToChange)
            var color = ForegroundColorSpan(Color.BLUE)

            val clickableSpan = object : ClickableSpan() {
                override fun onClick(textView: View) {
                    registerUser()
                    startActivity(Intent(activity, TermsActivity::class.java))
                }
            }
            ss.setSpan(clickableSpan, 22, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            ss.setSpan(color, 22, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            tv_goTerms.text = ss
            tv_goTerms.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    fun registerUser() {
        if (!et_dni.text.isNullOrEmpty() || !et_email.text.isNullOrEmpty() || !et_telefono.text.isNullOrEmpty()) {
            saveUser(
                et_dni.text.toString().toInt(),
                et_email.text.toString(),
                et_telefono.text.toString().toInt()
            )
            if (!checkBox.isChecked) {
                btn_aceptar.isEnabled = false
            }
        }

    }
}
