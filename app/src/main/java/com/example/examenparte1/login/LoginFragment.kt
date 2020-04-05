package com.example.examenparte1.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examenparte1.R
import com.example.examenparte1.showDialog
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private var safeArgs: LoginFragmentArgs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!arguments?.isEmpty!!) {
            arguments?.let {
                safeArgs = LoginFragmentArgs.fromBundle(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onResume() {
        super.onResume()
        checkCreds()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_access_to_invalid_credentials.setOnClickListener {
            val action = LoginFragmentDirections.navigateToReg()
            findNavController().navigate(action)
        }
        bt_abrirApp.setOnClickListener {
            if (!et_docNro.text.isNullOrEmpty()) {
                val dni = et_docNro.text.toString()
                val action = LoginFragmentDirections.navigateToInvalidCredentials(dni)
                findNavController().navigate(action)
            } else {
                showDialog(
                    context,
                    "Campos obligatorios",
                    "Debe completar todos los campos antes de continuar",
                    "Ok"
                )
            }
        }
        checkCreds()
    }

    private fun checkCreds() {
        if (safeArgs != null) {
            et_docNro?.setText(safeArgs?.DNI)
        }
    }
}
