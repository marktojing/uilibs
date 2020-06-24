package com.csnt.quickapp.model;

import android.widget.Adapter;

import com.csnt.quickapp.ProgressStyle;
import com.csnt.quickapp.R;
import com.csnt.quickapp.component.activitys.base.BaseRecyclerActivity;
import com.csnt.quickapp.component.activitys.base.BaseTitleActivity;
import com.csnt.quickapp.component.activitys.ui.link.appbars.AppBarLcrActivity;
import com.csnt.quickapp.entitys.BaseRecyclerEntity;
import com.csnt.quickapp.entitys.BaseSIEntity;
import com.csnt.ui.view.viewUtils.XRecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.DrawableRes;

/**
 * Created by sunrain
 * Created Date 2020/6/10 12:09 AM
 */
public class DemoModel {

    public List<BaseSIEntity> getRefreshIconList(List<BaseSIEntity> refreshIconList) {
        if (refreshIconList == null) {
            refreshIconList = new ArrayList<>();
        }
        BaseSIEntity apple = new BaseSIEntity("SysProgress", ProgressStyle.SysProgress);
        refreshIconList.add(apple);
        BaseSIEntity banana = new BaseSIEntity("BallPulse", ProgressStyle.BallPulse);
        refreshIconList.add(banana);
        refreshIconList.add(new BaseSIEntity("BallGridPulse", ProgressStyle.BallGridPulse));
        refreshIconList.add(new BaseSIEntity("BallClipRotate", ProgressStyle.BallClipRotate));
        refreshIconList.add(new BaseSIEntity("BallClipRotatePulse", ProgressStyle.BallClipRotatePulse));
        refreshIconList.add(new BaseSIEntity("SquareSpin", ProgressStyle.SquareSpin));
        refreshIconList.add(new BaseSIEntity("BallClipRotateMultiple", ProgressStyle.BallClipRotateMultiple));
        refreshIconList.add(new BaseSIEntity("BallPulseRise", ProgressStyle.BallPulseRise));
        refreshIconList.add(new BaseSIEntity("BallRotate", ProgressStyle.BallRotate));
        refreshIconList.add(new BaseSIEntity("CubeTransition", ProgressStyle.CubeTransition));
        refreshIconList.add(new BaseSIEntity("BallZigZag", ProgressStyle.BallZigZag));
        refreshIconList.add(new BaseSIEntity("BallZigZagDeflect", ProgressStyle.BallZigZagDeflect));
        refreshIconList.add(new BaseSIEntity("BallTrianglePath", ProgressStyle.BallTrianglePath));
        refreshIconList.add(new BaseSIEntity("BallScale", ProgressStyle.BallScale));
        refreshIconList.add(new BaseSIEntity("LineScale", ProgressStyle.LineScale));
        refreshIconList.add(new BaseSIEntity("LineScaleParty", ProgressStyle.LineScaleParty));
        refreshIconList.add(new BaseSIEntity("BallScaleMultiple", ProgressStyle.BallScaleMultiple));
        refreshIconList.add(new BaseSIEntity("BallPulseSync", ProgressStyle.BallPulseSync));
        refreshIconList.add(new BaseSIEntity("BallBeat", ProgressStyle.BallBeat));
        refreshIconList.add(new BaseSIEntity("LineScalePulseOut", ProgressStyle.LineScalePulseOut));
        refreshIconList.add(new BaseSIEntity("LineScalePulseOutRapid", ProgressStyle.LineScalePulseOutRapid));
        refreshIconList.add(new BaseSIEntity("BallScaleRipple", ProgressStyle.BallScaleRipple));
        refreshIconList.add(new BaseSIEntity("BallScaleRippleMultiple", ProgressStyle.BallScaleRippleMultiple));
        refreshIconList.add(new BaseSIEntity("BallSpinFadeLoader", ProgressStyle.BallSpinFadeLoader));
        refreshIconList.add(new BaseSIEntity("LineSpinFadeLoader", ProgressStyle.LineSpinFadeLoader));
        refreshIconList.add(new BaseSIEntity("TriangleSkewSpin", ProgressStyle.TriangleSkewSpin));
        refreshIconList.add(new BaseSIEntity("Pacman", ProgressStyle.Pacman));
        refreshIconList.add(new BaseSIEntity("SemiCircleSpin", ProgressStyle.SemiCircleSpin));
        return refreshIconList;
    }

