package com.example.pratik_laptop.techcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by PRATIK-laptop on 15-Mar-18.
 */

public class SharedPrefManager1 {
    //the constants
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_SPECIAL = "keyspecial";
    private static final String KEY_ADDRESS = "keyaddress";
    private static final String KEY_CONTACT = "keycontact";
    private static final String KEY_ID = "keyid";

    private static SharedPrefManager1 mInstance;
    private static Context mCtx;

    private SharedPrefManager1(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager1 getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager1(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(Doc doc) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, doc.getId());
        editor.putString(KEY_NAME, doc.getName());
        editor.putString(KEY_SPECIAL, doc.getSpecial());
        editor.putString(KEY_ADDRESS, doc.getAddress());
        editor.putString(KEY_CONTACT, doc.getContact());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NAME, null) != null;
    }

    //this method will give the logged in user
    public Doc getDoc() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Doc(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_NAME, null),
                sharedPreferences.getString(KEY_SPECIAL, null),
                sharedPreferences.getString(KEY_ADDRESS, null),
                sharedPreferences.getString(KEY_CONTACT, null)
                );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }
}
