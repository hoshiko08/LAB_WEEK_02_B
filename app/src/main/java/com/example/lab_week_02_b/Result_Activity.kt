package com.example.lab_week_02_b

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColorInt


class ResultActivity : AppCompatActivity() {

    companion object {
        const val COLOR_KEY = "COLOR_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Load the layout
        setContentView(R.layout.activity_result)

        // 2. Fetch views by ID from that layout
        val backgroundScreen = findViewById<ConstraintLayout>(R.id.background_screen)
        val resultMessage = findViewById<TextView>(R.id.color_code_result_message)

        // 3. Get the colorCode passed from MainActivity
        val colorCode = intent.getStringExtra(COLOR_KEY)

        // 4. Use them
        if (!colorCode.isNullOrEmpty()) {
            backgroundScreen.setBackgroundColor("#$colorCode".toColorInt())
            resultMessage.text = getString(
                R.string.color_code_result_message,
                colorCode.uppercase()
            )
        }
    }
}