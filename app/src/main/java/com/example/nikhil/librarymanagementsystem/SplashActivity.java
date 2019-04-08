package com.example.nikhil.librarymanagementsystem;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nikhil.librarymanagementsystem.Base.View.BaseActivity;
import com.example.nikhil.librarymanagementsystem.helper.PreferenceHelper;
import com.example.nikhil.librarymanagementsystem.landing.view.LandingActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    Intent intent;
    String member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final boolean checkLogin;
        member = AppConstant.member;
        checkLogin = mPreferenceHelper.getBoolean(PreferenceHelper.IS_LOGIN, false);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(checkLogin && member.equals("Users")){
                    intent = new Intent(SplashActivity.this, UsersHomeActivity.class);
                    startActivity(intent);
                }
                else if(checkLogin && member.equals("Admin")){
                    intent = new Intent(SplashActivity.this, AdminHomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(SplashActivity.this, LandingActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },800);
    }
}
