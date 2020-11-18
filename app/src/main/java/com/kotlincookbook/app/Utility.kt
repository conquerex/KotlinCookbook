package com.kotlincookbook.app

/**
 * Created by jongkook on 2020.11.17
 */

object Utility {
    fun addTwoNumbers(a: Int, b: Int): Int = a + b

    fun functionUnderTest() {
        println("functionUnderTest")
    }

    fun methodThrowsException() {
        throw IllegalArgumentException("나이는 정수여야 합니다.")
    }
}