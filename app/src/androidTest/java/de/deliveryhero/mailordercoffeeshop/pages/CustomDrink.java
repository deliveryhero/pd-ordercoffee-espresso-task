package de.deliveryhero.mailordercoffeeshop.pages;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import de.deliveryhero.mailordercoffeeshop.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static org.hamcrest.core.AllOf.allOf;

public class CustomDrink {
    public static final ViewInteraction nameEditText = onView(
            allOf(ViewMatchers.withId(R.id.name_text_box)));

    public static final ViewInteraction emailEditText = onView(
            allOf(ViewMatchers.withId(R.id.email_text_box)));

    public static final ViewInteraction customOrderEditText = onView(
            allOf(ViewMatchers.withId(R.id.custom_order_name_box)));

    public static final ViewInteraction mailOrderButton = onView(
            allOf(ViewMatchers.withId(R.id.mail_order_button)));

    public static void typeUsername(String username) {
        nameEditText.perform(replaceText(username), closeSoftKeyboard());
    }

    public static void typeEmail(String email) {
        emailEditText.perform(replaceText(email), closeSoftKeyboard());
    }

    public static void typeCustomOrder(String customOrder) {
        customOrderEditText.perform(replaceText(customOrder), closeSoftKeyboard());
    }

    public static void clickOnMailOrderButton() {
        mailOrderButton.perform(scrollTo(), click());
    }
}
