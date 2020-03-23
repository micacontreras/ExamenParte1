package com.example.examenparte1.main


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examenparte1.R
import com.example.examenparte1.documento
import com.example.examenparte1.invalidCreds.inCredsActivity
import com.example.examenparte1.registro.RegistroActivity
import com.example.examenparte1.showDialog
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

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
            val intent = Intent(activity, RegistroActivity::class.java)
            startActivity(intent)
        })
        bt_abrirApp.setOnClickListener(View.OnClickListener {
            if (!et_docNro.text.isNullOrEmpty()) {
                val intent = Intent(activity, inCredsActivity::class.java)
                startActivity(intent)
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
        if (documento != 0) {
            et_docNro?.setText(documento.toString())
        }
    }


    fun newInstance(): MainFragment {
        val fragment = MainFragment()
        return fragment
    }

}
