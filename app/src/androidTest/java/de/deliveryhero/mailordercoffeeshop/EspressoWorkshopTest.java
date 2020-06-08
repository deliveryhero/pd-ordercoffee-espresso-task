package de.deliveryhero.mailordercoffeeshop;

import androidx.test.espresso.ViewFinder;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4Builder;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.runner.AndroidJUnitRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;;

public class EspressoWorkshopTest {

    private String name = "Ashish Yadav";
    private String email = "engg.ashishyadav.007@gmail.com";
    private String orderName = "Ashish Order";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void close() throws Exception {
        closeOnboardingScreen();
        orderEspresso();
        fillForm();
        submitOrder();
    }

    public void closeOnboardingScreen() throws Exception {
        onView(withId(R.id.close_button)).perform(click());
    }

    public void orderEspresso() throws Exception {
        int espressoCount = 2;
        for(int i = 0 ; i < espressoCount ; i++){
            onView(withId(R.id.more_espresso)).perform(click());
        }

        onView(withText("Chocolate")).perform(click());
        onView(withId(R.id.milk_type)).perform(click());
        onView(withText("Low fat")).perform(click());
        onView(withText("Steamed")).perform(click());
        onView(withText("REVIEW ORDER")).perform(ViewActions.scrollTo());
        onView(withText("REVIEW ORDER")).perform(click());
    }

    public void fillForm() throws Exception {
        onView(withId(R.id.name_text_box)).perform(typeText(name));
        onView(withId(R.id.email_text_box)).perform(ViewActions.scrollTo());
        onView(withId(R.id.email_text_box)).perform(typeText(email));
        onView(withId(R.id.custom_order_name_box)).perform(ViewActions.scrollTo());
        onView(withId(R.id.custom_order_name_box)).perform(typeText(orderName));
    }

    public void submitOrder() throws Exception {
        onView(withId(R.id.mail_order_button)).perform(ViewActions.scrollTo());
        onView(withId(R.id.mail_order_button)).perform(click());
    }
}