    public List<BaseSIEntity> getComponentIconList(List<BaseSIEntity> refreshIconList) {
        if (refreshIconList == null) {
            refreshIconList = new ArrayList<>();
        }
        refreshIconList.add(new BaseSIEntity("Appbar", R.layout.demo_header_bar));
        refreshIconList.add(new BaseSIEntity("XRecycleView", R.layout.demo_header_bar));
        refreshIconList.add(new BaseSIEntity("CardView", R.layout.demo_header_bar));
        refreshIconList.add(new BaseSIEntity("LoginUI", R.layout.demo_header_bar));

        return refreshIconList;
    }

    public List<BaseSIEntity> getIconList(List<BaseSIEntity> refreshIconList) {
        if (refreshIconList == null) {
            refreshIconList = new ArrayList<>();
        }
        refreshIconList.add(new BaseSIEntity("UI", R.drawable.ic_uicn));
        refreshIconList.add(new BaseSIEntity("网络请求", R.drawable.ic_wangluo));
        refreshIconList.add(new BaseSIEntity("数据存储", R.drawable.ic_cunchu));
        refreshIconList.add(new BaseSIEntity("日志记录", R.drawable.ic_rizhi));
        refreshIconList.add(new BaseSIEntity("监测系统", R.drawable.ic_jiance));
        return refreshIconList;
    }

    public BaseRecyclerEntity getRootData() {
        return setBaseRecyclerData("主页", R.drawable.ic_launcher_background, getMainData(), XRecyclerViewUtil.GRID);
    }
    public BaseRecyclerEntity setBaseRecyclerData(String title, @DrawableRes int id) {
        BaseRecyclerEntity baseRecyclerEntity = new BaseRecyclerEntity();
        baseRecyclerEntity.setName(title);
        baseRecyclerEntity.setId(id);
        return baseRecyclerEntity;
    }
    public BaseRecyclerEntity setBaseRecyclerData(String title) {
        BaseRecyclerEntity baseRecyclerEntity = new BaseRecyclerEntity();
        baseRecyclerEntity.setName(title);
        baseRecyclerEntity.setId(R.drawable.ic_default);
        return baseRecyclerEntity;
    }

    public BaseRecyclerEntity setBaseRecyclerData(String title, @DrawableRes int id, List<BaseRecyclerEntity> children,int type,Class<? extends BaseRecyclerActivity> nextClass) {
        BaseRecyclerEntity baseRecyclerEntity = new BaseRecyclerEntity();
        baseRecyclerEntity.setName(title);
        baseRecyclerEntity.setId(id);
        baseRecyclerEntity.setChildren(children);
        baseRecyclerEntity.setRecyclerType(type);
        baseRecyclerEntity.setNextClass(nextClass);
        return baseRecyclerEntity;
    }
    public BaseRecyclerEntity setBaseRecyclerData(String title, @DrawableRes int id, List<BaseRecyclerEntity> children,int type) {
        BaseRecyclerEntity baseRecyclerEntity = new BaseRecyclerEntity();
        baseRecyclerEntity.setName(title);
        baseRecyclerEntity.setId(id);
        baseRecyclerEntity.setChildren(children);
        baseRecyclerEntity.setRecyclerType(type);
        if(children!=null&&children.size()>0){
            baseRecyclerEntity.setNextClass(BaseRecyclerActivity.class);
        }
        return baseRecyclerEntity;
    }

