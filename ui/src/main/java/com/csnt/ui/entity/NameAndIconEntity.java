package com.csnt.ui.entity;

import android.annotation.SuppressLint;
import android.os.Parcel;

/**
 * Created by sunrain
 * Created Date 2020/6/10 4:22 PM
 */
@SuppressLint("ParcelCreator")
public class NameAndIconEntity extends BaseEntity {

    private String name;
    private int imageId;

    public NameAndIconEntity(String name, int imageId){
        this.name = name;
        this.imageId = imageId;

    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
