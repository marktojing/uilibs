package com.csnt.quickapp.component.activitys.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.csnt.quickapp.R;
import com.csnt.quickapp.component.activitys.base.BaseTitleActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunrain
 * Created Date 2020/6/11 9:45 AM
 */
@SuppressLint("Registered")
public class UiActivity extends BaseTitleActivity {
    @BindView(R.id.recycle)
    XRecyclerView recycle;
    @BindView(R.id.linear_layout1)
    LinearLayout linearLayout1;

    @Override
    protected int setLayout() {
        return R.layout.activity_recycle_base;
    }

    @Override
    public void init() {


    }
}
