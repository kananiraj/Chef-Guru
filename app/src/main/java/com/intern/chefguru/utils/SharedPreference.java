package com.intern.chefguru.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {

    private static SharedPreference instance;
    private final String LOGIN_TYPE = "login_type";
    private final String IS_LOGGED_IN = "is_logged_in";
    private final String PROFILE_PIC = "profile";
    private final String USER_EMAIL = "user_email";
    private final String USER_NAME = "User_name";

    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;

    private SharedPreference(Context context) {
        mPref = context.getSharedPreferences("recipe_pref", 0);
        mEditor = mPref.edit();
    }

    public static SharedPreference getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreference(context);
        }
        return instance;
    }

    public void clearPreference() {
        mEditor.clear();
        mEditor.commit();
    }

    public void removeValue(String KEY) {
        mEditor.remove(KEY);
        mEditor.commit();
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        mPref.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        mPref.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public String getLoginType() {
        return mPref.getString(LOGIN_TYPE, "");
    }

    public void setLoginType(String loginType) {
        mEditor.putString(LOGIN_TYPE, loginType);
        mEditor.commit();
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        mEditor.putBoolean(IS_LOGGED_IN, isLoggedIn);
        mEditor.commit();
    }

    public boolean isLoggedIn() {
        return mPref.getBoolean(IS_LOGGED_IN, false);
    }

    public String getProfilePic() {
        return mPref.getString(PROFILE_PIC, "");
    }

    public void setProfilePic(String user_pic) {
        mEditor.putString(PROFILE_PIC, user_pic);
        mEditor.commit();
    }

    public String getUserName() {
        return mPref.getString(USER_NAME, "");
    }

    public void setUserName(String user_name) {
        mEditor.putString(USER_NAME, user_name);
        mEditor.commit();
    }

    public String getUserEmail() {
        return mPref.getString(USER_EMAIL, "");
    }

    public void setUserEmail(String userEmail) {
        mEditor.putString(USER_EMAIL, userEmail);
        mEditor.commit();
    }
}
