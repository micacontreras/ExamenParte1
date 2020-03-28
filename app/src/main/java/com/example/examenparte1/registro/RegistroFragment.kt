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
import com.example.examenparte1.invalidCreds.inCredsFragment
import com.example.examenparte1.main.MainFragment
import com.example.examenparte1.showDialog
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
            callback?.navigateToFragment(MainFragment.toString(), null )
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
                val datos= registerUser()
                callback?.navigateToFragment(inCredsFragment.toString(), datos)
            }
        })
        goToTerms()
        seeCreds()
    }


    private fun seeCreds() {
        if (arguments?.getBundle("Datos") != null) {
            et_dni?.setText(arguments!!.getBundle("Datos")!!.getInt("DNI").toString())
            et_email?.setText(arguments!!.getBundle("Datos")!!.getString("EMAIL"))
            et_telefono?.setText(arguments!!.getBundle("Datos")!!.getInt("TELEFONO").toString())
            if(arguments!!.getBundle("Datos")!!.getBoolean("TERMS")){
                checkBox.isChecked= true
            }
        }
    }

    fun goToTerms() {
        var textToChange = tv_goTerms.text

        if (textToChange.isNotEmpty()) {
            var ss = SpannableString(textToChange)
            var color = ForegroundColorSpan(Color.BLUE)

            val clickableSpan = object : ClickableSpan() {
                override fun onClick(textView: View) {
                    var bundleDatos= registerUser()
                    callback?.navigateToFragment(TermsFragment.toString(), bundleDatos)
                }
            }
            ss.setSpan(clickableSpan, 22, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            ss.setSpan(color, 22, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            tv_goTerms.text = ss
            tv_goTerms.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    fun registerUser():Bundle? {
        if (!et_dni.text.isNullOrEmpty() || !et_email.text.isNullOrEmpty() || !et_telefono.text.isNullOrEmpty()) {
            val arguments = Bundle()
            arguments.putInt("DNI", et_dni.text.toString().toInt())
            arguments.putString("EMAIL", et_email.text.toString())
            arguments.putInt("TELEFONO", et_telefono.text.toString().toInt())
            arguments.putBoolean("TERMS", checkBox.isChecked)
            return arguments
        }
        else{
            return null
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? Navigation
    }

    override fun onDetach() {
        callback = null
        super.onDetach()
    }

}
