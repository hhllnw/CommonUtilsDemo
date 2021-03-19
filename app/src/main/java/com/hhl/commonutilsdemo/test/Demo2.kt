package com.hhl.commonutilsdemo.test

/**
 * @author hailinHu
 * @date 2021/3/19 0019
 */

fun main() {
//    test()
    calculation("3", "*", "4")
}

fun test() {
    val pair = Pair("key1", "value1")
    val map = hashMapOf(pair)
    println("pair=${map["key1"]}")
    val (x, y) = pair
    val triple = Triple("key2", 1, 2)
}

fun calculation(vararg args: String) {
    if (args.size < 3) {
        tips()
        return
    }
    val map = mapOf(Pair("+", ::add), Pair("-", ::reduce), Pair("*", ::multiply), Pair("/", ::div))
    val op = args[1]
    val opFunction = map[op] ?: return tips()
    try {
        val result = opFunction(args[0].toInt(), args[2].toInt())
        println("${args[0]} ${args[1]} ${args[2]} = $result")
    } catch (e: Exception) {
        tips()
    }
}

fun add(param1: Int, param2: Int): Int {
    return param1 + param2
}

fun reduce(param1: Int, param2: Int): Int {
    return param1 - param2
}

fun multiply(param1: Int, param2: Int): Int {
    return param1 * param2
}

fun div(param1: Int, param2: Int): Int {
    return param1 / param2
}

fun tips() {
    println("""
        
        Simple Calculation:
             输入 ： 3 * 4
             输出 ：12
    """.trimIndent())
}
