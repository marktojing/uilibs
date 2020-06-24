package com.csnt.quickapp.entitys.methodEntity;

import android.os.Parcel;
import android.os.Parcelable;

import com.csnt.quickapp.entitys.parcelables.ParcelableObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunrain
 * Created Date 2020/6/11 10:41 PM
 */
public class BaseMethodListParmersEntity<T extends ParcelableObject & Parcelable> extends BaseMethodEntity {

    private ArrayList<ParcelableObject> parmers;


    public List<T> getParmers() {
        return (List<T>) parmers;
    }

    public void setParmers(List<T> parmers) {
        this.parmers = (ArrayList<ParcelableObject>) parmers;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.parmers);
    }

    public BaseMethodListParmersEntity() {
    }

    protected BaseMethodListParmersEntity(Parcel in) {
        super(in);
        this.parmers = in.createTypedArrayList(T.CREATOR);
    }

    public static final Creator<BaseMethodListParmersEntity> CREATOR = new Creator<BaseMethodListParmersEntity>() {
        @Override
        public BaseMethodListParmersEntity createFromParcel(Parcel source) {
            return new BaseMethodListParmersEntity(source);
        }

        @Override
        public BaseMethodListParmersEntity[] newArray(int size) {
            return new BaseMethodListParmersEntity[size];
        }
    };
}
