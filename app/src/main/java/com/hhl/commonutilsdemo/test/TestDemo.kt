package com.hhl.commonutilsdemo.test


/**
 * @author hailinHu
 * @date 2021/3/5 0005
 */

fun main() {
    println("--------welcome in main--------")
//    baseType()
//    arrayType()
    collectionTest()
//    collectionSort()
}

/**
 * 集合排序
 */
fun collectionSort() {
    data class Language(var name: String, var score: Int)

    val mutableList = mutableListOf<Language>()
    mutableList.add(Language("JAVA", 80))
    mutableList.add(Language("Kotlin", 90))
    mutableList.add(Language("Android", 100))
    mutableList.add(Language("C", 80))
    println(mutableList)
    //单条件排序
    mutableList.sortBy { it.score }
    println(mutableList)

    //多条件排序
    mutableList.sortWith(compareBy({ it.score }, { it.name }))
    println(mutableList)

}

fun collectionTest() {
    val list = listOf("A", "B", "A")
    println("list=$list")
    val set = setOf<String>("A", "B", "A")
    println("set=$set")
    val mutableList = mutableListOf<String>("A", "B")
    mutableList.add("C")
    mutableList.add("D")
    mutableList.removeAt(0)
    mutableList[0] = "A"
    println("mutableList=$mutableList")
    val mutableSet = mutableSetOf(1, 2, 3)
    mutableSet.add(4)
    println("mutableSet=$mutableSet")
    //集合支持加减法
    val tempSet = mutableSet + setOf(5, 6, 7)
    println("tempSet=$tempSet")

    val mutableMap = mutableMapOf<String, String>()
    mutableMap["key1"] = "A"
    mutableMap["key2"] = "B"
    mutableMap["key3"] = "C"
    mutableMap["key4"] = "D"
    mutableMap["key5"] = "E"
    println(mutableMap)
    println("values=" + mutableMap.values)
    println("keys=" + mutableMap.keys)
    if (mutableMap.containsKey("key1")) {
        println("mutableMap exist key1")
    }

    if ("A" in mutableMap.values) {
        println("A in mutableMap")
    }


}

fun arrayType() {
    var array = arrayOf(1, 2, 3)
    var array1 = arrayOfNulls<Int>(3)
    array1[0] = 4
    array1[1] = 5
    array1[2] = 6
    var array2 = Array(5) { i ->
        i + 1
    }

    var array3 = intArrayOf(1, 2, 3)

    var array4 = IntArray(5)

    var array5 = IntArray(5) { 2 }

    var array6 = IntArray(5) {
        it + 1
    }

    for ((index, item) in array2.withIndex()) {
        println("index=$index,item=$item")
    }

    for (item in array6) {
        println("array6=$item")
    }

    for (index in array6.indices) {
        println("index=$index")
    }

    array6.forEach { i -> println("i = $i ,") }

    array6.forEachIndexed { index, item ->
        println("index=$index , item=$item")
    }

}

fun baseType() {
    val num1 = 1.22 //Double 类型
    val num2 = 1.1f //浮点类型
    val num3 = 2    //Int类型
    println("num1=$num1,num2=$num2,num3=$num3")

    printType(num1)
    printType(num2)
    printType(num3)
}

fun printType(param: Any) {
    println("$param is ${param::class.simpleName} type")
}
