package com.kotlincookbook.app

import android.content.SharedPreferences
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*

/**
 * Created by jongkook on 2020.11.17
 */
class UtilityTest {
    @Test
    fun addTwoNumbers() {
        assertEquals(5, Utility.addTwoNumbers(2, 3))
        assertEquals(5, Utility.addTwoNumbers(-1, 6))
    }

    @Test
    fun test_functionUnderTest() {
        /**
         * 코틀린에서 모든 클래스가 기본적으로 final
         * 개선 방법 : open class로 만들거나 아래 방법
         * > org.mockito.plugins.MockMaker
         */
        val classUnderTest = mock(Utility::class.java)
        classUnderTest.functionUnderTest()
        verify(classUnderTest).functionUnderTest() // 메소드가 호출 되었는지
    }

    @Test
    fun testSharedPreference() {
        val sharedPreference = mock(SharedPreferences::class.java)
        `when`(sharedPreference.getInt("random_int", -1))
                .thenReturn(1)
                .thenReturn(123)
        assertEquals(sharedPreference.getInt("random_int", -1), 1)
        assertEquals(sharedPreference.getInt("random_int", -1), 123)
    }
}