    public List<BaseRecyclerEntity> getMainData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("UI", R.drawable.ic_uicn, getUIData(), XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("网络请求", R.drawable.ic_wangluo, getHTTPData(), XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("数据存储", R.drawable.ic_cunchu, getUIData(), XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("日志记录", R.drawable.ic_rizhi, getUIData(), XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("监测系统", R.drawable.ic_jiance, getUIData(), XRecyclerViewUtil.GRID));
        return list;
    }
    public List<BaseRecyclerEntity> getUIData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("布局", R.drawable.ic_uicn));
        list.add(setBaseRecyclerData("动画", R.drawable.ic_donghua));
        list.add(setBaseRecyclerData("单一控件", R.drawable.ic_single));
        list.add(setBaseRecyclerData("组合控件", R.drawable.ic_zuhe,getLinkUIData(),XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("列表控件", R.drawable.ic_listview,getListViewData(),XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("弹窗控件", R.drawable.ic_default,getModalViewData(),XRecyclerViewUtil.GRID));
        return list;
    }
    public List<BaseRecyclerEntity> getModalViewData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("Toast", R.drawable.ic_default,getToastData(),XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("Dialog", R.drawable.ic_default,getDialogData(),XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("PopupWindow", R.drawable.ic_default));
        list.add(setBaseRecyclerData("Spinner", R.drawable.ic_default));
        return list;
    }
    public List<BaseRecyclerEntity> getToastData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("工具类=>ToastUtil"));
        return list;
    }
    public List<BaseRecyclerEntity> getDialogData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("statusDialog"));
        list.add(setBaseRecyclerData("SelectDialog"));
        list.add(setBaseRecyclerData("ProcessDialog(下载文件)（未完成）"));
        return list;
    }
    public List<BaseRecyclerEntity> getListViewData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("RecycleView", R.drawable.ic_default,getRecycleViewData(),XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("GridView", R.drawable.ic_default));
        return list;
    }
    public List<BaseRecyclerEntity> getRecycleViewData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("FleshType", R.drawable.ic_default,getListFleshData(),XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("其他", R.drawable.ic_default));
        return list;
    }
    public List<BaseRecyclerEntity> getListFleshData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        List<BaseSIEntity> list1 = new ArrayList<>();
        List<BaseSIEntity> refreshIconList = getRefreshIconList(list1);
        for (BaseSIEntity baseSIEntity : refreshIconList) {
            BaseRecyclerEntity baseRecyclerEntity = new BaseRecyclerEntity();
            baseRecyclerEntity.setId(baseSIEntity.getId());
            baseRecyclerEntity.setName(baseSIEntity.getName());
            list.add(baseRecyclerEntity);
        }
        return list;
    }
    public List<BaseRecyclerEntity> getLinkUIData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("APPBAR", R.drawable.ic_default,getAppBarUIData(),XRecyclerViewUtil.GRID));
        list.add(setBaseRecyclerData("CardView", R.drawable.ic_default,getCardViewData(),XRecyclerViewUtil.FLOW_V));
        list.add(setBaseRecyclerData("输入框", R.drawable.ic_default));
        list.add(setBaseRecyclerData("选择框", R.drawable.ic_default));
        return list;
    }
    public List<BaseRecyclerEntity> getAppBarUIData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("左中右风格", R.drawable.ic_default,getLcrData(),XRecyclerViewUtil.LIST_V, AppBarLcrActivity.class));
        list.add(setBaseRecyclerData("左右风格", R.drawable.ic_default));
        return list;
    }
    public List<BaseRecyclerEntity> getCardViewData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("样式1", R.drawable.ic_default));
        list.add(setBaseRecyclerData("样式2", R.drawable.ic_default));
        return list;
    }

    public List<BaseRecyclerEntity> getLcrData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("点击设置标题", R.drawable.ic_default));
        list.add(setBaseRecyclerData("点击设置左侧文字", R.drawable.ic_default));
        list.add(setBaseRecyclerData("点击设置左侧图标", R.drawable.ic_default));
        list.add(setBaseRecyclerData("点击设置右侧文字", R.drawable.ic_default));
        list.add(setBaseRecyclerData("点击设置右侧图标", R.drawable.ic_default));
        return list;
    }
    public List<BaseRecyclerEntity> getHTTPData() {
        List<BaseRecyclerEntity> list = new ArrayList<>();
        list.add(setBaseRecyclerData("Retrofit", R.drawable.ic_wangluo));
        return list;
    }
}
