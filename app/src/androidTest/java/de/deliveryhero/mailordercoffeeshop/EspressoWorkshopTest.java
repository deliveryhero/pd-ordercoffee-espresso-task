package de.deliveryhero.mailordercoffeeshop;

import android.content.Intent;
import android.net.Uri;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import de.deliveryhero.mailordercoffeeshop.assertions.ViewAssertions;
import de.deliveryhero.mailordercoffeeshop.pages.CustomDrink;
import de.deliveryhero.mailordercoffeeshop.pages.Onboarding;
import de.deliveryhero.mailordercoffeeshop.pages.OrderCoffeeshop;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

public class EspressoWorkshopTest {

    @Rule
    public IntentsTestRule<MainActivity> mIntentsTestRule = new IntentsTestRule<>(MainActivity.class, false, false);
    private String username;
    private String email;
    private String customOrder;
    private List<String> milkTypes = Arrays.asList("No milk", "Soy", "Low fat", "Half & half", "Cream", "Custom %");
    private List<String> milkPreparation = Arrays.asList("Steamed", "Foamed", "Whipped", "Scalded");

    @Before
    public void setUp() throws Exception {
        //TODO: Randomize data of usernames, email and custom order
        username = "Ziad";
        email = "ziadtawfeek05@gmail.com";
        customOrder = "Ziad's usual order";
        mIntentsTestRule.launchActivity(null);
    }

    //TODO: Only one assertion per test, this is just to demonstrate validation points since the test includes lots of actions
    @Test
    public void verifySubmittingOrderOpensGmailApp() {
        Onboarding.dismissOnboardingScreen();
        ViewAssertions.viewIsDisplayed(OrderCoffeeshop.addEspressoShotButton);

        OrderCoffeeshop.clickOnAddEspressoShotButton();
        OrderCoffeeshop.clickOnAddEspressoShotButton();
        ViewAssertions.hasText(OrderCoffeeshop.espressoShotCounterText, String.valueOf(2));

        OrderCoffeeshop.checkTheChocolateCheckbox();
        ViewAssertions.isChecked(OrderCoffeeshop.selectChocolateCheckbox);

        OrderCoffeeshop.selectTheMilkTypeSpinner(milkTypes.indexOf("Low fat"));
        OrderCoffeeshop.setMilkPreparation(milkPreparation.get(0));
        OrderCoffeeshop.clickOnReviewOrder();
        ViewAssertions.viewIsDisplayed(CustomDrink.nameEditText);

        CustomDrink.typeEmail(email);
        CustomDrink.typeUsername(username);
        CustomDrink.typeCustomOrder(customOrder);
        CustomDrink.clickOnMailOrderButton();

        intended(allOf(
                hasAction(Intent.ACTION_SENDTO), hasData(Uri.parse("mailto:"))));
    }

    @Test
    public void verifyErrorToastDisplaysWhenNoEspressoShotsSelected() {
        Onboarding.dismissOnboardingScreen();

        OrderCoffeeshop.clickOnReviewOrder();
        onView(withText("A minimum of 1 Espresso shot is required for each order")).inRoot(withDecorView(not(mIntentsTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        mIntentsTestRule.finishActivity();
    }
}
