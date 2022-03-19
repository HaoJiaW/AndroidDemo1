package com.wei.androiddemo1;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.wei.androiddemo1.utils.SharedPreferencesUtils;

import java.util.Locale;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferencesUtils.init(this);

        updateConfiguration(this);
    }

    private void updateConfiguration(Context context){
        String language = SharedPreferencesUtils.getString("application_language", null);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(Locale.getDefault());
        if (language != null) {
            switch (language) {
                case "en":
                    configuration.setLocale(Locale.ENGLISH);
                    break;
                case "es":
                    configuration.setLocale(new Locale("es"));
                    break;
                case "zh-rCN":
                    configuration.setLocale(Locale.SIMPLIFIED_CHINESE);
                    break;
            }
        }
        //核心代码
        resources.updateConfiguration(configuration,displayMetrics);
    }
}
