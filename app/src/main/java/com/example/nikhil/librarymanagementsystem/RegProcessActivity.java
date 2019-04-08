package com.example.nikhil.librarymanagementsystem;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_process);
        MaterialButton adminBtn = findViewById(R.id.adminRegBtn);
        MaterialButton userBtn = findViewById(R.id.userRegBtn);
        adminBtn.setBackgroundColor(0x00000000);
        userBtn.setBackgroundColor(0x00000000);
        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegProcessActivity.this,AdminRegActivity.class);
                startActivity(intent);
            }
        });
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegProcessActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
