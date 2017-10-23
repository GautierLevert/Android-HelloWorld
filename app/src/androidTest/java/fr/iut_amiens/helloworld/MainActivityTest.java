package fr.iut_amiens.helloworld;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class MainActivityTest {

    private static final String NAME = "Toto";

    @Rule
    public IntentsTestRule<MainActivity> activityRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void fullyDisplayed() throws Exception {
        onView(withId(R.id.editText)).check(matches(isEnabled()));
        onView(withId(R.id.button)).check(matches(isClickable()));
    }

    @Test
    public void enterName() throws Exception {
        onView(withId(R.id.editText)).perform(typeText(NAME), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());

        intended(allOf(
                hasComponent(hasClassName(ViewActivity.class.getCanonicalName())),
                hasExtra(ViewActivity.EXTRA_NAME, NAME)));
    }
}
