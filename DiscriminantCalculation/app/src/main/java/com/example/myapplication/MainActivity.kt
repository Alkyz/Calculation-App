package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.math.absoluteValue

class MainActivity() : AppCompatActivity() {

    private var finishedResult: Int = 0
    lateinit var a: EditText
    lateinit var b: EditText
    lateinit var c: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun output(a: Int, b: Int, c: Int): Int {
        finishedResult = (b * b) - (4 * a * c)
        return finishedResult
    }

    fun calculation(view: View) {
        var answer : TextView = findViewById(R.id.answer)
        var answer2 : TextView = findViewById(R.id.answer2)
        a = findViewById(R.id.aInput)
        b = findViewById(R.id.bInput)
        c = findViewById(R.id.cInput)

        try {
            var aNum = a.text.toString().toInt()
            var bNum = b.text.toString().toInt()
            var cNum = c.text.toString().toInt()
            finishedResult = output(aNum, bNum, cNum)
        } catch (ex: NumberFormatException) {

        }
        if (finishedResult < 0) {
            answer.setText("D = " + finishedResult.toString())
            answer2.setText("Since D < 0, there are 0 real solutions")
        } else if (finishedResult == 0) {
            answer.setText("D = " + finishedResult.toString())
            answer2.setText("Since D = 0, there is 1 real solution")
        } else {
            answer.setText("D = " + finishedResult.toString())
            answer2.setText("Since D > 0, there are 2 real solutions")
        }
    }

}