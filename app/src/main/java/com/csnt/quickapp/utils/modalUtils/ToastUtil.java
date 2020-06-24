package com.csnt.quickapp.utils.modalUtils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.csnt.quickapp.BaseApplication;
import com.csnt.quickapp.R;
import com.csnt.quickapp.manage.AppManager;
import com.csnt.quickapp.utils.appClassUtils.AppUtil;
import com.csnt.ui.view.viewUtils.RippleUtil;

import androidx.annotation.RequiresApi;

/**
 * Created by sunrain
 * Created Date 2020/6/18 10:12 AM
 * ToastUtil
 */
public class ToastUtil {

    private static Context context = BaseApplication.getInstance();// App生命周期中唯一Context，BaseApplication继承Application


    private static final int TYPE_CODE_SUCCESS = 0x01;
    private static final int TYPE_CODE_ERROR = 0x02;
    private static final int TYPE_CODE_NOMAL = 0x03;

    private static final int DEFAULT_TIME_DELAY = 50;// 单位：毫秒

    private static Toast toast;// 系统提示类
    private static Handler handler;

    public static void showSuccessMsg(int msgResId) {
        try {
            showSuccessMsg(context.getString(msgResId));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void showNomalMsg(int msgResId) {
        try {
            showNomalMsg(context.getString(msgResId));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void showNomalMsg(String msg) {
        showMsg(TYPE_CODE_NOMAL, msg);
    }

    public static void showErrorMsg(int msgResId) {
        try {
            showErrorMsg(context.getString(msgResId));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void showSuccessMsg(String msg) {
        showMsg(TYPE_CODE_SUCCESS, msg);
    }

    public static void showErrorMsg(String msg) {
        showMsg(TYPE_CODE_ERROR, msg);
    }

    private static void showMsg(final int typeCode, final String msg) {
         LayoutInflater inflater = LayoutInflater.from(context);// 布局加载
         View myToastView = inflater.inflate(R.layout.layout_top_toast, null);
         TextView msgView = (TextView) myToastView.findViewById(R.id.tv_msg_text);
         int COLOR_SUCCESS = context.getResources().getColor(R.color.abec06);
         int COLOR_ERROR = context.getResources().getColor(R.color.colorAccent);
         int COLOR_NOMAL = context.getResources().getColor(R.color.c_36362c);
        if (context == null//
                || !AppUtil.isAppRunningForeground(context)// 如果APP回到后台，则不显示
                || msg == null) {
            return;
        }

        if (toast == null) {// 防止重复提示：不为Null，即全局使用同一个Toast实例
            toast = new Toast(context);
        }else{
            cancelToast();
            toast = new Toast(context);
        }

        if (handler == null) {
            handler = new Handler();
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int msgViewBagColor = 0;
                switch (typeCode) {
                    case TYPE_CODE_SUCCESS:
                        msgViewBagColor = COLOR_SUCCESS;
                        break;
                    case TYPE_CODE_ERROR:
                        msgViewBagColor = COLOR_ERROR;
                        break;
                    case TYPE_CODE_NOMAL:
                    default:
                        msgViewBagColor = COLOR_NOMAL;
                        break;
                }
//                msgView.setBackgroundColor(context.getResources().getColor(R.color.ffffff));
                msgView.setText(msg);
                msgView.setTextColor(msgViewBagColor);
                toast.setView(myToastView);
                toast.setGravity(Gravity.BOTTOM | Gravity.FILL_HORIZONTAL, 0, 0);// 顶部居中
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        }, DEFAULT_TIME_DELAY);
    }

    // 暂不对外提供：主要针对需要在某个时候，取消提示
    private static void cancelToast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }
}