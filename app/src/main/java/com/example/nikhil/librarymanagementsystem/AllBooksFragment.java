package com.example.nikhil.librarymanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nikhil.librarymanagementsystem.Base.View.BaseFragment;
import com.example.nikhil.librarymanagementsystem.model.Books;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllBooksFragment extends Fragment {

    MaterialButton addBooks;
    RecyclerView mRecyclerView;
    DatabaseReference booksDB;
    AllBooksAdapter adapter ;
    private static final String TAG = "AllBooksFragment";
    List<Books> allBooksDetails = new ArrayList<>();

    public AllBooksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new AllBooksAdapter(getContext(),allBooksDetails);
        booksDB = FirebaseDatabase.getInstance().getReference().child("Books");
        booksDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                adapter.clearCollection();
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    String documentIdDB = dataSnapshot1.getKey();
                    Log.d(TAG,"Datasnapshot1 is: "+dataSnapshot1);
                    Books books = dataSnapshot1.getValue(Books.class);
                    allBooksDetails.add(books);
                }
                AllBooksAdapter adapter = new AllBooksAdapter(getContext(),allBooksDetails);
                //adapter.setCollection(allBooksDetails);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_all_books, container, false);
        mRecyclerView = rootView.findViewById(R.id.allBooksRecyView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        addBooks = rootView.findViewById(R.id.addBooksBtn);
        addBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),AddBooksActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(),"Clicked!",Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }

}
