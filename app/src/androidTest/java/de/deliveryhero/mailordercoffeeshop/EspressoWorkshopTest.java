package de.deliveryhero.mailordercoffeeshop;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@RunWith(AndroidJUnit4ClassRunner.class)
public class EspressoWorkshopTest extends Utility {

    @Rule
    public ActivityTestRule<MainActivity> myActivityRule = new ActivityTestRule<>(MainActivity.class);

    public static final String NAME = "Swati Jhamb";

    public static final String EMAILADDRESS = "sjhamb@abc.com";

    public static final String CUSTOMORDER = "coffee time";

    public HashMap<String, Object> orderOptions = orderSelections();

    @Before
    public void setUp(){
        closeOnboardingScreen();
    }

    @Test
    public void customOrderTest(){

        selectEspressoShots(Integer.parseInt(orderOptions.get("espresso").toString())); //Choose Espresso shots

        selectCoffeeType((Boolean) orderOptions.get("hot")); //Choose the coffee type 'hot'

        selectChocolate((Boolean) orderOptions.get("choco")); //Select 'chocolate' option

        selectMilk(orderOptions.get("milk option").toString(), orderOptions.get("milk type").toString()); //Open milk options and select milk type

        clickOnReviewOrder(); //Click on Review Order

        enterCustomerDetails(NAME, EMAILADDRESS, CUSTOMORDER); //Enter name, email address and custom order details

        submitOrder(); //Submit the order
    }
}
