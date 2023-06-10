package com.example.randomizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var textNum: TextView
    lateinit var minNum: EditText
    lateinit var maxNum: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.gen_button)
        textNum = findViewById(R.id.number)
        minNum = findViewById(R.id.min_input)
        maxNum = findViewById(R.id.max_input)
        button.setOnClickListener{
            generate()
        }
    }

    private fun generate() {

        if (minNum.text.isNotEmpty() && maxNum.text.isNotEmpty()){
            val minText = minNum.text.toString().toInt()
            val maxText = maxNum.text.toString().toInt()
            if (maxText > minText) {
                val randInt = Random.nextInt(minText, maxText+1)
                textNum.text = randInt.toString()
            }
            else {
                Toast.makeText(this, "The max value should be greater than the min value", Toast.LENGTH_LONG).show()
            }
        }
        else textNum.text = "0"

    }

}