package com.csnt.quickapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csnt.quickapp.R;
import com.csnt.quickapp.entitys.BaseSIEntity;
import com.csnt.ui.style.MaterialDesignStyle;
import com.jcodecraeer.xrecyclerview.progressindicator.AVLoadingIndicatorView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by sunrain
 * Created Date 2020/6/9 1:24 PM
 */
public class FruitAdapter2 extends RecyclerView.Adapter<FruitAdapter2.ViewHolder> {

    private List<BaseSIEntity> mBaseSIEntityList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        AVLoadingIndicatorView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitImage = (AVLoadingIndicatorView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruitname);
        }

    }

    public FruitAdapter2(List<BaseSIEntity> baseSIEntityList) {
        mBaseSIEntityList = baseSIEntityList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item2, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        BaseSIEntity baseSIEntity = mBaseSIEntityList.get(position);
        holder.fruitImage.setIndicatorColor(MaterialDesignStyle.color_white);
        holder.fruitImage.setIndicatorId(baseSIEntity.getId());
        holder.fruitName.setText(baseSIEntity.getName());
    }

    @Override
    public int getItemCount() {
        return mBaseSIEntityList.size();
    }
}