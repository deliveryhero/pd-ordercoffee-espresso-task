package de.deliveryhero.mailordercoffeeshop.pages

import de.deliveryhero.mailordercoffeeshop.R
import de.deliveryhero.mailordercoffeeshop.espresso.EspressoUtils.clickElement
import de.deliveryhero.mailordercoffeeshop.espresso.EspressoUtils.selectItem
import de.deliveryhero.mailordercoffeeshop.espresso.EspressoUtils.setRadio
import de.deliveryhero.mailordercoffeeshop.espresso.EspressoUtils.swipeUp

class CoffeeShopPage {

    fun clickPlus() {
        R.id.more_espresso.clickElement()
    }

    fun setChocolate() {
        R.id.chocolate.clickElement()
    }

    fun openMilkTypeSelector() {
        R.id.milk_type.clickElement()
    }

    fun selectMilk(milkType: String) {
        milkType.selectItem()
    }

    fun setMilkPresentationType(milkMix: String) {
        milkMix.setRadio()
    }

    fun clickReviewOrder() {
        R.id.review_order_button.clickElement()
    }

    fun swipeUp() {
        R.id.custom_order_scrollview.swipeUp()
    }
}