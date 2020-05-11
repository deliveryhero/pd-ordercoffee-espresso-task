package de.deliveryhero.mailordercoffeeshop.test

import android.content.Intent.ACTION_SENDTO
import android.content.Intent.EXTRA_EMAIL
import android.content.Intent.EXTRA_SUBJECT
import android.content.Intent.EXTRA_TEXT
import android.os.SystemClock
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import de.deliveryhero.mailordercoffeeshop.MainActivity
import de.deliveryhero.mailordercoffeeshop.TestHelper.clearPreferences
import de.deliveryhero.mailordercoffeeshop.pages.CoffeeShopPage
import de.deliveryhero.mailordercoffeeshop.pages.OnboardingPage
import de.deliveryhero.mailordercoffeeshop.pages.ReviewOrderPage
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val MILK_SELECTION = "Low fat"
private const val MILK_PRESENTATION_TYPE = "Steamed"
private const val NAME = "Delivery Hero"
private const val EMAIL = "hero@delivery.de"
private const val ORDER_NAME = "Coffee Love"
private const val EMAIL_SUBJECT = "Order: Delivery Hero - Coffee Love"
private const val EMAIL_BODY = "Ingredients:\n" +
        "2 shots of espresso\n" +
        "Chocolate\n" +
        "Steamed Low fat"
private val EMAIL_ARRAY = mutableListOf("coffeeshop@valori.nl", "hero@delivery.de").toTypedArray()

@RunWith(AndroidJUnit4::class)
class EspressoWorkshopTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = IntentsTestRule<MainActivity>(
        MainActivity::class.java,
        true,
        true
    )


    @Before
    fun clearData() {
        clearPreferences()
    }

    @Test
    fun verifyOrderCoffee() {
        OnboardingPage().dismissOnBoardingPage()
        with(CoffeeShopPage()) {
            clickPlus()
            clickPlus()
            setChocolate()
            openMilkTypeSelector()
            selectMilk(MILK_SELECTION)
            swipeUp()
            setMilkPresentationType(MILK_PRESENTATION_TYPE)
            clickReviewOrder()
        }
        with(ReviewOrderPage()) {
            enterName(NAME)
            enterEmail(EMAIL)
            enterCustomOrderName(ORDER_NAME)
            clickSubmit()
        }
        intended(
            allOf(
                hasAction(ACTION_SENDTO),
                hasExtra(EXTRA_SUBJECT, EMAIL_SUBJECT),
                hasExtra(EXTRA_TEXT, EMAIL_BODY),
                hasExtra(EXTRA_EMAIL, EMAIL_ARRAY)
            )
        )
    }
}