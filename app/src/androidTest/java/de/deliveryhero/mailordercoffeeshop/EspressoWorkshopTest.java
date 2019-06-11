package de.deliveryhero.mailordercoffeeshop;

import android.app.LauncherActivity;
import android.widget.ListView;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.StringContains.containsString;


@RunWith(AndroidJUnit4.class)
public class EspressoWorkshopTest {


    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void task1() {

        onView(withId(R.id.close_button)).perform(click());
        onView(withId(R.id.more_espresso)).perform(click());
        onView(withId(R.id.chocolate)).perform(click());
        onView(withId(R.id.milk_type)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.review_order_button)).perform(scrollTo(),click());
        onView(withId(R.id.name_text_box)).perform(typeText("test user"));
        onView(withId(R.id.email_text_box)).perform(scrollTo(),typeText("test.user@gmail.com"));
        onView(withId(R.id.custom_order_name_box)).perform(scrollTo(),typeText("test user order"));
        onView(withId(R.id.mail_order_button)).perform(scrollTo(),click());
    }

    @Test
    public void task2() {

        onView(withId(R.id.close_button)).perform(click());
        onView(withId(R.id.use_menu)).perform(click());
        onView(withId(R.id.beverage_recycler_view))
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText("Cappuccino")), click()));
        onView(withId(R.id.name_text_box)).perform(typeText("test user"));
        onView(withId(R.id.email_text_box)).perform(scrollTo(),typeText("test.user@gmail.com"));
        onView(withId(R.id.mail_order_button)).perform(scrollTo(),click());
    }


}
