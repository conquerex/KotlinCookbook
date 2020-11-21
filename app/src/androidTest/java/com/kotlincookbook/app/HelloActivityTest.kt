package com.kotlincookbook.app

import android.content.Intent
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

    @Rule
    @JvmField
    var intentActivityRule: ActivityTestRule<DownloadActivity> =
            ActivityTestRule(DownloadActivity::class.java, true, false)

    @Test
    fun testIntentLaunch() {
        val intent = Intent()
        intentActivityRule.launchActivity(intent)
        onView(withText("Download")).check(matches(isDisplayed()))
    }

    @Test
    fun testExceptionFlow() {
        thrown.expect(IllegalArgumentException::class.java)
        thrown.expectMessage("나이는 정수여야 합니다.")
        Utility.methodThrowsException()
    }

    @Test
    fun testButton1() {
        // "Sample"라는 텍스트를 가진 뷰가 보여지는 확인
        onView(withText("Sample"))
                .check(matches(isDisplayed()))

        // "Button 1"라는 텍스트를 가진 뷰가 보여지는지 확인
        val button = onView(withText("Button 1"))
                .check(matches(isDisplayed()))

        // 버튼을 클릭한다.
        button.perform(click())

        onView(withText("click Button 1"))
                .check(matches(isDisplayed()))
    }
}

