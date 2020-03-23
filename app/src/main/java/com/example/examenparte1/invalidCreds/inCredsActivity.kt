package com.example.examenparte1.invalidCreds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenparte1.R
import com.example.examenparte1.displayFragment
import com.example.examenparte1.main.MainActivity
import com.example.examenparte1.main.MainFragment

class inCredsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_creds)
        displayFragment(inCredsFragment().javaClass?.name, R.id.fragment_container_inCreds)
    }
}
