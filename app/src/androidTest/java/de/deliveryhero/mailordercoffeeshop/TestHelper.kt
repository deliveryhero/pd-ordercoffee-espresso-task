package de.deliveryhero.mailordercoffeeshop

import androidx.test.platform.app.InstrumentationRegistry

object TestHelper {

    fun clearPreferences() { InstrumentationRegistry.getInstrumentation().targetContext.deleteSharedPreferences("is_first_launch") }
}