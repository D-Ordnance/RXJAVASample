package com.deeosoft.rxjavasamplecode.ui

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.deeosoft.rxjavasamplecode.R
import com.deeosoft.rxjavasamplecode.domain.entities.Quote
import com.deeosoft.rxjavasamplecode.presenters.quotepresenter.QuotePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.StringBuilder

class QuotesActivity: AppCompatActivity() {
    private lateinit var quoteLayout: LinearLayout
    private lateinit var quoteFAB: FloatingActionButton
    private lateinit var submitQuote: Button
    private lateinit var quoteList: TextView
    private lateinit var quoteText: TextInputEditText
    private lateinit var quoteAuthor: TextInputEditText

    val quotePresenter: QuotePresenter by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUI()

    }

    private fun initializeUI(){
        quoteLayout = findViewById(R.id.quote_layout)
        quoteFAB = findViewById(R.id.fab_add_new_quote)
        quoteList = findViewById(R.id.quote_list)
        quoteText = findViewById(R.id.quote)
        quoteAuthor = findViewById(R.id.quote_author)
        quoteFAB.setOnClickListener{
            if (quoteLayout.visibility == VISIBLE){
                quoteLayout.visibility = GONE
                it.visibility = VISIBLE
            }else{
                quoteLayout.visibility = VISIBLE
                it.visibility = GONE
            }
        }
        submitQuote = findViewById(R.id.submit_quote)
        submitQuote.setOnClickListener {
            if(quoteLayout.visibility == VISIBLE){
                quoteFAB.visibility = VISIBLE
                quoteLayout.visibility = GONE

                val quote = Quote(null, quoteText.text.toString(), quoteAuthor.text.toString())
                quotePresenter.insert(quote)
                quoteText.setText("")
                quoteAuthor.setText("")
            }
        }

        quotePresenter.getAllQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()

            for(quote in quotes){
                stringBuilder.append("$quote\n\n")
            }
            quoteList.text = stringBuilder.toString()
        })


    }

    override fun onBackPressed() {
        if(quoteLayout.visibility == VISIBLE){
            quoteFAB.visibility = VISIBLE
            quoteLayout.visibility = GONE
        }else{
            super.onBackPressed()
        }
    }
}