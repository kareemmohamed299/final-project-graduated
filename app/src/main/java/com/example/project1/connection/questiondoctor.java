package com.example.project1.connection;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class questiondoctor implements Parcelable {
    private String idexam;
    private String q_text;
    private String id;
    private String degree;
    private String answer_text;
    ArrayList< String > choices = new ArrayList< String>();

    public questiondoctor(Parcel in) {
        idexam = in.readString();
        q_text = in.readString();
        id = in.readString();
        degree = in.readString();
        answer_text = in.readString();
        choices = in.createStringArrayList();
    }

    public static final Creator<questiondoctor> CREATOR = new Creator<questiondoctor>() {
        @Override
        public questiondoctor createFromParcel(Parcel in) {
            return new questiondoctor(in);
        }

        @Override
        public questiondoctor[] newArray(int size) {
            return new questiondoctor[size];
        }
    };

    public questiondoctor() {

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

