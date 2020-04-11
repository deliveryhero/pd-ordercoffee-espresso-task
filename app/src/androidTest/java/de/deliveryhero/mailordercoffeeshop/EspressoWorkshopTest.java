package de.deliveryhero.mailordercoffeeshop;

public class EspressoWorkshopTest {
    @Test
    public void closeOnBoardingView() {
        onVisew(withId(R.id.close_button)).perform(click());
    }


    @Test
    public void prepareCoffee() {

        // Add two espresso shots
        onView(withId(R.id.more_espresso)).perform(click());
        onView(withId(R.id.more_espresso)).perform(click());

        // Add chocolate
        onView(withId(R.id.chocolate)).perform(click());

        // Select low fat milk
        // onData(withParentIndex(0)).atPosition(2).perform(click());
        onData(withId(R.id.milk_options_container)).atPosition(2).perform(click());

        // Select steamed milk
        onView(withText("Steamed")).perform(click());

        // Tap on review order
        onView(withId(R.id.review_order_button)).perform(click());
    }

    @Test
    public void submitOrder() {
        String name = "Ramadan";
        String email = "mail@corp.com";
        String orderName = "Order1";

        // Fill form
        onView(withId(R.id.name_text_box)).perform(typeText(name));
        onView(withId(R.id.email_text_box)).perform(typeText(name));
        onView(withId(R.id.custom_order_name_box)).perform(typeText(name));

        // Tap on Submit order
        onView(withId(R.id.mail_order_button)).perform(click());
    }
}
