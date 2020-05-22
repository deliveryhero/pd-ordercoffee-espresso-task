package de.deliveryhero.mailordercoffeeshop.pages;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import de.deliveryhero.mailordercoffeeshop.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

public class OrderCoffeeshop {
    public static final ViewInteraction orderCoffeeshopScreenTitle = onView(
            allOf(ViewMatchers.withId(R.id.title_view), ViewMatchers.withText(R.string.home_header)));

    public static final ViewInteraction addEspressoShotButton = onView(
            allOf(ViewMatchers.withId(R.id.more_espresso)));

    public static final ViewInteraction espressoShotCounterText = onView(
            allOf(ViewMatchers.withId(R.id.espresso_shot_counter)));

    public static final ViewInteraction removeEspressoShotButton = onView(
            allOf(ViewMatchers.withId(R.id.less_espresso)));

    public static final ViewInteraction selectChocolateCheckbox = onView(
            allOf(ViewMatchers.withId(R.id.chocolate)));

    public static final ViewInteraction milkTypeSpinner = onView(
            allOf(ViewMatchers.withId(R.id.milk_type)));

    public static final ViewInteraction reviewOrderButton = onView(
            allOf(ViewMatchers.withId(R.id.review_order_button)));

    public static void clickOnAddEspressoShotButton() {
        addEspressoShotButton.perform(scrollTo(), click());
    }

    public static void clickOnRemoveEspressoShotButton() {
        removeEspressoShotButton.perform(scrollTo(), click());
    }

    public static void checkTheChocolateCheckbox() {
        selectChocolateCheckbox.perform(scrollTo(), click());
    }

    public static void selectTheMilkTypeSpinner(int number) {
        milkTypeSpinner.perform(click());
        onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(number).perform(click());
    }

    public static void setMilkPreparation(String milkPreparation) {
        onView(allOf(ViewMatchers.withText(milkPreparation)));
    }

    public static void clickOnReviewOrder() {
        reviewOrderButton.perform(scrollTo(), click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
