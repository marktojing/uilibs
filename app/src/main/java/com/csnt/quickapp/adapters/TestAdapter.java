package com.csnt.quickapp.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.csnt.quickapp.R;
import com.csnt.quickapp.entitys.BaseSIEntity;
import com.csnt.ui.adapters.BaseRecyclerAdapter;
import com.csnt.ui.view.DefaultTheme;
import com.csnt.ui.viewHolders.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Created by sunrain
 * Created Date 2020/6/10 2:50 PM
 */
public class TestAdapter extends BaseRecyclerAdapter<BaseSIEntity> {
    /**
     * 这里通过构造方法传入布局和数据
     * @param layoutResId
     * @param data
     */
    public TestAdapter(int layoutResId, @Nullable List<BaseSIEntity> data) {
        super(layoutResId, data);
    }

    /**
     * 这里进行数据与布局绑定
     * @param holder
     * @param item
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void bindViewHolder(@NonNull BaseViewHolder holder, BaseSIEntity item) {
        holder.setNestView(R.id.card_view);//设置 哪个控件接受点击事件
        holder.setText(R.id.fruitname,item.getName());
        ViewGroup view = holder.getView(R.id.linear_layout);
        View inflate = LayoutInflater.from(view.getContext()).inflate(item.getId(), view, false);
        ((DefaultTheme)inflate).setDefaultSmallTheme(0.5f);
        view.addView(inflate,0);
    }
}
