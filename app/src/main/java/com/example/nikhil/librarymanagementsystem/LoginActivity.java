package com.example.nikhil.librarymanagementsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil.librarymanagementsystem.Base.View.BaseActivity;
import com.example.nikhil.librarymanagementsystem.helper.PreferenceHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    DatabaseReference libraryDatabase, memberDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView tvLogin = findViewById(R.id.login_tv);
        final EditText loginEmail = findViewById(R.id.login_email);
        final EditText loginPassword = findViewById(R.id.login_password);
        Intent intent = getIntent();
        final String member = intent.getStringExtra("member");
        tvLogin.setText(member + " Login");
        libraryDatabase = FirebaseDatabase.getInstance().getReference();
        MaterialButton loginBtn = findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memberDatabase = libraryDatabase.child(member).child(loginEmail.getText().toString().substring(0, loginEmail.getText().toString().indexOf("@")));
                memberDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (member.equals("Users")) {
                            Log.d(TAG, "On Data Changed " + dataSnapshot.getValue());
                            Log.d(TAG, "email are " + dataSnapshot.child("student_email").getValue().toString());
                            if (dataSnapshot.getValue() != null && dataSnapshot.child("student_email").getValue().toString().equalsIgnoreCase(loginEmail.getText().toString())
                                    && dataSnapshot.child("student_password").getValue().toString().equalsIgnoreCase(loginPassword.getText().toString())
                                    ) {
                                Intent intent = new Intent(LoginActivity.this, UsersHomeActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                                mPreferenceHelper.putBoolean(PreferenceHelper.IS_LOGIN, true);
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginActivity.this, "Incorrect Email or password", Toast.LENGTH_LONG).show();
                            }
                        }


                        if (member.equals("Admin")) {
                            if (dataSnapshot.getValue() != null && dataSnapshot.child("librarian_email").getValue().toString().equalsIgnoreCase(loginEmail.getText().toString())
                                    && dataSnapshot.child("librarian_password").getValue().toString().equalsIgnoreCase(loginPassword.getText().toString())
                                    ) {
                                Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
                                mPreferenceHelper.putBoolean(PreferenceHelper.IS_LOGIN, true);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginActivity.this, "Incorrect Email or password", Toast.LENGTH_LONG).show();
                            }
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
