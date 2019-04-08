package com.example.nikhil.librarymanagementsystem;

import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nikhil.librarymanagementsystem.model.Books;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBooksActivity extends AppCompatActivity {

    DatabaseReference DB,booksDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);
        DB = FirebaseDatabase.getInstance().getReference();
        final EditText bookID = findViewById(R.id.edit_text_book_id);
        final EditText bookTitle = findViewById(R.id.edit_text_book_title);
        final EditText bookAuthorName = findViewById(R.id.edit_text_book_author);
        final EditText bookQty = findViewById(R.id.edit_text_book_qty);
        final EditText bookCost = findViewById(R.id.edit_text_book_cost);
        MaterialButton addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(bookID.getText().toString())){
                    Toast.makeText(AddBooksActivity.this, "ID is empty!", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(bookTitle.getText().toString())){
                    Toast.makeText(AddBooksActivity.this, "Title is empty!", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(bookAuthorName.getText().toString())){
                    Toast.makeText(AddBooksActivity.this, "Author Name is empty!", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(bookQty.getText().toString())){
                    Toast.makeText(AddBooksActivity.this, "QTY is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(bookCost.getText().toString())){
                    Toast.makeText(AddBooksActivity.this, "Cost is empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    booksDB = DB.child("Books");
                    Books books = new Books();
                    books.setBookId(bookID.getText().toString());
                    books.setBookTitle(bookTitle.getText().toString());
                    books.setBookAuthor(bookAuthorName.getText().toString());
                    books.setBookQty(bookQty.getText().toString());
                    books.setBookCost(bookCost.getText().toString());
                    String time = String.valueOf(System.currentTimeMillis());
                    books.setID(time);
                    booksDB.child(time + "_"+bookID.getText().toString()).setValue(books)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AddBooksActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(AddBooksActivity.this, "Data not Added", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
    }
}
