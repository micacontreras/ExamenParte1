package com.example.examenparte1.invalidcreds


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examenparte1.R
import com.example.examenparte1.showDialog
import kotlinx.android.synthetic.main.fragment_invalid_creds.*

/**
 * A simple [Fragment] subclass.
 */
class InvalidCredsFragment : Fragment() {

    private var safeArgs: InvalidCredsFragmentArgs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!arguments?.isEmpty!!) {
            arguments?.let {
                safeArgs =
                    InvalidCredsFragmentArgs.fromBundle(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_invalid_creds, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDialog(
            context,
            "Rimac seguros",
            "No recuerdo que mas decia",
            "Ok"
        )

        bt_back_to_main.setOnClickListener {
            if (safeArgs != null) {
                findNavController().navigate(
                    InvalidCredsFragmentDirections.navigateToSignon(
                        safeArgs?.DNI
                    )
                )
            }
        }
    }

}
