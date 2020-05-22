package de.deliveryhero.mailordercoffeeshop.pages;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import de.deliveryhero.mailordercoffeeshop.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static org.hamcrest.core.AllOf.allOf;

public class Onboarding {

    public static final ViewInteraction onboardingScreenTitle = onView(
            allOf(ViewMatchers.withId(R.id.slide_contents), ViewMatchers.withText(R.string.onboarding_create_custom_order)));

    public static final ViewInteraction closeOnboardingScreen = onView(
            allOf(ViewMatchers.withId(R.id.close_button)));

    public static final ViewInteraction goOnOnboardingScreen = onView(
            allOf(ViewMatchers.withId(R.id.go_on_button)));

    public static void dismissOnboardingScreen() {
        closeOnboardingScreen.perform(click());
    }

    public static void goOnOnboardingScreen() {
        goOnOnboardingScreen.perform(click());
    }

}
