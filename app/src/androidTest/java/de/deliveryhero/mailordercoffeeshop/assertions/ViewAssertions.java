package de.deliveryhero.mailordercoffeeshop.assertions;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

public class ViewAssertions {
    public static void viewIsDisplayed(ViewInteraction viewInteraction) {
        viewInteraction.check(matches(isDisplayed()));
    }

    public static void viewIsNotDisplayed(ViewInteraction viewInteraction) {
        viewInteraction.check(matches(not(isDisplayed())));
    }

    public static void doesNotExist(ViewInteraction viewInteraction) {
        viewInteraction.check(androidx.test.espresso.assertion.ViewAssertions.doesNotExist());
    }

    public static void isChecked(ViewInteraction viewInteraction) {
        viewInteraction.check(matches(ViewMatchers.isChecked()));
    }

    public static void isNotChecked(ViewInteraction viewInteraction) {
        viewInteraction.check(matches(ViewMatchers.isNotChecked()));
    }

    public static void hasText(ViewInteraction viewInteraction, String text) {
        viewInteraction.check(matches(withText(text)));
    }

    public static void hasErrorText(ViewInteraction viewInteraction, String text) {
        viewInteraction.check(matches(ViewMatchers.hasErrorText(text)));
    }

    public static void hasHint(ViewInteraction viewInteraction, String text) {
        viewInteraction.check(matches(withHint(text)));
    }
}
