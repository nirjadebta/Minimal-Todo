package com.example.avjindersinghsekhon.minimaltodo.Main;
import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.avjindersinghsekhon.minimaltodo.R;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

//import static android.support.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.assertion.ViewAssertions.selectedDescendantsMatch;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
//import static androidx.test.espresso.ViewInteraction.*;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;

//import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.action.ViewActions.pressMenuKey;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest0() {   // Looking for floating action button in main screen.
        onView(withId(R.id.addToDoItemFAB))            // withId(R.id.my_view) is a ViewMatcher
                // .perform(click())               // click() is a ViewAction
                .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion

    }

    @Test
    public void mainActivityTest1() {   // Looking for image above "No todos" message.
        //onView(withId(R.id.toDoCustomTextInput))            // withId(R.id.my_view) is a ViewMatcher
        onView(isDisplayed(R.drawable.empty_view_bg));
                // .perform(click())               // click() is a ViewAction
                //.check(matches(withText("You don't have any todos"))); // matches(isDisplayed()) is a ViewAssertion

    }

    private Matcher<View> isDisplayed(int empty_view_bg) {
        //onView(isDisplayed(R.drawable.empty_view_bg));
        return isDisplayed(R.drawable.empty_view_bg);
    }

    @Test
    public void mainActivityTest2() {   // Looking for "No todos" message on main screen.
        //onView(withId(R.id.toDoCustomTextInput))            // withId(R.id.my_view) is a ViewMatcher
        onView(withText("You don't have any todos"));
        // .perform(click())               // click() is a ViewAction
        //.check(matches(withText("You don't have any todos"))); // matches(isDisplayed()) is a ViewAssertion

    }


    @Test
    public void mainActivityTest3() {   // Looking for "Minimal" message on main screen.
        //onView(withId(R.id.aboutImageView))            // withId(R.id.my_view) is a ViewMatcher
        //.check(matches(withText("Minimal")));
        // .perform(click())               // click() is a ViewAction
        //.check(matches(withText("You don't have any todos"))); // matches(isDisplayed()) is a ViewAssertion

        final ViewInteraction minimal = onView(withId(R.id.aboutImageView))
                .check(matches(withContentDescription(containsString("Minimal"))));

    }
}
