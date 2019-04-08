package com.example.nikhil.librarymanagementsystem;

import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nikhil.librarymanagementsystem.model.Admin;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminRegActivity extends AppCompatActivity {

    DatabaseReference libraryDatabase,adminDatabase;
    private static final String TAG = "AdminRegActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_reg);
        final EditText adminName = findViewById(R.id.edittext_adminName);
        final EditText adminID = findViewById(R.id.edittext_adminID);
        final EditText adminEmail = findViewById(R.id.edittext_adminEmail);
        final EditText adminPass = findViewById(R.id.edittext_adminPassword);
        final EditText adminCPass = findViewById(R.id.edittext_adminConfirmPassword);
        MaterialButton adminregBtn = findViewById(R.id.adminRegBtn);
        adminregBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(adminName.getText().toString())){
                    Toast.makeText(AdminRegActivity.this,"Name is Empty",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(adminID.getText().toString())){
                    Toast.makeText(AdminRegActivity.this,"ID is Empty",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(adminEmail.getText().toString())){
                    Toast.makeText(AdminRegActivity.this,"Email is Empty",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(adminPass.getText().toString())){
                    Toast.makeText(AdminRegActivity.this,"Password is Empty",Toast.LENGTH_LONG).show();
                }
                else if(!adminPass.getText().toString().equals(adminCPass.getText().toString())){
                    Toast.makeText(AdminRegActivity.this,"Password Not Matched!",Toast.LENGTH_LONG).show();
                }
                else {
                    libraryDatabase = FirebaseDatabase.getInstance().getReference();
                    adminDatabase = libraryDatabase.child("Admin");
                    Admin admin = new Admin();
                    admin.setLibrarian_name(adminName.getText().toString());
                    admin.setLibrarian_id(adminID.getText().toString());
                    admin.setLibrarian_email(adminEmail.getText().toString());
                    admin.setLibrarian_password(adminPass.getText().toString());
                    adminDatabase.child(adminEmail.getText().toString().substring(0,adminEmail.getText().toString().indexOf("@")).toLowerCase())
                            .setValue(admin)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AdminRegActivity.this,"data added to database",Toast.LENGTH_LONG).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"Failed Admin"+e.toString());
                                    Toast.makeText(AdminRegActivity.this,"Data not added to database",Toast.LENGTH_LONG).show();
                                }
                            });
                    Toast.makeText(AdminRegActivity.this,"Registration Done Successfully!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
