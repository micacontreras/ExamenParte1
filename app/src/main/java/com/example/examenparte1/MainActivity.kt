package com.example.examenparte1

import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.examenparte1.invalidCreds.inCredsFragment
import com.example.examenparte1.main.MainFragment
import com.example.examenparte1.registro.RegistroFragment
import com.example.examenparte1.terms.TermsFragment



class MainActivity : AppCompatActivity(), Navigation {

    lateinit var fragMain: MainFragment
    lateinit var fragRegistro: RegistroFragment
    lateinit var fragTerms: TermsFragment
    lateinit var fragInCreds: inCredsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayMainFragment()
    }

    private fun displayMainFragment() {
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MainFragment.newInstance(null)).commit()
    }

    override fun navigateToFragment(destiny: String, datos: Bundle? ) {
        when{
            destiny.equals(MainFragment.toString()) -> {
                fragMain = MainFragment.newInstance(datos)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragMain).commitAllowingStateLoss()
            }
            destiny.equals(RegistroFragment.toString()) -> {
                fragRegistro = RegistroFragment.newInstance(datos)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragRegistro).commitAllowingStateLoss()
            }
            destiny.equals(TermsFragment.toString()) -> {
                fragTerms = TermsFragment.newInstance(datos)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragTerms).commitAllowingStateLoss()
            }
            destiny.equals(inCredsFragment.toString()) -> {
                fragInCreds = inCredsFragment.newInstance(datos)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragInCreds).commitAllowingStateLoss()
            }
        }
    }
}
