package fr.iut_amiens.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class ViewActivityTest {

    @Rule
    public ActivityTestRule<ViewActivity> activityRule = new ActivityTestRule<>(ViewActivity.class);

    @Test
    public void showName() throws Exception {
        final Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        final Intent intent = new Intent(targetContext, ViewActivity.class);
        intent.putExtra(ViewActivity.EXTRA_NAME, "Toto");

        activityRule.launchActivity(intent);

        onView(withId(R.id.textView)).check(matches(withText(containsString("Toto"))));
    }
}
