package de.deliveryhero.mailordercoffeeshop.test

import android.os.SystemClock
import de.deliveryhero.mailordercoffeeshop.TestHelper.clearPreferences
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import de.deliveryhero.mailordercoffeeshop.MainActivity
import de.deliveryhero.mailordercoffeeshop.pages.CoffeeShopPage
import de.deliveryhero.mailordercoffeeshop.pages.OnboardingPage
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val MILK_SELECTION = "Low fat"
private const val MILK_PRESENTATION_TYPE = "Steamed"


@RunWith(AndroidJUnit4::class)
class EspressoWorkshopTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(
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
            SystemClock.sleep(10000000)
        }
    }
}