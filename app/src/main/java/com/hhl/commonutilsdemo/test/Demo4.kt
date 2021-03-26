package com.hhl.commonutilsdemo.test

/**
 * @author hailinHu
 * @date 2021/3/24 0024
 */
fun main() {
//    func()
//    val value = "HelloWorld".div("or")
//    println("value=$value")
    fun5.invoke()
}

operator fun String.div(right: Any?): Int {
    val text = right.toString()
    return this.windowed(text.length, 1) {
        it == right
    }.count { it }
}

class Person1(var name: String, var age: Int) {

    override fun equals(other: Any?): Boolean {
        val other = other as? Person1 ?: return false
        return other.name == name && other.age == age
    }

    override fun hashCode(): Int {
        return age + name.hashCode()
    }

}


val func: () -> Unit = {
    val hashSet = HashSet<Person1>()
    (0..5).forEach {
        hashSet += Person1("Kotlin", 20)
    }
    val person1 = Person1("Kotlin", 20)
    hashSet += person1
    println("hasSet size is " + hashSet.size)
    person1.name = "JAVA"

    hashSet -= person1

    println("hasSet size is " + hashSet.size)
}

val func1 = {
    "Hello Kotlin!"
}

val func2 = fun(it: Int) {
    println(it)
}

val func3: Function1<Int, Unit> = {
    println()
}

val fun4 = { p: Int ->
    println(p)
}

val fun5 = {
    val list = listOf(1, 2, 3, 4)
    list.asSequence()
            .filter {
                println("filter it=$it")
                it % 2 == 0
            }.map {
                println("map it=$it")
                it * 2 + 1
            }.forEach {
                println("forEach it=$it")
            }
    println("*************************************")
    list.forEach {
        if (it % 2 == 0) {
            return@forEach
        }
        println("it=$it")
    }
    println("*************************************")
    list.flatMap {
        0 until it
    }.forEach {
        println("flatMap it is $it")
    }

    println("*************************************")

    list.fold(StringBuffer()) { acc, i ->
        acc.append(i)
    }.let { println("R=${it}") }

}
























