package com.example.mylibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KIM on 10/22/2018.
 */

public class DataNotification implements Parcelable {
    private int id;
    private  String time;
    private String title;
    private String content;
    private String type;

    public DataNotification(int id, String time, String title, String content, String type) {
        this.id = id;
        this.time = time;
        this.title = title;
        this.content = content;
        this.type = type;
    }
    public DataNotification(String time, String title, String content, String type) {
        this.time = time;
        this.title = title;
        this.content = content;
        this.type = type;
    }
    public DataNotification(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Creator<DataNotification> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(time);
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(type);
    }

    public DataNotification(Parcel in){
        id = in.readInt();
        time = in.readString();
        title = in.readString();
        content = in.readString();
        type = in.readString();
    }

    public static final Creator<DataNotification> CREATOR
            = new Creator<DataNotification>() {
        public DataNotification createFromParcel(Parcel in) {
            return new DataNotification(in);
        }
        public DataNotification[] newArray(int size) {
            return new DataNotification[size];
        }
    };

}
