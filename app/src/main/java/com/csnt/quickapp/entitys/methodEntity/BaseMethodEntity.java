package com.csnt.quickapp.entitys.methodEntity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

/**
 * Created by sunrain
 * Created Date 2020/6/11 10:41 PM
 */
public class BaseMethodEntity implements Parcelable {
    private String methodName;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public BaseMethodEntity() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.methodName);
    }

    protected BaseMethodEntity(Parcel in) {
        this.methodName = in.readString();
    }

    public static final Creator<BaseMethodEntity> CREATOR = new Creator<BaseMethodEntity>() {
        @Override
        public BaseMethodEntity createFromParcel(Parcel source) {
            return new BaseMethodEntity(source);
        }

        @Override
        public BaseMethodEntity[] newArray(int size) {
            return new BaseMethodEntity[size];
        }
    };
}
