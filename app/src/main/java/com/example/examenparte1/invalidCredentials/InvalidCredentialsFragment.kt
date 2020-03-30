package com.example.examenparte1.invalidCredentials


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examenparte1.Navigation
import com.example.examenparte1.R
import com.example.examenparte1.showDialog
import com.example.examenparte1.singOn.SignOnFragment
import kotlinx.android.synthetic.main.fragment_in_creds.*
import kotlinx.android.synthetic.main.fragment_registro.*

/**
 * A simple [Fragment] subclass.
 */
class InvalidCredentialsFragment : Fragment() {

    var callback: Navigation? = null

    companion object {
        @JvmStatic
        fun newInstance(datos: Bundle?): InvalidCredentialsFragment {
            return InvalidCredentialsFragment().apply {
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
        return inflater.inflate(R.layout.fragment_in_creds, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDialog(context, "Rimac seguros", "No recuerdo que mas decia", "Ok")

        bt_volver.setOnClickListener(View.OnClickListener {
            if (arguments != null) {
                callback?.navigateToFragment(
                    SignOnFragment.toString(),
                    arguments
                )
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? Navigation
    }
}
