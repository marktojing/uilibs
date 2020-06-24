package com.csnt.quickapp.component.activitys.ui.link.appbars;

import android.annotation.SuppressLint;
import android.view.View;

import com.csnt.quickapp.R;
import com.csnt.quickapp.component.activitys.base.BaseRecyclerActivity;
import com.csnt.quickapp.entitys.BaseRecyclerEntity;
import com.csnt.quickapp.entitys.methodEntity.BaseMethodEntity;
import com.csnt.ui.adapters.BaseRecyclerAdapter;
import com.csnt.ui.view.single.HeadTitleBar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by sunrain
 * Created Date 2020/6/11 10:21 PM
 */
@SuppressLint("Registered")
public class AppBarLcrActivity extends BaseRecyclerActivity {
    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void setItemClickListener(BaseRecyclerAdapter adapter, View view, int position) {
//        try {
//                Method method = HeadTitleBar.class.getMethod("setRightImageSize", int.class, int.class);
//                method.invoke(headerBar, 25,25);
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        BaseRecyclerEntity baseSIEntity = children.get(position - 1);
//        BaseMethodEntity baseMethodEntity = baseSIEntity.getBaseMethodEntity();
//        if(baseMethodEntity!=null){
//            String methodName = baseMethodEntity.getMethodName();
//            try {
//                Method method = HeadTitleBar.class.getMethod(methodName, (Class<?>) null);
//                method.invoke(headerBar, (Object) null);
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
