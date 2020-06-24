package com.csnt.ui.view.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.csnt.ui.R;
import com.csnt.ui.adapters.BaseRecyclerAdapter;
import com.csnt.ui.entity.BaseEntity;
import com.csnt.ui.entity.NameAndIconEntity;
import com.csnt.ui.view.DefaultTheme;
import com.csnt.ui.view.viewUtils.XRecyclerViewUtil;
import com.csnt.ui.viewHolders.BaseViewHolder;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * Created by sunrain
 * Created Date 2020/6/9 12:27 PM
 */
public class CustomRecycleView extends XRecyclerView implements DefaultTheme {
    private Context mContext;
    public CustomRecycleView(Context context) {
        super(context);
        this.mContext=context;
    }

    public CustomRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
    }

    public CustomRecycleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext=context;
    }

    @Override
    public void setDefaultTheme() {
        XRecyclerViewUtil.setDefaultXRecycleViewTheme(mContext,this, XRecyclerViewUtil.GRID);
    }

    @Override
    public void setDefaultSmallTheme(float rate) {
        View rootView = this.getRootView();
        XRecyclerViewUtil.setDefaultXRecycleViewTheme(mContext,this, XRecyclerViewUtil.GRID);
    }
}
