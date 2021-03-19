package com.hhl.commonutilsdemo.test

import java.lang.Exception
import java.lang.IllegalArgumentException
import java.util.*

/**
 * @author hailinHu
 * @date 2021/3/18 0018
 */

fun main() {
    test1()
    println("max=${max(1, 2)}")
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    traversal()
    println("isLetter=${isLetter('H')}")
    println("isNotDigit=${isNotDigit('0')}")
    println("'h' -> ${recognize('a')}")
    println("'H' -> ${recognize('H')}")
    println("'6' -> ${recognize('6')}")
    println("'空格' -> ${recognize(' ')}")


    readNumber(StringBuffer("123"))
    readNumber(StringBuffer("It's not digit!"))
}


fun test1() {

    data class Person(val name: String, val age: Int? = null)

    val persions = listOf(Person("Android", 10), Person("Java", 20), Person("Kotlin"))
    val oldest = persions.maxBy { it.age ?: 0 }
    println("oldest=$oldest")
    println("isSquare=${Rectangle(40, 40).isSquare}")


}

/**
 * 获取最大值
 */
fun max(a: Int, b: Int) = if (a > b) a else b

data class Rectangle(val width: Int, val height: Int) {
    /**
     * 自定义访问器
     */
    val isSquare: Boolean
        get() {
            return width == height
        }
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(1, 2, 3), GREEN(4, 5, 6), BLUE(7, 8, 9);

    fun rgb(): Int {
        return (r * 256 + g) * 256 + b
    }
}

fun getColor(color: Color): String {
    return when (color) {
        Color.RED -> {
            "RED"
        }
        Color.GREEN -> "GREEN"
        Color.BLUE -> "BLUE"
    }
}

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.GREEN) -> ""
    setOf(Color.RED, Color.BLUE) -> ""
    else -> throw Exception("Dirty color")
}

fun max1(c1: Color, c2: Color) = when {
    (c1 == Color.RED && c2 == Color.GREEN) || (c1 == Color.GREEN && c2 == Color.RED) -> ""
    (c1 == Color.RED && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.RED) -> ""
    else -> throw Exception("Dirty color")
}

interface Expr
data class Num(val value: Int) : Expr
data class Sum(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr): Int {
    return when (expr) {
        is Num -> {
            println("num:${expr.value}")
            expr.value
        }
        is Sum -> {
            val left = eval(expr.left)
            val right = eval(expr.right)
            println("sum:${left + right}")
            left + right
        }
        else -> {
            throw IllegalArgumentException("Unknown expression")
        }
    }
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun traversal() {
    for (i in 100 downTo 1 step 1) {
        print(fizzBuzz(i) + " ")
    }
    println()
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter=$binary")
    }

    val list = arrayListOf(10, 20, 30, 40, 50)
    for ((index, element) in list.withIndex()) {
        println("index=$index,element=$element")
    }
}

/**
 * 是否是字母
 */
fun isLetter(c: Char): Boolean = c in 'A'..'Z' || c in 'a'..'z'

/**
 * 是否不是数字
 */
fun isNotDigit(c: Char): Boolean = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a Digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a Letter!"
    else -> "I don't know..."
}

fun readNumber(reader: StringBuffer) {
    val number = try {
        val line = reader.toString()
        Integer.parseInt(line)
    } catch (e: Exception) {
        null
    }
    println("number=$number")
}



















































