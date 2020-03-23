package com.example.examenparte1.registro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenparte1.R
import com.example.examenparte1.displayFragment
import com.example.examenparte1.main.MainActivity
import com.example.examenparte1.main.MainFragment


class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        displayFragment(RegistroFragment().javaClass?.name,R.id.fragment_container_registro)
    }

}
