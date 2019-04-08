package com.example.nikhil.librarymanagementsystem.model;

public class Admin {
    private String librarian_name;

    public String getLibrarian_id() {
        return librarian_id;
    }

    public void setLibrarian_id(String librarian_id) {
        this.librarian_id = librarian_id;
    }

    private String librarian_id;
    private String librarian_email;
    private String librarian_password;

    public String getLibrarian_name() {
        return librarian_name;
    }

    public void setLibrarian_name(String librarian_name) {
        this.librarian_name = librarian_name;
    }


    public String getLibrarian_email() {
        return librarian_email;
    }

    public void setLibrarian_email(String librarian_email) {
        this.librarian_email = librarian_email;
    }

    public String getLibrarian_password() {
        return librarian_password;
    }

    public void setLibrarian_password(String librarian_password) {
        this.librarian_password = librarian_password;
    }
}
