package com.example.examenparte1.registry


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
import androidx.navigation.fragment.findNavController
import com.example.examenparte1.R
import com.example.examenparte1.showDialog
import kotlinx.android.synthetic.main.fragment_registry.*


/**
 * A simple [Fragment] subclass.
 */
class RegistryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_registry, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cross.setOnClickListener {
            findNavController().navigateUp()
        }

        btn_accept.setOnClickListener {
            if (et_dni.text.isNullOrEmpty() || et_email.text.isNullOrEmpty() || et_phone.text.isNullOrEmpty()) {
                showDialog(
                    context,
                    "Campos obligatorios",
                    "Debe completar todos los campos antes de continuar",
                    "Ok"
                )
            } else {
                val dni = et_dni.text.toString()
                val action = RegistryFragmentDirections.navigateToInvalidCredentials(dni)
                findNavController().navigate(action)
            }
        }
        goToTerms()
    }

    private fun goToTerms() {
        val textToChange = tv_goTerms.text

        if (textToChange.isNotEmpty()) {
            val ss = SpannableString(textToChange)
            val color = ForegroundColorSpan(Color.BLUE)

            val clickableSpan = object : ClickableSpan() {
                override fun onClick(textView: View) {
                    checkBox.isChecked = true
                    findNavController().navigate(RegistryFragmentDirections.navigateToTerms())
                }
            }
            ss.setSpan(clickableSpan, 22, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            ss.setSpan(color, 22, 44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            tv_goTerms.text = ss
            tv_goTerms.movementMethod = LinkMovementMethod.getInstance()
        }
    }
}
