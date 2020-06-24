package com.csnt.quickapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Vibrator;
import android.widget.Toast;



import com.csnt.quickapp.adapters.FruitAdapter;
import com.csnt.quickapp.adapters.FruitAdapter2;
import com.csnt.quickapp.adapters.TestAdapter;
import com.csnt.quickapp.component.activitys.base.BaseActivity;
import com.csnt.quickapp.entitys.BaseSIEntity;
import com.csnt.quickapp.model.DemoModel;
import com.csnt.ui.style.MaterialDesignStyle;
import com.csnt.ui.view.single.HeadTitleBar;
import com.csnt.ui.view.viewUtils.XRecyclerViewUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by sunrain
 * Created Date 2020/6/2 10:12 AM
 */
@SuppressLint("Registered")
public class TestActivity extends BaseActivity {
    private XRecyclerView recyclerView1;
    private RecyclerView recyclerView;
    private List<BaseSIEntity> baseSIEntityList = new ArrayList<>();
    FruitAdapter2 adapter;
    FruitAdapter adapter1;
    private   Vibrator vibrator;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    @Override
    public void init() {
        setContentView(R.layout.sample_login_base_layout);
        recyclerView1 = findViewById(R.id.recycle);
        recyclerView = findViewById(R.id.recycle1);
        HeadTitleBar viewById = findViewById(R.id.header_bar);
        XRecyclerViewUtil.setDefaultXRecycleViewTheme(this,recyclerView1, XRecyclerViewUtil.GRID);
        TestAdapter testAdapter = new TestAdapter(R.layout.fruit_item,new DemoModel().getComponentIconList(new ArrayList<BaseSIEntity>()));
        testAdapter.setOnItemChildClickListener((adapter,view,position)->{
            Toast.makeText(this,"ss"+position,Toast.LENGTH_SHORT).show();
        });
        recyclerView1.setAdapter(testAdapter);
        recyclerView1.setBackgroundColor(MaterialDesignStyle.color_text_normal_w);
       viewById.setDefaultTheme();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vibrator.cancel();
    }
}
