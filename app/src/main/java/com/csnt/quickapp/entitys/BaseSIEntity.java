package com.csnt.quickapp.entitys;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.csnt.ui.entity.BaseEntity;

/**
 * Created by sunrain
 * Created Date 2020/6/9 1:23 PM
 */
@SuppressLint("ParcelCreator")
public class BaseSIEntity extends BaseEntity {

    private String name;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BaseSIEntity(){
    }
    public BaseSIEntity(String name, int id){
        this.name = name;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.id);
    }

    protected BaseSIEntity(Parcel in) {
        this.name = in.readString();
        this.id = in.readInt();
    }

}
