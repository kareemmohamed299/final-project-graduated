package com.example.project1.connection;

import android.os.Parcel;
import android.os.Parcelable;

public class student_doctor implements Parcelable {
    private String id;
    private String fname;
    private String lname;
    private String mname;
    private String degree_student;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Creator<student_doctor> getCREATOR() {
        return CREATOR;
    }

    public student_doctor() {
    }

    public student_doctor(String id, String fname, String lname, String mname, String degree_student , String name) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.degree_student = degree_student;
        this.name =name;
    }

    protected student_doctor(Parcel in) {
        id = in.readString();
        fname = in.readString();
        lname = in.readString();
        mname = in.readString();
        degree_student = in.readString();
        name= in.readString();
    }

    public static final Creator<student_doctor> CREATOR = new Creator<student_doctor>() {
        @Override
        public student_doctor createFromParcel(Parcel in) {
            return new student_doctor(in);
        }

        @Override
        public student_doctor[] newArray(int size) {
            return new student_doctor[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getDegree() {
        return degree_student;
    }

    public void setDegree(String degree_student) {
        this.degree_student = degree_student;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(fname);
        dest.writeString(lname);
        dest.writeString(mname);
        dest.writeString(degree_student);
        dest.writeString(name);
    }
}
