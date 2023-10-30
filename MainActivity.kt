package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val min = findUSJ(8,16)
        val max = findUSG(8,16)
        Log.e("answer", "$min")
        Log.e("answer", "$max")

        val dolar = findDolar("ajd$ afajfna $ jdnsa")
        Log.e("answer", "$dolar")

        Log.e("answer", "${recursive()}")

        Log.e("answer", "${rev(324432)}")

        Log.e("answer", "${palindrome("po3l3op")}")

    }




    private fun findUSJ(num1: Int, num2: Int): Int {
        var max = if (num1 > num2) num1 else num2
        var lcm = max

        while (true) {
            if (lcm % num1 == 0 && lcm %num2 == 0) {
                break
            }
            lcm +=max
        }

        return lcm

    }

    private fun findUSG(num1: Int, num2: Int) : Int {
        var value1 = num1
        var value2 = num2
        while (value2 != 0) {
            val temp = value2
            value2 = value1 % value2
            value1 = temp
        }
        return value1
    }

    private fun findDolar(text: String): Boolean {

        var answer = false
        val value = text.toCharArray()
        value.forEach {
            if (it == '$') {
                answer = true
            }

        }
        return answer
    }

    private var min = 1
    private var max = 100
    private fun recursive(): Int {
        var answer = 0
        while (min < max) {
            if (max % min == 0) {
                answer =+ min
            }
            min++
        }
        return answer
    }

    private fun rev (num: Int) : Int {
        val reversed = num.toString().reversed()
        return reversed.toInt()
    }

    private fun palindrome(word: String): Boolean {
        var answer = false
        val reversed = word.reversed()
        if (reversed == word){
            answer = true
        }
        return answer
    }

}