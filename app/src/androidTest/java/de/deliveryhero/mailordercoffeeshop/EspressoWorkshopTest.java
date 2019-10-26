
package de.deliveryhero.mailordercoffeeshop;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class EspressoWorkshopTest {

    @Rule
    public ActivityTestRule<MainActivity> mainHomePage = new ActivityTestRule<>(MainActivity.class);

    ViewInteraction testCloseBtn;
    ViewInteraction testMenuListBtn;
    ViewInteraction testMenuListBtnClick;
    ViewInteraction nameEditTextField;
    ViewInteraction emailEditTextField;

    @Test
    public void espressoWorkShopTask() {
        testCloseBtn= onView((withId(R.id.close_button)));
        testCloseBtn.check(matches(isDisplayed()));
        testCloseBtn.perform(click());

        testMenuListBtn = onView((withId(R.id.use_menu)));
        testMenuListBtn.check(matches(isDisplayed()));

        testMenuListBtnClick = onView(allOf(withId(R.id.use_menu), withText("Menu")));
        testMenuListBtnClick.perform(click());

        //scroll to view
        onView(withId(R.id.beverage_recycler_view)).perform(RecyclerViewActions.scrollToPosition(16));
        ViewInteraction recyclerViewTest = onView(
                allOf(childAtPosition(allOf(withId(R.id.beverage_recycler_view),childAtPosition(
                        withId(R.id.order_fragment_container), 0)), 2), isDisplayed()));
        recyclerViewTest.perform(click());

        nameEditTextField = onView((withId(R.id.name_text_box)));
        nameEditTextField.perform(typeText("sanya"), closeSoftKeyboard());

        emailEditTextField = onView((withId(R.id.email_text_box)));
        emailEditTextField.perform(typeText("sanya.puri@rediffmail.com"), closeSoftKeyboard());

        ViewInteraction testOrderField = onView(allOf(withId(R.id.mail_order_button), withText("Submit order")));
        testOrderField.perform(scrollTo(), click());
    }
    private static Matcher < View > childAtPosition(
            final Matcher < View > myParent, final int location) {

        return new TypeSafeMatcher < View > () {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + location);
                myParent.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View v) {
                ViewParent parent = v.getParent();
                return parent instanceof ViewGroup && myParent.matches(parent) &&
                        v.equals(((ViewGroup) parent).getChildAt(location));
            }
        };
    }

    @After
    public void clearFields(){

        nameEditTextField.perform(clearText());
        emailEditTextField.perform(clearText());

        //onView(withId(R.id.name_text_box)).perform(clearText());
    }
}
