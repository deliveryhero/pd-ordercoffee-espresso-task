package de.deliveryhero.mailordercoffeeshop;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoWorkshopTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    public void closeOnBoardingScreen() {
        onView(withId(R.id.close_button)).perform(click());
    }

    public void prepareCoffee() {
        // Add two espresso shots
        onView(withId(R.id.more_espresso)).perform(click());
        onView(withId(R.id.more_espresso)).perform(click());


        // Add chocolate
        onView(withId(R.id.chocolate)).perform(click());

        // Select low fat milk
        onData(anything()).inAdapterView(withId(R.id.milk_type)).atPosition(2).perform();

        // Select steamed milk
        onView(withText("Steamed")).perform(click());

        // Tap on review order
        onView(withId(R.id.review_order_button)).perform(scrollTo(), click());
    }

    public void fillTheForm() {
        String name = "Ramadan";
        String email = "mail@corp.com";
        String orderName = "Order1";

        // Fill the form
        onView(withId(R.id.name_text_box)).perform(typeText(name));
        onView(withId(R.id.email_text_box)).perform(typeText(email));
        onView(withId(R.id.custom_order_name_box)).perform(scrollTo(), typeText(orderName));

        // Tap on Submit order
        onView(withId(R.id.mail_order_button)).perform(scrollTo(), click());
    }

    @Test
    public void createOrder() {
        closeOnBoardingScreen();
        prepareCoffee();
        fillTheForm();
    }
}
