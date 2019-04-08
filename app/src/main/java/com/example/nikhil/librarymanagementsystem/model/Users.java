package com.example.nikhil.librarymanagementsystem.model;

public class Users {

    private String student_name;
    private String student_roll_no;
    private String student_pin_no;
    private String student_email;

    public String getStudent_roll_no() {
        return student_roll_no;
    }

    public void setStudent_roll_no(String student_roll_no) {
        this.student_roll_no = student_roll_no;
    }

    public String getStudent_pin_no() {
        return student_pin_no;
    }

    public void setStudent_pin_no(String student_pin_no) {
        this.student_pin_no = student_pin_no;
    }

    private String student_password;

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }


    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

}
