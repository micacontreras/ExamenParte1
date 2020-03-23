package com.example.examenparte1.invalidCreds


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examenparte1.R
import com.example.examenparte1.main.MainActivity
import com.example.examenparte1.showDialog
import kotlinx.android.synthetic.main.fragment_in_creds.*

/**
 * A simple [Fragment] subclass.
 */
class inCredsFragment : Fragment() {

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
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        })
    }

}
