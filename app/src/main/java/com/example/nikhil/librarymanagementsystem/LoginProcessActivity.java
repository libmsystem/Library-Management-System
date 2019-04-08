package com.example.nikhil.librarymanagementsystem;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_process);
        MaterialButton adminLoginBtn = findViewById(R.id.adminLoginBtn);
        MaterialButton userLoginBtn = findViewById(R.id.userLoginBtn);
        adminLoginBtn.setBackgroundColor(0x00000000);
        userLoginBtn.setBackgroundColor(0x00000000);
        adminLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginProcessActivity.this,LoginActivity.class);
                intent.putExtra("member","Admin");
                startActivity(intent);
            }
        });
        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginProcessActivity.this,LoginActivity.class);
                intent.putExtra("member","Users");
                startActivity(intent);
            }
        });
    }
}
