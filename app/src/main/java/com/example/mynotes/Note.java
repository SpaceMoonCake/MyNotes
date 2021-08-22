package com.example.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note implements Parcelable {
    private String titleNote;
    private String bodyNote;
    private String dateCreatedNote;

    public Note(String titleNote, String bodyNote, String dateCreatedNote) {
        this.titleNote = titleNote;
        this.bodyNote = bodyNote;
        this.dateCreatedNote = dateCreatedNote;
    }

    protected Note(Parcel in) {
        titleNote = in.readString();
        bodyNote = in.readString();
        dateCreatedNote = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getTitleNote() {
        return titleNote;
    }

    public String getBodyNote() {
        return bodyNote;
    }

    public String getDateCreatedNote() {
        return dateCreatedNote;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titleNote);
        parcel.writeString(bodyNote);
        parcel.writeString(dateCreatedNote);
    }
}
