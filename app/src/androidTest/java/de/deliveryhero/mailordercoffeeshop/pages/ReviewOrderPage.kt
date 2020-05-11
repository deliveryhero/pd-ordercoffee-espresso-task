package de.deliveryhero.mailordercoffeeshop.pages

import de.deliveryhero.mailordercoffeeshop.R
import de.deliveryhero.mailordercoffeeshop.espresso.EspressoUtils.clickElement
import de.deliveryhero.mailordercoffeeshop.espresso.EspressoUtils.typeText

class ReviewOrderPage {

    fun enterName(name: String) {
        R.id.name_text_box.typeText(name)
    }

    fun enterEmail(email: String) {
        R.id.email_text_box.typeText(email)
    }

    fun enterCustomOrderName(orderName: String) {
        R.id.custom_order_name_box.typeText(orderName)
    }

    fun clickSubmit() {
        R.id.mail_order_button.clickElement()
    }
}