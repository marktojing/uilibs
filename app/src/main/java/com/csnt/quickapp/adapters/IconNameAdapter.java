package com.csnt.quickapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csnt.quickapp.ProgressStyle;
import com.csnt.quickapp.R;
import com.csnt.quickapp.entitys.BaseSIEntity;
import com.csnt.ui.adapters.BaseRecyclerAdapter;
import com.csnt.ui.style.MaterialDesignStyle;
import com.csnt.ui.view.DefaultTheme;
import com.csnt.ui.viewHolders.BaseViewHolder;
import com.jcodecraeer.xrecyclerview.progressindicator.AVLoadingIndicatorView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by sunrain
 * Created Date 2020/6/11 12:00 AM
 */
public class IconNameAdapter<T extends BaseSIEntity> extends BaseRecyclerAdapter<T> {
    public IconNameAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    @Override
    public void bindViewHolder(@NonNull BaseViewHolder holder, T item) {
        holder.setNestView(R.id.card_view);
        holder.setText(R.id.fruitname,item.getName());
        if(item.getId()>-2&&item.getId()<=27){
            holder.setGone(R.id.fruit_image,false);
            holder.setVisible(R.id.fruit_image1,true);
            AVLoadingIndicatorView view = (AVLoadingIndicatorView)holder.getView(R.id.fruit_image1);
            view.setIndicatorId(item.getId());
            view.setIndicatorColor(MaterialDesignStyle.color_theme_pink);
        }else{
            holder.setGone(R.id.fruit_image1,false);
            holder.setVisible(R.id.fruit_image,true);
            holder.setImageResource(R.id.fruit_image,item.getId());
        }

    }
}
