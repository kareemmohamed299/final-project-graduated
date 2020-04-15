package com.example.project1.connection;

import android.os.Parcel;
import android.os.Parcelable;

public class doctor_course implements Parcelable {
    private  String code;
    private  String name;
    private String duration;
    private String ex_start;
    private String ex_end;
    private String degree;
    private String exam_name;
    private String fname;
    private String mname;
    private String lname;
    private String idexam;

    public String getIdexam() {
        return idexam;
    }
    public String getDuration() {
        return duration;
    }

    public String getEx_start() {
        return ex_start;
    }

    public String getEx_end() {
        return ex_end;
    }

    public String getDegree() {
        return degree;
    }

    public String getExam_name() {
        return exam_name;
    }

    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getLname() {
        return lname;
    }

    protected doctor_course(Parcel in) {
        code = in.readString();
        name = in.readString();
    }

    public static final Creator<doctor_course> CREATOR = new Creator<doctor_course>() {
        @Override
        public doctor_course createFromParcel(Parcel in) {
            return new doctor_course(in);
        }

        @Override
        public doctor_course[] newArray(int size) {
            return new doctor_course[size];
        }
    };

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public doctor_course(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public doctor_course() {
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(name);
    }
}

