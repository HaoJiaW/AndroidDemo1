package com.wei.androiddemo1.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {

    private static SharedPreferences sharedPreferences;

    public static void init(Context context){
        sharedPreferences = context.getSharedPreferences("demo",Context.MODE_PRIVATE);
    }

    public static void setString(String key,String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public static String getString(String key,String defValue){
        return sharedPreferences.getString(key, defValue);
    }


}
