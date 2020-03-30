package com.example.examenparte1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenparte1.invalidCredentials.InvalidCredentialsFragment
import com.example.examenparte1.registro.RegistroFragment
import com.example.examenparte1.singOn.SignOnFragment
import com.example.examenparte1.terms.TermsFragment


class MainActivity : AppCompatActivity(), Navigation {

    lateinit var fragMain: SignOnFragment
    lateinit var fragRegistro: RegistroFragment
    lateinit var fragTerms: TermsFragment
    lateinit var fragInCreds: InvalidCredentialsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayMainFragment()
    }

    private fun displayMainFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, SignOnFragment.newInstance(null), "SignOn")
            .addToBackStack("SignOn").commit()
    }

    override fun navigateToFragment(destiny: String, info: Bundle?) {
        when {
            destiny.equals(SignOnFragment.toString()) -> {
                val fragment = supportFragmentManager.findFragmentByTag("SignOn")
                if (fragment == null) {
                    fragMain = SignOnFragment.newInstance(info)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragMain, "SignOn")
                        .addToBackStack("SignOn")
                        .commitAllowingStateLoss()
                } else {
                    fragment.setArguments(info)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment, "SignOn")
                        .commitAllowingStateLoss()
                }
            }

            destiny.equals(RegistroFragment.toString()) -> {
                val fragment = supportFragmentManager.findFragmentByTag("Registro")
                if (fragment == null ) {
                        fragRegistro = RegistroFragment.newInstance(info)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragRegistro, "Registro")
                            .addToBackStack("Registro")
                            .commitAllowingStateLoss()
                } else {
                    fragment.setArguments(info)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment, "Registro")
                        .commitAllowingStateLoss()
                }

            }

            destiny.equals(TermsFragment.toString()) -> {
                val fragment = supportFragmentManager.findFragmentByTag("Terms")
                if (fragment == null) {
                        fragTerms = TermsFragment.newInstance(info)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragTerms, "Terms")
                            .addToBackStack("Terms")
                            .commitAllowingStateLoss()
                } else {
                    fragment.setArguments(info)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment, "Terms")
                        .commitAllowingStateLoss()
                }
            }

            destiny.equals(InvalidCredentialsFragment.toString()) -> {
                val fragment = supportFragmentManager.findFragmentByTag("InvalidCreds")
                if (fragment == null) {
                        fragInCreds = InvalidCredentialsFragment.newInstance(info)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragInCreds, "InvalidCreds")
                            .addToBackStack("InvalidCreds").commitAllowingStateLoss()
                } else {
                    fragment.setArguments(info)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment, "InvalidCreds")
                        .commitAllowingStateLoss()
                }
            }
        }
    }
}
