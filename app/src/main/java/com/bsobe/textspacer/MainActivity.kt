package com.bsobe.textspacer

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bsobe.spacer.Spacer
import com.bsobe.spacer.Spacer.Companion.SPACE_DIVIDER as SPACE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewCreditCardNumber = findViewById<TextView>(R.id.textViewCreditCardNumber)
        Spacer.Builder()
            .setPatternSequentially(4)
            .attach(textViewCreditCardNumber)

        val textViewPhoneNumber = findViewById<TextView>(R.id.textViewPhoneNumber)
        Spacer.Builder()
            //.setPattern("#-s###-s###-s##-s##")
            //.setPattern("#${Spacer.SPACE_DIVIDER}###${Spacer.SPACE_DIVIDER}###${Spacer.SPACE_DIVIDER}##${Spacer.SPACE_DIVIDER}##${Spacer.SPACE_DIVIDER}")
            .setPattern("#${SPACE}###${SPACE}###${SPACE}##${SPACE}##${SPACE}")
            // - same result with kotlin import as
            .attach(textViewPhoneNumber)
    }
}
