package com.example.project1.connection;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class match implements Parcelable {

    private String name;
    private String id_component;
    private String degree;
    ArrayList<question_match> questions=new ArrayList<question_match>();
    public String getName() {
        return name;
    }
    public String getDegree() {
        return degree;
    }
    public String getId_component() {
        return id_component;
    }

    public ArrayList<question_match> getQuestions() {
        return questions;
    }
    public static Creator<match> getCREATOR() {
        return CREATOR;
    }

    public match(Parcel in) {
        name = in.readString();
        id_component = in.readString();
        degree=in.readString();
        questions = in.createTypedArrayList(question_match.CREATOR);
    }

    public static final Creator<match> CREATOR = new Creator<match>() {
        @Override
        public match createFromParcel(Parcel in) {
            return new match(in);
        }

        @Override
        public match[] newArray(int size) {
            return new match[size];
        }
    };

    public match() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id_component);
        dest.writeString(degree);
        dest.writeTypedList(questions);
    }
}
