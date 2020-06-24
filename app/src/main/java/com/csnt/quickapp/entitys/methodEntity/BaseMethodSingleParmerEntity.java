package com.csnt.quickapp.entitys.methodEntity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sunrain
 * Created Date 2020/6/11 10:41 PM
 */
public class BaseMethodSingleParmerEntity<T extends Object & Parcelable> extends BaseMethodEntity {

    private T parmers;

    public T getParmers() {
        return parmers;
    }

    public void setParmers(T parmers) {
        this.parmers = parmers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(this.parmers, flags);
    }

    public BaseMethodSingleParmerEntity() {
    }

    protected BaseMethodSingleParmerEntity(Parcel in) {
        this.parmers = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Creator<BaseMethodSingleParmerEntity> CREATOR = new Creator<BaseMethodSingleParmerEntity>() {
        @Override
        public BaseMethodSingleParmerEntity createFromParcel(Parcel source) {
            return new BaseMethodSingleParmerEntity(source);
        }

        @Override
        public BaseMethodSingleParmerEntity[] newArray(int size) {
            return new BaseMethodSingleParmerEntity[size];
        }
    };
}
