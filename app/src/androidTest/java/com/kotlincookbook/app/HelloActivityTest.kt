package com.kotlincookbook.app

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.action.ViewActions.click
import org.junit.rules.ExpectedException

/**
 * Created by jongkook on 2020.11.17
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class HelloActivityTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(HelloActivity::class.java)

    @Rule
    @JvmField
    var thrown = ExpectedException.none()

    @Test
    fun testExceptionFlow() {
        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("나이는 정수여야 합니다.")
        Utility.methodThrowsException()
    }

    @Test
    fun testButton1() {
        val button = onView(withText("Button 1"))
                .check(matches(isDisplayed()))

        button.perform(click())

        val textView = onView(withText("click Button 1"))
                .check(matches(isDisplayed()))

        textView.check(matches(withText("click Button 1")))
    }
}

