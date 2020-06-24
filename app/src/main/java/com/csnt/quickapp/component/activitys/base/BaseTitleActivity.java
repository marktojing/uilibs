package com.csnt.quickapp.component.activitys.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.csnt.quickapp.R;
import com.csnt.quickapp.utils.modalUtils.ToastUtil;
import com.csnt.ui.style.MaterialDesignStyle;
import com.csnt.ui.view.dialogs.AlertDialog;
import com.csnt.ui.view.dialogs.SelectDialog;
import com.csnt.ui.view.dialogs.StatusDialog;
import com.csnt.ui.view.single.HeadTitleBar;
import com.csnt.ui.view.viewUtils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by sunrain
 * Created Date 2020/6/8 3:58 PM
 */
@SuppressLint("Registered")
public abstract class BaseTitleActivity extends AppCompatActivity {
    @BindView(R.id.header_bar)
     HeadTitleBar headerBar;
    @BindView(R.id.linear_layout)
     LinearLayout linearLayout;
    private Unbinder mUnbinder;
    private StatusDialog statusDialog;
    public final int LEFT_IN_LEFT_OUT=0x01;
    public final int LEFT_IN_RIGHT_OUT=0x02;
    public final int RIGHT_IN_LEFT_OUT=0x03;
    public final int RIGHT_IN_RIGHT_OUT=0x04;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
//        setAnimator(RIGHT_IN_LEFT_OUT);
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, false)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this, 0x55000000);
        }
        setContentView(R.layout.activity_base_title);
        headerBar = (HeadTitleBar) findViewById(R.id.header_bar);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        headerBar.setDefaultTheme();
        headerBar.setLeftListener(v->{
            finish();
            setAnimator(LEFT_IN_RIGHT_OUT);
        });
        setLayoutInfo(setLayout());
        init();
    }

    public void setAnimator(int type) {
        switch (type){
            case LEFT_IN_LEFT_OUT:
                setLeftInLeftOutAnim();
                break;
            case LEFT_IN_RIGHT_OUT:
                setLeftInRightOutAnim();
                break;
            case RIGHT_IN_LEFT_OUT:
                setRightInLeftOutAnim();
                break;
            case RIGHT_IN_RIGHT_OUT:
                setRightInRightOutAnim();
                break;
        }

    }

    protected void setLeftInRightOutAnim(){
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    };
    protected void setLeftInLeftOutAnim(){
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    };
    protected void setRightInLeftOutAnim(){
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
    };
    protected void setRightInRightOutAnim(){
        overridePendingTransition(R.anim.right_in,R.anim.right_out);
    };

    protected abstract int setLayout();

    public abstract void init();

    public void setTitle(@StringRes int title) {
        headerBar.setTitle(title);
    };

    public void showStatusDialog(String msg,int type){
        if(statusDialog!=null){
            dismissStatusDialog();
        }
        if(!TextUtils.isEmpty(msg)){
            statusDialog=StatusDialog.with(this).setCancelable(false)
                    .setPrompt(msg)
                    .setType(type).show();
        }else{
            statusDialog=StatusDialog.with(this).setCancelable(false)
                    .setType(type).show();
        }
    }
    public void showStatusDialog(String msg,int type,boolean isCancel){
        if(statusDialog!=null){
            dismissStatusDialog();
        }
        if(!TextUtils.isEmpty(msg)){
            statusDialog=StatusDialog.with(this).setCancelable(isCancel)
                    .setPrompt(msg)
                    .setType(type).show();
        }else{
            statusDialog=StatusDialog.with(this).setCancelable(isCancel)
                    .setType(type).show();
        }
    }
    public void dismissStatusDialog(){
        if(statusDialog!=null){
            statusDialog.dismiss();
        }
    }
    public void showSelectDialog(String title, List<SelectDialog.SelectItem> selectItems, SelectDialog.OnItemClick onItemClick){
        SelectDialog selectDialog = new SelectDialog(this,selectItems);
        selectDialog.setTitle(title);
        selectDialog.setOnItemClick(index->{
            selectDialog.dismiss();
            onItemClick.click(index);
        });
        selectDialog.show();
    }
    public void showAlertDialog(String title,String content,String rightStr,
                                String leftStr,
                                boolean isCancel,
                                View.OnClickListener onClickListenerR,
                                View.OnClickListener onClickListenerL){
        AlertDialog.with(this)
                .setCancelable(true)
                .setContent(content)
                .setTitle(title)
                .setPositiveButton(rightStr,onClickListenerR).setNegativeButton(leftStr, onClickListenerL).show();
    }

    public void setTitle(String title) {
        headerBar.setTitle(title);
    }
    private void setLayoutInfo(int layout) {
        linearLayout.addView(LayoutInflater.from(linearLayout.getContext()).inflate(layout, linearLayout, false));
        mUnbinder = ButterKnife.bind(this);
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();

    }
    public void hideLeftIcon(){
        headerBar.hideLeftContent();
    }
    public void addAppBarRightIcon(@DrawableRes int drawable,View.OnClickListener onClickListener){
        headerBar.addRightImage(drawable);
        headerBar.setRightListener(onClickListener);
    }
    /**
     * 界面跳转
     *
     * @param class1   要跳转到的界面
     * @param isFinish 是否结束当前的Activity (true 结束，false 不结束)
     * @param bundle   不需要传参数的时候传入空即可
     */
    protected void turnActivity(@NonNull Class class1, @NonNull boolean isFinish, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, class1);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        setAnimator(RIGHT_IN_LEFT_OUT);
        if (isFinish) {
            finish();
            setAnimator(LEFT_IN_RIGHT_OUT);
        }
    }
    /**
     * 界面跳转
     *
     * @param class1   要跳转到的界面
     * @param isFinish 是否结束当前的Activity (true 结束，false 不结束)
     */
    protected void turnActivity(@NonNull Class class1, @NonNull boolean isFinish) {
        Intent intent = new Intent();
        intent.setClass(this, class1);
        startActivity(intent);
        setAnimator(RIGHT_IN_LEFT_OUT);
        if (isFinish) {
            finish();
            setAnimator(LEFT_IN_RIGHT_OUT);
        }
    }


}
