package com.example.project1.connection;

import android.os.Parcel;
import android.os.Parcelable;

public class question_match implements Parcelable {
    private String question;
    private String answer;
    private String id_match;

    protected question_match(Parcel in) {
        question = in.readString();
        answer = in.readString();
        id_match = in.readString();
    }

    public static final Creator<question_match> CREATOR = new Creator<question_match>() {
        @Override
        public question_match createFromParcel(Parcel in) {
            return new question_match(in);
        }

        @Override
        public question_match[] newArray(int size) {
            return new question_match[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getId_match() {
        return id_match;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(answer);
        dest.writeString(id_match);
    }
}
