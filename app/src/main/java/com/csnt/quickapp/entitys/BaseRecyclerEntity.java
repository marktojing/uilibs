package com.csnt.quickapp.entitys;

import android.annotation.SuppressLint;
import android.os.Parcel;

import com.csnt.quickapp.component.activitys.base.BaseTitleActivity;
import com.csnt.quickapp.entitys.methodEntity.BaseMethodEntity;
import com.csnt.ui.entity.BaseEntity;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by sunrain
 * Created Date 2020/6/9 1:23 PM
 */
@SuppressLint("ParcelCreator")
public class BaseRecyclerEntity extends BaseSIEntity {
    private int recyclerType;
    private List<BaseRecyclerEntity> children;
    private Class nextClass;
    private BaseMethodEntity baseMethodEntity;
    private BaseRecyclerEntity nextEntity;

    public int getRecyclerType() {
        return recyclerType;
    }

    public void setRecyclerType(int recyclerType) {
        this.recyclerType = recyclerType;
    }

    public List<BaseRecyclerEntity> getChildren() {
        return children;
    }

    public void setChildren(List<BaseRecyclerEntity> children) {
        this.children = children;
    }

    public Class getNextClass() {
        return nextClass;
    }

    public void setNextClass(Class nextClass) {
        this.nextClass = nextClass;
    }

    public BaseMethodEntity getBaseMethodEntity() {
        return baseMethodEntity;
    }

    public void setBaseMethodEntity(BaseMethodEntity baseMethodEntity) {
        this.baseMethodEntity = baseMethodEntity;
    }

    public BaseRecyclerEntity getNextEntity() {
        return nextEntity;
    }

    public void setNextEntity(BaseRecyclerEntity nextEntity) {
        this.nextEntity = nextEntity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.recyclerType);
        dest.writeTypedList(this.children);
        dest.writeSerializable(this.nextClass);
        dest.writeParcelable(this.baseMethodEntity, flags);
        dest.writeParcelable(this.nextEntity, flags);
    }

    public BaseRecyclerEntity() {
    }

    protected BaseRecyclerEntity(Parcel in) {
        super(in);
        this.recyclerType = in.readInt();
        this.children = in.createTypedArrayList(BaseRecyclerEntity.CREATOR);
        this.nextClass = (Class) in.readSerializable();
        this.baseMethodEntity = in.readParcelable(BaseMethodEntity.class.getClassLoader());
        this.nextEntity = in.readParcelable(BaseRecyclerEntity.class.getClassLoader());
    }

    public static final Creator<BaseRecyclerEntity> CREATOR = new Creator<BaseRecyclerEntity>() {
        @Override
        public BaseRecyclerEntity createFromParcel(Parcel source) {
            return new BaseRecyclerEntity(source);
        }

        @Override
        public BaseRecyclerEntity[] newArray(int size) {
            return new BaseRecyclerEntity[size];
        }
    };
}
