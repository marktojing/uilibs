package com.csnt.quickapp.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csnt.quickapp.R;
import com.csnt.quickapp.entitys.BaseSIEntity;
import com.csnt.ui.viewHolders.BaseViewHolder;

import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by sunrain
 * Created Date 2020/6/9 1:24 PM
 */
public class FruitAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<BaseSIEntity> mBaseSIEntityList;
    private OnItemClickListener onItemClickListener;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        LinearLayout linearLayout;
        public ViewHolder(View view) {
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruitname);
            linearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);
        }

    }

    public FruitAdapter(List<BaseSIEntity> baseSIEntityList) {
        mBaseSIEntityList = baseSIEntityList;
    }

    @Override

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        BaseViewHolder holder = new BaseViewHolder(view);
        return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

//        Fruit fruit = mFruitList.get(position);
//        holder.fruitImage.setImageResource(fruit.getImageId());
//        holder.fruitName.setText(fruit.getName());
//        HeadTitleBar inflate = (HeadTitleBar)LayoutInflater.from(holder.linearLayout.getContext()).inflate(fruit.getImageId(), holder.linearLayout, false);
//        inflate.setDefaultSmallTheme(0.5f);
//        holder.linearLayout.addView(inflate,0);
//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(onItemClickListener!=null){
//                    onItemClickListener.setItemClickListener(v,position);
//                }
//            }
//        });
    }
    public interface OnItemClickListener{
        public abstract void setItemClickListener(View v,int position);
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    @Override
    public int getItemCount() {
        return mBaseSIEntityList.size();
    }
}