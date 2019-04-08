package com.example.nikhil.librarymanagementsystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nikhil.librarymanagementsystem.model.Users;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "SignupActivity";
    DatabaseReference libraryDatabase,usersDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final EditText studentName = findViewById(R.id.edittext_studentName);
        final EditText studentRollNo = findViewById(R.id.edittext_studentRollNo);
        final EditText studentPinNo = findViewById(R.id.edittext_studentPinNo);
        final EditText studentEmail = findViewById(R.id.edittext_studentEmail);
        final EditText studentPassword = findViewById(R.id.edittext_studentPassword);
        final EditText studentConfirmPassword = findViewById(R.id.edittext_studentConfirmPassword);
        Button signupRegButton = findViewById(R.id.signupRegBtn);
        signupRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(studentName.getText())){
                    Toast.makeText(SignupActivity.this,"Name is Empty",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(studentRollNo.getText())){
                    Toast.makeText(SignupActivity.this,"Roll No is Empty",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(studentPinNo.getText())){
                    Toast.makeText(SignupActivity.this,"Pin no is Empty",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(studentEmail.getText())){
                    Toast.makeText(SignupActivity.this,"Email is Empty",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(studentPassword.getText())){
                    Toast.makeText(SignupActivity.this,"Password is Empty",Toast.LENGTH_LONG).show();
                }
                else if (!studentPassword.getText().toString().equals(studentConfirmPassword.getText().toString())){
                    Toast.makeText(SignupActivity.this,"Password not matched!",Toast.LENGTH_LONG).show();
                }
                else{
                    libraryDatabase = FirebaseDatabase.getInstance().getReference();
                    usersDatabase = libraryDatabase.child("Users");
                    Users users = new Users();
                    users.setStudent_name(studentName.getText().toString());
                    users.setStudent_roll_no(studentRollNo.getText().toString());
                    users.setStudent_pin_no(studentPinNo.getText().toString());
                    users.setStudent_email(studentEmail.getText().toString());
                    users.setStudent_password(studentPassword.getText().toString());
                    usersDatabase.child(studentEmail.getText().toString().substring(0,studentEmail.getText().toString().indexOf("@")).toLowerCase())
                            .setValue(users)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(SignupActivity.this,"data added to database",Toast.LENGTH_LONG).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"Failed Users"+e.toString());
                                    Toast.makeText(SignupActivity.this,"Data not added to database",Toast.LENGTH_LONG).show();
                                }
                            });
                    Toast.makeText(SignupActivity.this,"Registration Done Successfully!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
