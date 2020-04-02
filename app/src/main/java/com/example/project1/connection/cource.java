package com.example.project1.connection;

import android.os.Parcel;
import android.os.Parcelable;

public class cource implements Parcelable {
        private  String code;
        private  String name;

    protected cource(Parcel in) {
        code = in.readString();
        name = in.readString();
    }

    public static final Creator<cource> CREATOR = new Creator<cource>() {
        @Override
        public cource createFromParcel(Parcel in) {
            return new cource(in);
        }

        @Override
        public cource[] newArray(int size) {
            return new cource[size];
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

    public cource(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public cource() {
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(name);
    }
}
