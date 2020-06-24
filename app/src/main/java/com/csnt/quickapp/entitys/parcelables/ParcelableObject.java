package com.csnt.quickapp.entitys.parcelables;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunrain
 * Created Date 2020/6/11 10:54 PM
 */
public class ParcelableObject extends Object implements Parcelable {


    protected ParcelableObject(Parcel in) {
    }

    public static final Creator<ParcelableObject> CREATOR = new Creator<ParcelableObject>() {
        @Override
        public ParcelableObject createFromParcel(Parcel in) {
            return new ParcelableObject(in);
        }

        @Override
        public ParcelableObject[] newArray(int size) {
            return new ParcelableObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
