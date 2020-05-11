package de.deliveryhero.mailordercoffeeshop.pages

import de.deliveryhero.mailordercoffeeshop.R
import de.deliveryhero.mailordercoffeeshop.espresso.EspressoUtils.clickElement

class OnboardingPage {


    fun dismissOnBoardingPage() {
        R.id.close_button.clickElement()
    }
}