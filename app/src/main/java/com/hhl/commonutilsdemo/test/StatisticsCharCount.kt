package com.hhl.commonutilsdemo.test

import java.io.File

/**
 * @author hailinHu
 * @date 2021/3/26 0026
 *
 */

fun main() {
    statisticsCharCount()
}

/**
 * 统计字符个数
 */
fun statisticsCharCount() {
    File("build.gradle").readText()
            .toCharArray()
            .filter { !it.isWhitespace() }
            .groupBy { it }
            .map {
                it.key to it.value.size
            }
            .let { println(it) }
}