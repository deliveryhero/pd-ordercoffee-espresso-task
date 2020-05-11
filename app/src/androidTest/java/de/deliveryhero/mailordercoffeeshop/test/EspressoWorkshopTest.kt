package de.deliveryhero.mailordercoffeeshop.test

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import de.deliveryhero.mailordercoffeeshop.MainActivity
import de.deliveryhero.mailordercoffeeshop.pages.CoffeeShopPage
import de.deliveryhero.mailordercoffeeshop.pages.OnboardingPage
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


    @Test
    fun orderCoffee() {
        OnboardingPage().dismissOnBoardingPage()
        with(CoffeeShopPage()) {
            clickPlus()
            clickPlus()
            setChocolate()
            selectMilk(MILK_SELECTION)
            setMilkPresentationType(MILK_PRESENTATION_TYPE)
            clickReviewOrder()
        }
    }
}