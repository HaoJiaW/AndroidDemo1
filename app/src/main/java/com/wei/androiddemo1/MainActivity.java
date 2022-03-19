package com.wei.androiddemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.wei.androiddemo1.utils.SharedPreferencesUtils;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLanguage(SharedPreferencesUtils.getString("application_language",null));
        setContentView(R.layout.activity_main);

        findViewById(R.id.t2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.t2:
                startActivity(new Intent(this,SettingActivity.class));
                finish();
                break;
        }
    }

    private void setLanguage(String language){
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (language == null){
            configuration.setLocale(Locale.getDefault());
        }else {
            if (language.equals("en")){
                configuration.setLocale(Locale.ENGLISH);
            }else if (language.equals("zh-rCN")){
                configuration.setLocale(Locale.SIMPLIFIED_CHINESE);
            }else if (language.equals("es")){
                configuration.setLocale(new Locale("es"));
            }
        }
        resources.updateConfiguration(configuration,displayMetrics);
        Log.e("MainActivity","language:"+language);
//        getApplicationContext().getResources().updateConfiguration(configuration,displayMetrics);
    }
}