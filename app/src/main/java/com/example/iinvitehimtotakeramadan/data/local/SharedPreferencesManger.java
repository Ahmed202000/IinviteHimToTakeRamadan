package com.example.iinvitehimtotakeramadan.data.local;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPreferencesManger {

    public static SharedPreferences sharedPreferences = null;
    public static final String Fajr = "_Fajr";
    public static final String Sunrise = "_Sunrise";
    public static final String Dhuhr = "_Dhuhr";
    public static final String Asr = "_Asr";
    public static final String Maghrib = "_Maghrib";
    public static final String Isha = "_Isha";




    public static void setSharedPreferences(Activity activity) {
        if (sharedPreferences == null) {
            sharedPreferences = activity.getSharedPreferences(
                    "aban", activity.MODE_PRIVATE);
        }
    }

    public static void SaveData(Activity activity, String data_Key, String data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }

    public static void SaveData(Activity activity, String data_Key, boolean data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(data_Key, data_Value);
            editor.commit();
        } else {
            setSharedPreferences(activity);
        }
    }

    public static void SaveData(Activity activity, String data_Key, Object data_Value) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String StringData = gson.toJson(data_Value);
            editor.putString(data_Key, StringData);
            editor.commit();
        }
    }


    public static String LoadData(Activity activity, String data_Key) {
        setSharedPreferences(activity);

        return sharedPreferences.getString(data_Key, null);
    }

    public static boolean LoadBoolean(Activity activity, String data_Key) {
        setSharedPreferences(activity);

        return sharedPreferences.getBoolean(data_Key, false);
    }

//    public static ClientData loadUserData(Activity activity) {
//        ClientData userData = null;
//
//        Gson gson = new Gson();
//        userData = gson.fromJson(LoadData(activity, USER_DATA), ClientData.class);
//
//        return userData;
//    }

    public static void clean(Activity activity) {
        setSharedPreferences(activity);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
        }
    }

}
