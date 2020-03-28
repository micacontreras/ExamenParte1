package com.example.examenparte1.invalidCreds


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.examenparte1.Navigation
import com.example.examenparte1.R
import com.example.examenparte1.main.MainFragment
import com.example.examenparte1.showDialog
import kotlinx.android.synthetic.main.fragment_in_creds.*

/**
 * A simple [Fragment] subclass.
 */
class inCredsFragment : Fragment() {

    var callback: Navigation? = null

    companion object {
        @JvmStatic
        fun newInstance(datos: Bundle?): inCredsFragment {
            return inCredsFragment().apply {
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
            if(arguments!!.getBundle("Datos") !=null){
                Toast.makeText(context, "Funciona?", Toast.LENGTH_SHORT).show()
                callback?.navigateToFragment(MainFragment.toString(), arguments!!.getBundle("Datos"))
            }
        })
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
