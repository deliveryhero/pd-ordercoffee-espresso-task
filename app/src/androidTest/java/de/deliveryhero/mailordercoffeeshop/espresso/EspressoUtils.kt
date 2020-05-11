package de.deliveryhero.mailordercoffeeshop.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

object EspressoUtils {

    fun Int.clickElement() { Espresso.onView(ViewMatchers.withId(this)).perform(ViewActions.click()) }
}