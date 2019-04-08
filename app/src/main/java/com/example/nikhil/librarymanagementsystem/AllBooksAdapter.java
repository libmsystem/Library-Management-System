package com.example.nikhil.librarymanagementsystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil.librarymanagementsystem.model.Books;
import com.example.nikhil.librarymanagementsystem.model.Users;

import java.util.List;

public class AllBooksAdapter extends RecyclerView.Adapter<AllBooksAdapter.MyViewHolder> {

    protected Context mContext;
    private List<Books> mData;
    public AllBooksAdapter(Context context, List<Books> data){
        this.mContext = context;
        this.mData = data;
    }

    public void setCollection(List<Books> data){
        this.mData = data;
        notifyDataSetChanged();
    }

    public void clearCollection(){
        if (mData!=null){
            mData.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.all_books_recy_items,viewGroup, false);
        return new AllBooksAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        final Books b = mData.get(i);
        myViewHolder.bookId.setText(b.getBookId());
        myViewHolder.bookTitle.setText(b.getBookTitle());
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, b.getID(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView bookImage;
        TextView bookId,bookTitle;
        MaterialCardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.allBooksCardview);
            bookImage = itemView.findViewById(R.id.book_image);
            bookId = itemView.findViewById(R.id.book_id);
            bookTitle = itemView.findViewById(R.id.book_name);
        }

    }
}
