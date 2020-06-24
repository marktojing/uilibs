package com.csnt.quickapp.component.activitys;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.csnt.quickapp.R;
import com.csnt.quickapp.adapters.IconNameAdapter;
import com.csnt.quickapp.component.activitys.base.BaseRecyclerActivity;
import com.csnt.quickapp.consts.ConstString;
import com.csnt.quickapp.entitys.BaseRecyclerEntity;
import com.csnt.quickapp.model.DemoModel;
import com.csnt.ui.adapters.BaseRecyclerAdapter;
import com.csnt.ui.view.dialogs.StatusDialog;
import com.csnt.ui.view.viewUtils.XRecyclerViewUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.annotation.RequiresApi;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunrain
 * Created Date 2020/6/10 5:01 PM
 */
@SuppressLint("Registered")
public class MainActivity extends BaseRecyclerActivity {
    @BindView(R.id.linear_layout1)
    LinearLayout linearLayout1;
    @BindView(R.id.recycle)
    XRecyclerView recycle;
    IconNameAdapter iconNameAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_recycle_base;
    }

    @Override
    public void init() {
        BaseRecyclerEntity rootData = new DemoModel().getRootData();
        List<BaseRecyclerEntity> children = rootData.getChildren();
        setTitle(rootData.getName());
        hideLeftIcon();
        XRecyclerViewUtil.setDefaultXRecycleViewTheme(this, recycle, rootData.getRecyclerType());
        iconNameAdapter = new IconNameAdapter(R.layout.fruit_item, rootData.getChildren());
        iconNameAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (position > 0) {
                BaseRecyclerEntity baseSIEntity = children.get(position - 1);
                Bundle bundle = new Bundle();
                bundle.putParcelable(ConstString.INTENT_DATA_RECYCLER_BASE, baseSIEntity);
                turnActivity(baseSIEntity.getNextClass(), false, bundle);
            }
        });
        recycle.setAdapter(iconNameAdapter);
        addAppBarRightIcon(0, v -> {

            //选择闪屏页布局=>选择闪屏
//            turnActivity(TestActivity.class,false);

//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    statusDialog.dismiss();
////                    showAlertDialog();
//                }
//            }, 3000);
        });

    }

    private void onItemClickListener(BaseRecyclerAdapter baseRecyclerAdapter, View view, int i) {
        showErrorDialog();
    }

    private void showErrorDialog() {
        StatusDialog statusDialog = StatusDialog.with(this)
                .setCancelable(false)
                .setPrompt("确定")
                .setType(StatusDialog.Type.ERROR)
                .show();
    }

    private void showSuccessDialog() {
        StatusDialog statusDialog = StatusDialog.with(this)
                .setCancelable(false)
                .setPrompt("确定")
                .setType(StatusDialog.Type.SUCCESS)
                .show();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
