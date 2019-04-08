package com.example.nikhil.librarymanagementsystem.model;

public class Books {

    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookQty;
    private String bookCost;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookQty() {
        return bookQty;
    }

    public void setBookQty(String bookQty) {
        this.bookQty = bookQty;
    }

    public String getBookCost() {
        return bookCost;
    }

    public void setBookCost(String bookCost) {
        this.bookCost = bookCost;
    }
}
