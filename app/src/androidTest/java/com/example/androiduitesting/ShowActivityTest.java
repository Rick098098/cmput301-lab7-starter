package com.example.androiduitesting;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.espresso.action.ViewActions;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(AndroidJUnit4.class)
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenario =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSwitchToShowActivity() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(ViewActions.typeText("Edmonton"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button_confirm)).perform(click());
        onData(is(instanceOf(String.class)))
                //.inAdapterView(withId(R.id.))
                .inAdapterView(withId(R.id.city_list))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.button_back)).check(matches(isDisplayed()));
        onView(withId(R.id.text_city_name)).check(matches(isDisplayed()));
    }

    @Test
    public void testCityNameConsistent() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(ViewActions.typeText("Edmonton"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button_confirm)).perform(click());
        //        onData(is(""))
        //                .inAdapterView(withId(R..city_list))
        onData(is("Edmonton"))
                .inAdapterView(withId(R.id.city_list))
                .perform(click());
        onView(withId(R.id.text_city_name)).check(matches(withText("Edmonton")));
    }

    @Test
    public void testBackButton() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
    //   onView(withId())
    //.perform(ViewActions.typeText("Edmonton".closeSoftKeyboard());
                //        onView(withId(R.id.button_confirm)).perform(click());
                //        onData(is("Edmonton"))
                .perform(ViewActions.typeText("Edmonton"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button_confirm)).perform(click());
        onData(is("Edmonton"))
                .inAdapterView(withId(R.id.city_list))
                .perform(click());
        onView(withId(R.id.button_back)).perform(click());
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }

}