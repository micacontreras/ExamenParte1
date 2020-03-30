package com.example.examenparte1.singOn

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examenparte1.Navigation
import com.example.examenparte1.R
import com.example.examenparte1.invalidCredentials.InvalidCredentialsFragment
import com.example.examenparte1.registro.RegistroFragment
import com.example.examenparte1.showDialog
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class SignOnFragment : Fragment() {

    var callback: Navigation? = null

    companion object {
        @JvmStatic
        fun newInstance(datos: Bundle?): SignOnFragment {
            return SignOnFragment().apply {
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
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_ingresar.setOnClickListener(View.OnClickListener {
            callback?.navigateToFragment(RegistroFragment.toString(), null)
        })
        bt_abrirApp.setOnClickListener(View.OnClickListener {
            if (!et_docNro.text.isNullOrEmpty()) {
                if (arguments!!.getBundle("Datos") != null) {
                    if (!et_docNro.text.toString().equals(
                            arguments!!.getBundle("Datos")!!.getString(
                                "DNI"
                            )
                        )
                    ) {
                        var nuevoDNI = Bundle()
                        nuevoDNI.putString("DNI", et_docNro.text.toString())
                        callback?.navigateToFragment(
                            InvalidCredentialsFragment.toString(),
                            nuevoDNI
                        )
                    }
                    else{
                        callback?.navigateToFragment(InvalidCredentialsFragment.toString(), arguments!!.getBundle("Datos"))
                    }
                } else {
                    var nuevoDNI = Bundle()
                    nuevoDNI.putString("DNI", et_docNro.text.toString())
                    callback?.navigateToFragment(InvalidCredentialsFragment.toString(), nuevoDNI)
                }

            } else {
                showDialog(
                    context,
                    "Campos obligatorios",
                    "Debe completar todos los campos antes de continuar",
                    "Ok"
                )
            }
        })
        checkCreds()
    }

    fun checkCreds() {
        if (arguments!!.getBundle("Datos") != null) {
            et_docNro?.setText(arguments!!.getBundle("Datos")!!.getString("DNI"))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? Navigation
    }

}
