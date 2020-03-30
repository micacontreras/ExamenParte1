package com.example.examenparte1.registro


import android.content.Context
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
import com.example.examenparte1.Navigation
import com.example.examenparte1.R
import com.example.examenparte1.invalidCredentials.InvalidCredentialsFragment
import com.example.examenparte1.showDialog
import com.example.examenparte1.singOn.SignOnFragment
import com.example.examenparte1.terms.TermsFragment
import kotlinx.android.synthetic.main.fragment_registro.*


/**
 * A simple [Fragment] subclass.
 */
class RegistroFragment : Fragment() {

    var callback: Navigation? = null

    companion object {
        @JvmStatic
        fun newInstance(datos: Bundle?): RegistroFragment {
            return RegistroFragment().apply {
                arguments = Bundle().also {
                    if (datos != null) {
                        it.putBundle("Datos", datos)
                    }
                }
            }
        }
    }

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
            callback?.navigateToFragment(SignOnFragment.toString(), null)
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
                var datosBundle= Bundle()
                datosBundle.putString("DNI",et_dni.text.toString())
                callback?.navigateToFragment(InvalidCredentialsFragment.toString(), datosBundle)
            }
        })
        goToTerms()
    }

    fun goToTerms() {
        var textToChange = tv_goTerms.text

        if (textToChange.isNotEmpty()) {
            var ss = SpannableString(textToChange)
            var color = ForegroundColorSpan(Color.BLUE)

            val clickableSpan = object : ClickableSpan() {
                override fun onClick(textView: View) {
                    checkBox.isChecked = true
                    callback?.navigateToFragment(TermsFragment.toString(), null)
                }
            }
            ss.setSpan(clickableSpan, 22, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            ss.setSpan(color, 22, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            tv_goTerms.text = ss
            tv_goTerms.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? Navigation
    }
}
