package com.example.nikhil.librarymanagementsystem.landing.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nikhil.librarymanagementsystem.LoginActivity;
import com.example.nikhil.librarymanagementsystem.LoginProcessActivity;
import com.example.nikhil.librarymanagementsystem.R;
import com.example.nikhil.librarymanagementsystem.RegProcessActivity;
import com.example.nikhil.librarymanagementsystem.SignupActivity;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Button loginBtn,signupBtn;
        loginBtn = findViewById(R.id.loginBtn);
        signupBtn = findViewById(R.id.signupBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingActivity.this,LoginProcessActivity.class);
                startActivity(intent);
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingActivity.this,RegProcessActivity.class);
                startActivity(intent);
            }
        });
    }
}
