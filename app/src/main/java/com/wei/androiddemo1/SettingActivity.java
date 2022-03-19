package com.wei.androiddemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.wei.androiddemo1.utils.SharedPreferencesUtils;

import java.util.Locale;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        findViewById(R.id.l1).setOnClickListener(this);
        findViewById(R.id.l2).setOnClickListener(this);
        findViewById(R.id.l3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.l1:
                SharedPreferencesUtils.setString("application_language","en");
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
            case R.id.l2:
                SharedPreferencesUtils.setString("application_language","zh-rCN");
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
            case R.id.l3:
                SharedPreferencesUtils.setString("application_language","es");
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
    }

}