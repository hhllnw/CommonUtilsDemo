package com.hhl.commonutilsdemo.test

/**
 * @author hailinHu
 * @date 2021/3/12 0012
 */

fun main() {
    println("max1=${Function().max1(101)}")
    Function.test1()
    marge(arrayOf("1"))
    val value = Util.double(2)
    println("value=$value")
    println("random=${random()}")
    val arrays = arrayListOf(1, 2, 3, 4, 5)
    arrays.forEach { println(it) }
    arrays.filter { it < 5 }
    arrays.forEachIndexed { index, _ ->
        println("index=$index")
    }

    val map = mutableMapOf("key1" to 1, "key2" to 2)
    map.forEach { (_, value) -> println("$value") }
}

fun marge(vararg arrays: Array<String>, value: Int = 0, size: Int = arrays.size) {

}

class Function {
    fun max1(value: Int = 0): Int {
        return value.coerceAtLeast(100)
    }

    companion object {
        fun test1() {

        }
    }
}

object Util {
    fun double(value: Int): Int {
        return value * 2;
    }
}

fun random(): Int {
    fun foo(value: Int): Int {
        return value * value
    }

    val v = (0..100).random()
    return foo(v)
}

val a = {

}

fun test2(value1: Int, value2: Int) {
    value1 + value2
}

val test3: (Int, Int) -> Int = { a, b -> a + b }
val test4 = { a: Int, b: Int -> { a + b } }


