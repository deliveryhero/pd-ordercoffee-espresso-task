package de.deliveryhero.mailordercoffeeshop;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.AllOf.allOf;

@LargeTest
public class EspressoWorkshopTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void closeOnboardingScreen() {
        ViewInteraction closeButton = onView(allOf(withId(R.id.close_button), isDisplayed()));
        closeButton.perform(click());

        ViewInteraction mainTitle = onView(allOf(withId(R.id.title_view), isDisplayed()));
        mainTitle.check(matches(withText("Valori Mail Order Coffeeshop")));
    }

    @Test
    public void placeOrderTest() {
        //selecting two espresso shots
        ViewInteraction espressoPlusIcon = onView(withId(R.id.more_espresso));
        espressoPlusIcon.perform(click());
        espressoPlusIcon.perform(click());

        ViewInteraction espressoShotCounterValue = onView(withId(R.id.espresso_shot_counter));
        espressoShotCounterValue.check(matches(withText("2")));

        //selecting Chocolate
        ViewInteraction chocolateCheckbox = onView(withId(R.id.chocolate));
        chocolateCheckbox.perform(scrollTo(), click());

        //select low fat steamed milk
        ViewInteraction milkSelection = onView(withId(R.id.milk_type));
        milkSelection.perform(scrollTo(), click());
        DataInteraction milkTypeValue = onData(anything()).atPosition(2);
        milkTypeValue.perform(click());

        //select Steamed radio button
        ViewInteraction milkTypeRadioButtons = onView(
                Matchers.allOf(withText("Steamed"), isDisplayed()));
        milkTypeRadioButtons.perform(click());

        //click review order button
        ViewInteraction reviewOrderButton = onView(withId(R.id.review_order_button));
        reviewOrderButton.perform(scrollTo(), click());

        //assert that form is displayed
        ViewInteraction mainTitle = onView(allOf(withId(R.id.beverage_detail_title), isDisplayed()));
        mainTitle.check(matches(withText("Your custom drink")));

        //filling the form
        ViewInteraction nameField = onView(
                Matchers.allOf(withId(R.id.name_text_box), isDisplayed()));
        nameField.perform(replaceText("TestName"), closeSoftKeyboard());

        ViewInteraction emailField = onView(
                Matchers.allOf(withId(R.id.email_text_box), isDisplayed()));
        emailField.perform(replaceText("test@mail.com"), closeSoftKeyboard());

        ViewInteraction customNameField = onView(
                Matchers.allOf(withId(R.id.custom_order_name_box), isDisplayed()));
        customNameField.perform(replaceText("Ayaz's Order"), closeSoftKeyboard());

        //click mail order button
        ViewInteraction submitOrderButton = onView(withId(R.id.mail_order_button));
        submitOrderButton.perform(scrollTo(), click());
    }
}
