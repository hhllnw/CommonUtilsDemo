package com.hhl.commonutilsdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mTextView = findViewById<TextView>(R.id.mTextView)
        var a = "Hello"
        val b = "Kotlin"
        var c: String?
        c = null
        //非空判断获取长度
        val lenght = c?.length

        val firstName = "Hello"
        val secondName = "kotlin"
        val msg = "${firstName}${secondName}"

        //换行
        val line = """
            |FirstLine
            |SecondLine
            |ThirdLine
        """.trimMargin()

        println("line=$line")
        val score = 2;
        val grade = when (score) {
            8, 9 -> "Excellent"
            in 6..8 -> "Good"
            in 0..7 -> "OK"
            else -> "Fail"
        }
        println("grade=$grade")
    }
}