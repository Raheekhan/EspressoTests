package rahee.experitest.com.espressotask;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by ibrahimkhan on 3/12/18.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private String name = "Rahee";
    private String secondName = "Ibrahim";
    private String emptyInput = "Empty Input";

    @Before
    public void setUp() {}

    @Test
    public void testTextMatching() {
        Espresso.onView(withId(R.id.inputField)).perform(typeText(name));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.textViewField)).check(matches(withText(name)));
    }

    @Test
    public void testChangedTextWorks() {
        Espresso.onView(withId(R.id.inputField)).perform(typeText(name));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.textViewField)).check(matches(not(withText(secondName))));
    }

    @Test
    public void testIfInputIsEmpty() {
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.textViewField)).check(matches(withText(emptyInput)));
    }

    @After
    public void tearDown() {}

}