package com.csnt.quickapp.component.activitys.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.csnt.quickapp.R;
import com.csnt.quickapp.adapters.IconNameAdapter;
import com.csnt.quickapp.consts.ConstString;
import com.csnt.quickapp.entitys.BaseRecyclerEntity;
import com.csnt.quickapp.entitys.BaseSIEntity;
import com.csnt.quickapp.model.DemoModel;
import com.csnt.quickapp.utils.modalUtils.ToastUtil;
import com.csnt.ui.adapters.BaseRecyclerAdapter;
import com.csnt.ui.view.viewUtils.XRecyclerViewUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by sunrain
 * Created Date 2020/6/11 9:45 AM
 */
@SuppressLint("Registered")
public class BaseRecyclerActivity extends BaseTitleActivity {
    @BindView(R.id.recycle)
   public XRecyclerView recycle;
    @BindView(R.id.linear_layout1)
   public LinearLayout linearLayout1;
   public List<BaseRecyclerEntity> children;
    @Override
    protected int setLayout() {
        return R.layout.activity_recycle_base;
    }

    @Override
    public void init() {
        Intent intent = getIntent();
        BaseRecyclerEntity baseRecyclerEntity = (BaseRecyclerEntity)intent.getParcelableExtra(ConstString.INTENT_DATA_RECYCLER_BASE);
        children = baseRecyclerEntity.getChildren();
        if(children.size()<=0){
            children= new ArrayList<BaseRecyclerEntity>();
        }
        setTitle(baseRecyclerEntity.getName());
        XRecyclerViewUtil.setDefaultXRecycleViewTheme(this,recycle,baseRecyclerEntity.getRecyclerType());

        BaseRecyclerAdapter iconNameAdapter = new IconNameAdapter(R.layout.fruit_item,children);
        iconNameAdapter.setOnItemChildClickListener(this::setItemClickListener);
        recycle.setAdapter(iconNameAdapter);

    }
    protected void setItemClickListener(BaseRecyclerAdapter adapter, View view, int position) {
        BaseRecyclerEntity baseSIEntity = children.get(position - 1);
        if(position>0&&baseSIEntity.getChildren()!=null){
            Bundle bundle = new Bundle();
            bundle.putParcelable(ConstString.INTENT_DATA_RECYCLER_BASE,baseSIEntity);
            turnActivity(baseSIEntity.getNextClass(),false,bundle);
        }else{
            ToastUtil.showNomalMsg("没有下一步操作了...");
        }
    }


}
