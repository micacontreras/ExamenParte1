package com.example.examenparte1.terms


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.example.examenparte1.R
import com.example.examenparte1.registro.RegistroActivity
import com.example.examenparte1.statusTerms
import kotlinx.android.synthetic.main.fragment_terms.*


/**
 * A simple [Fragment] subclass.
 */
class TermsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_terms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeText()
        cross_terms.setOnClickListener(View.OnClickListener {
            statusTerms = true
            val intent = Intent(activity, RegistroActivity::class.java)
            startActivity(intent)
        })
    }

    @SuppressLint("WrongConstant")
    fun changeText() {
        var text = "<html>\n" +
                "<div><div><p><strong>BSB Mobile Banking Service Agreement</strong></div></p>\n" +
                "\n" +
                "<p><strong>CeB Mobile User Updated on 10-24 END USER TERMS</strong></p>\n" +
                "\n" +
                "<p>This mobile banking service is provided to you by Bridgewater Savings Bank (&quot;BSB&quot;) through the use of a mobile technology solution provided by a third party (the &quot;Licensor&quot;). These End User Terms constitute a legally binding agreement between you and BSB. The Licensor shall be a permitted third party beneficiary of Section B of these End User Terms, and shall be entitled to rely upon and enforce such terms as if it were a party to this agreement.</p>\n" +
                "\n" +
                "<p><strong>SECTION A</strong></p>\n" +
                "\n" +
                "</ol>\n" +
                "\n" +
                "<p><center><strong>For Customer Service:  (800) 356-8622<br>\n" +
                "\n" +
                "www.bridgewatersavings.com</strong><br>\n" +
                "\n" +
                "Member FDIC &middot; Member DIF</center></p>\n" +
                "\n" +
                "</div>"

        val styledText: Spanned = HtmlCompat.fromHtml(text, FROM_HTML_MODE_LEGACY)
        tv_terms.text = styledText
    }


    fun newInstance(): TermsFragment {
        val fragment = TermsFragment()
        return fragment
    }
}
