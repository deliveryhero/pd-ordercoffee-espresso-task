package de.deliveryhero.mailordercoffeeshop.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText


object EspressoUtils {

    fun Int.clickElement() {
        onView(withId(this)).perform(click())
    }

    fun String.selectItem() {
        onView(withText(this))
            .inRoot(RootMatchers.isPlatformPopup())
            .perform(click())
    }

    fun String.setRadio() { onView(withText(this)).perform(click())}
}