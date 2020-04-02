package com.example.project1.connection;

import java.util.ArrayList;

public class student {
    private String id;
    private String fname;
    private String lname;
    private String mname;
    private String GPA;
    private String level;
    private String email;
    private String password;
    private String phone;
    private String program_name;
    private String department_name;
    ArrayList<cource> course = new ArrayList < cource > ();
    public void setId(String id) {
        this.id = id;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }
    public void setGPA(String GPA) {
        this.GPA = GPA;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
    public void setCourse(ArrayList<cource> course) {
        this.course = course;
    }
    public String getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getMname() {
        return mname;
    }
    public String getGPA() {
        return GPA;
    }
    public String getLevel() {
        return level;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhone() {
        return phone;
    }
    public String getProgram_name() {
        return program_name;
    }
    public String getDepartment_name() {
        return department_name;
    }
    public ArrayList<cource> getCourse() {
        return course;
    }
}
