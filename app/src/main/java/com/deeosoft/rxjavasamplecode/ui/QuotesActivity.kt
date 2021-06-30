package com.deeosoft.rxjavasamplecode.ui

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.deeosoft.rxjavasamplecode.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class QuotesActivity: AppCompatActivity() {
    private lateinit var quoteLayout: LinearLayout
    private lateinit var quoteFAB: FloatingActionButton
    private lateinit var submitQuote: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteLayout = findViewById(R.id.quote_layout)
        quoteFAB = findViewById(R.id.fab_add_new_quote)
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
            }
        }
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