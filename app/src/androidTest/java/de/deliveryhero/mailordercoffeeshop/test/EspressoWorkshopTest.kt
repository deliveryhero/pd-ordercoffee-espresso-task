package de.deliveryhero.mailordercoffeeshop.test

import android.content.Intent
import android.os.SystemClock
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import de.deliveryhero.mailordercoffeeshop.TestHelper.clearPreferences
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import de.deliveryhero.mailordercoffeeshop.MainActivity
import de.deliveryhero.mailordercoffeeshop.pages.CoffeeShopPage
import de.deliveryhero.mailordercoffeeshop.pages.OnboardingPage
import de.deliveryhero.mailordercoffeeshop.pages.ReviewOrderPage
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val MILK_SELECTION = "Low fat"
private const val MILK_PRESENTATION_TYPE = "Steamed"
private const val NAME = "Delivery Hero"
private const val EMAIL = "hero@delivery.de"
private const val ORDER_NAME = "Coffee Love"


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
    fun clearData(){
       clearPreferences()
    }

    @Test
    fun orderCoffee() {
        OnboardingPage().dismissOnBoardingPage()
        with(CoffeeShopPage()) {
            clickPlus()
            clickPlus()
            setChocolate()
            openMilkTypeSelector()
            SystemClock.sleep(5000)
            //TODO, fix sleep
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
        Intents.intended(
            Matchers.allOf(
            IntentMatchers.hasAction(Intent.ACTION_SENDTO),
                IntentMatchers.hasExtra(Intent.EXTRA_SUBJECT,"Order: Delivery Hero - Coffee Love"),
                IntentMatchers.hasExtra(Intent.EXTRA_TEXT,"Ingredients:\n" +
                        "2 shots of espresso\n" +
                        "Chocolate\n" +
                        "Steamed Low fat"),
                IntentMatchers.hasExtra(Intent.EXTRA_EMAIL, mutableListOf("coffeeshop@valori.nl","hero@delivery.de").toTypedArray())
            )
        )
    }
}