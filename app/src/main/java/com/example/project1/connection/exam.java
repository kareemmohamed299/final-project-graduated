package com.example.project1.connection;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class exam implements Parcelable {
    private String idexam;
    private String q_text;
    private String id;
    private String degree;
    private String answer_text;
    ArrayList < String > choices = new ArrayList< String>();

    public exam(Parcel in) {
        idexam = in.readString();
        q_text = in.readString();
        id = in.readString();
        degree = in.readString();
        answer_text = in.readString();
        choices = in.createStringArrayList();
    }

    public static final Creator<exam> CREATOR = new Creator<exam>() {
        @Override
        public exam createFromParcel(Parcel in) {
            return new exam(in);
        }

        @Override
        public exam[] newArray(int size) {
            return new exam[size];
        }
    };

    public exam() {

    }

    public String getIdexam() {
        return idexam;
    }

    public String getQ_text() {
        return q_text;
    }

    public String getId() {
        return id;
    }

    public String getDegree() {
        return degree;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idexam);
        dest.writeString(q_text);
        dest.writeString(id);
        dest.writeString(degree);
        dest.writeString(answer_text);
        dest.writeStringList(choices);
    }
}
