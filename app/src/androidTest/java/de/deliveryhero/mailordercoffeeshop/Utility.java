package de.deliveryhero.mailordercoffeeshop;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import java.util.HashMap;

public class Utility {
    public static final String NAME_PLACEHOLDER = "Enter your name";
    public static final String EMAIL_PLACEHOLDER = "Enter email address";
    public static final String CUSTOM_ORDER_PLACEHOLDER = "Give your custom order a name";

    public static HashMap<String, Object> orderSelections(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("espresso", 2);
        map.put("hot", false);
        map.put("choco", true);
        map.put("milk option", "Low fat");
        map.put("milk type", "Steamed");
        return map;
    }

    public void closeOnboardingScreen(){
        onView(withId(R.id.close_button))
                .perform(click());

        onView(withId(R.id.use_menu))
                .check(matches(isEnabled()));

        onView(withId(R.id.use_custom))
                .check(matches(not(isEnabled())));
    }

    public void selectEspressoShots(int count){
        for(int i=0; i < count; i++){
            onView(withId(R.id.more_espresso))
                    .perform(click());
        }
        onView(withId(R.id.espresso_shot_counter))
                .check(matches(withText(String.valueOf(count))));
    }

    public void selectCoffeeType(boolean temp){
        onView(withId(R.id.beverage_temperature)).check(matches(isChecked()));
        if(!temp){
            onView(withId(R.id.beverage_temperature))
                    .perform(click())
                    .check(matches(isNotChecked()));
        }
    }

    public void selectChocolate(boolean choco){
        onView(withId(R.id.chocolate)).check(matches(isNotChecked()));
        if(choco){
            onView(withId(R.id.chocolate))
                    .perform(click())
                    .check(matches(isChecked()));
        }
    }

    public void selectMilk(String milkSelection, String milkType){
        onView(withId(R.id.milk_type))
                .perform(click());

        onData(allOf(is(instanceOf(String.class)),
                is(milkSelection)))
                .perform(click());

        onView(withText(milkType))
                .perform(click())
                .check(matches(isChecked()));
    }

    public void clickOnReviewOrder(){
        onView(withId(R.id.review_order_button))
                .perform(scrollTo(), click());
    }

    public void enterCustomerDetails(String name, String emailAddress, String customOrder){
        onView(withId(R.id.name_text_box)).check(matches(withHint(NAME_PLACEHOLDER)));
        onView(withId(R.id.name_text_box))
                .perform(typeText(name),closeSoftKeyboard());
        onView(withId(R.id.name_text_box)).check(matches(withText(name)));

        onView(withId(R.id.email_text_box)).check(matches(withHint(EMAIL_PLACEHOLDER)));
        onView(withId(R.id.email_text_box))
                .perform(typeText(emailAddress),closeSoftKeyboard());

        onView(withId(R.id.custom_order_name_box)).check(matches(withHint(CUSTOM_ORDER_PLACEHOLDER)));
        onView(withId(R.id.custom_order_name_box))
                .perform(typeText(customOrder),closeSoftKeyboard());
        onView(withId(R.id.custom_order_name_box)).check(matches(withText(customOrder)));
    }

    public void submitOrder(){
        onView(withId(R.id.mail_order_button))
                .perform(click());
    }
}
