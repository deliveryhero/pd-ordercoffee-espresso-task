package de.deliveryhero.mailordercoffeeshop;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoWorkshopTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);


    private void closeOnboardingScreenShouldShowCoffeeSelectionScreen() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.close_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.title_view), withText("Valori Mail Order Coffeeshop"),
                        childAtPosition(
                                allOf(withId(R.id.root_layout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Valori Mail Order Coffeeshop")));
    }


    private void chooseEspressoShots() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.more_espresso), withText("+"),
                        childAtPosition(
                                allOf(withId(R.id.espresso_shot_container),
                                        childAtPosition(
                                                withId(R.id.coffee_container),
                                                0)),
                                2)));
        materialButton.perform(scrollTo(), click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.more_espresso), withText("+"),
                        childAtPosition(
                                allOf(withId(R.id.espresso_shot_container),
                                        childAtPosition(
                                                withId(R.id.coffee_container),
                                                0)),
                                2)));
        materialButton2.perform(scrollTo(), click());
    }

    private void chooseChocolate() {
        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.chocolate), withText("Chocolate"),
                        childAtPosition(
                                allOf(withId(R.id.extras_container),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                2)),
                                0)));
        appCompatCheckBox.perform(scrollTo(), click());
    }

    private void chooseMilkType() {
        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.milk_type),
                        childAtPosition(
                                allOf(withId(R.id.extras_container),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                2)),
                                2)));
        appCompatSpinner.perform(scrollTo(), click());

        DataInteraction checkedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(2);
        checkedTextView.perform(click());
    }

    private void chooseSteamed() {
        ViewInteraction appCompatRadioButton = onView(
                allOf(withText("Steamed"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withId(R.id.milk_options_container),
                                                3)),
                                0),
                        isDisplayed()));
        appCompatRadioButton.perform(click());
    }

    private void clickReviewOrder() {
        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.review_order_button), withText("Review order"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.custom_order_scrollview),
                                        0),
                                3)));
        materialButton3.perform(scrollTo(), click());
    }

    private  void validateOrderSelection() {
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.beverage_detail_ingredients), withText("Ingredients:\n2 shots of espresso\nChocolate\nSteamed Low fat"),
                        childAtPosition(
                                allOf(withId(R.id.beverage_detail_ingredients_container),
                                        childAtPosition(
                                                withId(R.id.beverage_detail_container),
                                                0)),
                                3),
                        isDisplayed()));
        textView2.check(matches(withText("Ingredients:\n2 shots of espresso\nChocolate\nSteamed Low fat")));
    }

    private void fillForm() {
        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.name_text_box),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.name_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("Rafa"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.email_text_box),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.email_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("rafa@gmail.com"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.custom_order_name_box),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.custom_order_name_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("Test"), closeSoftKeyboard());

    }

    private void clickSubmitOrderButton() {
        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.mail_order_button), withText("Submit order"),
                        childAtPosition(
                                allOf(withId(R.id.beverage_detail_container),
                                        childAtPosition(
                                                withId(R.id.scrollview),
                                                0)),
                                3)));
        materialButton4.perform(scrollTo(), click());
    }

    @Test
    public void espressoTest() {
        closeOnboardingScreenShouldShowCoffeeSelectionScreen();
        chooseEspressoShots();
        chooseChocolate();
        chooseMilkType();
        chooseSteamed();
        clickReviewOrder();
        validateOrderSelection();
        fillForm();
        clickSubmitOrderButton();
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
