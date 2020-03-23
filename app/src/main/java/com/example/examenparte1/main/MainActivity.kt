package com.example.examenparte1.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenparte1.R
import com.example.examenparte1.displayFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayFragment(MainFragment().javaClass?.name, R.id.fragment_container)
    }

}
