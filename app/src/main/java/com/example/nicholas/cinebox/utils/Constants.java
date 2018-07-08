package com.example.nicholas.cinebox.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Constants {

    public static SharedPreferences mPref;
    public static SharedPreferences.Editor mEditor;

    public static final String NAV_ITEM_ID = "navItemId";
    public static final String NAV_MENU_VIEW = "navInflateMenu";

    public static final String PREFS_NAME = "movieapp";
    public static final String LOGGED_SHARED_PREF = "loggedIn";
    public static final String PREF_USERNAME = "username";
    public static final String PREF_PASSWORD = "password";

    public static void initSharedPref(Context context){
        if (mPref ==null){
            mPref = PreferenceManager.getDefaultSharedPreferences(context);
            mEditor = mPref.edit();
        }

    }


    public static void storeLoggedInUserPref(boolean status){
        mEditor.putBoolean(LOGGED_SHARED_PREF, status);
        mEditor.commit();
    }

    public static void storeUser(String username){
        mEditor.putString(PREF_USERNAME, username);
        mEditor.commit();
    }

    public static boolean getLoggedInUserPref(){
        return mPref.getBoolean(LOGGED_SHARED_PREF, false);
    }
}
