package com.novsu.antonivanov.exampleproject.MyObjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Date creation: 31.03.2016.
 */

public class BaseObject implements Parcelable {
    private int id;
    private String name;

    public BaseObject() {
        this.id = -1;
        this.name = "";
    }

    public BaseObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.getId());
        dest.writeString(this.getName());
    }

    public static final Parcelable.Creator<BaseObject> CREATOR = new Parcelable.Creator<BaseObject>() {

        @Override
        public BaseObject createFromParcel(Parcel source) {
            return new BaseObject(source);
        }

        @Override
        public BaseObject[] newArray(int size) {
            return new BaseObject[size];
        }
    };

    protected BaseObject(Parcel source) {
        this.setId(source.readInt());
        this.setName(source.readString());
    }
}
