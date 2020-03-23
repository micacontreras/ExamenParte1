package com.example.examenparte1.terms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenparte1.R
import com.example.examenparte1.displayFragment
import com.example.examenparte1.registro.RegistroActivity
import com.example.examenparte1.registro.RegistroFragment

class TermsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)
        displayFragment(TermsFragment().javaClass?.name,R.id.fragment_container_terms)
    }


}
