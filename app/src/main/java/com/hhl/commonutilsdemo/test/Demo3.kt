package com.hhl.commonutilsdemo.test


/**
 * @author hailinHu
 * @date 2021/3/23 0023
 * 类、接口、属性、扩展方法、空类型安全
 */


fun main() {

    val person = Person("kotlin", 5)
    val age = person::age
    println("name:${person.name},${age.get()}")
    println("is phone ${"1529503391".isPhone()}")
    person.name = null
    val length = person.name?.length ?: 0
    println("length is $length")

}


interface Callback {
    /**
     * item单击事件
     */
    fun onItemClick(position: Int)
}

abstract class Parent {
    open fun click() {

    }
}

fun String.isPhone(): Boolean {
    return this.length == 11
}

class Person : Parent, Callback {

    var name: String? = ""
    var age: Int = 0


    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    constructor() : super() {

    }


    override fun click() {
        super.click()
        println("click")
    }

    override fun onItemClick(position: Int) {

    }

}