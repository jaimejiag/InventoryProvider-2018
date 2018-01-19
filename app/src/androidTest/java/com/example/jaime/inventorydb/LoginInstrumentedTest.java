package com.example.jaime.inventorydb;

import android.support.annotation.StringRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {

    @Test
    public void isUserEmpty() {
        onView(withId(R.id.btn_singIn)).perform(click());
        checkSnackbarDisplayByMessage(R.string.errorUserEmpty);
    }


    @Test
    public void isEmailEmpty() {
        onView(withId(R.id.btn_singIn)).perform(click());
        checkSnackbarDisplayByMessage(R.string.errorEmailEmpty);
    }


    @Test
    public void isPasswordEmpty() {
        onView(withId(R.id.btn_singIn)).perform(click());
        checkSnackbarDisplayByMessage(R.string.errorPasswordEmpty);
    }

    @Test
    public void passwordLenght() {
        onView(withId(R.id.edt_user)).perform(typeText("jaime"), closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText("ja"), closeSoftKeyboard());
        onView(withId(R.id.btn_singIn)).perform(click());
        checkSnackbarDisplayByMessage(R.string.errorPasswordEmpty);
    }


    @Test
    public void passwordDoubleCheck() {

    }


    private void checkSnackbarDisplayByMessage(@StringRes int message) {
        onView(withText(message))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
