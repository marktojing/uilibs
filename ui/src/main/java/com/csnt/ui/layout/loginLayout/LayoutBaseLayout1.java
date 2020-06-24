package com.csnt.ui.layout.loginLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.csnt.ui.R;

import androidx.annotation.RequiresApi;

/**
 * Created by sunrain
 * Created Date 2020/6/2 9:42 AM    <com.csnt.ui.layout.loginLayout.LayoutBaseLayout1
 *         android:layout_width="match_parent"
 *         android:layout_height="30dp"/>
 */
public class LayoutBaseLayout1 extends LinearLayout {
    private Context mContext;
    private  EditText userNameEdit;
    private  EditText passWordEdit;
    public LayoutBaseLayout1(Context context) {
        super(context);
        init(context,null);
    }

    public LayoutBaseLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public LayoutBaseLayout1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LayoutBaseLayout1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }
    @SuppressLint("ResourceAsColor")
    private void init(Context mContext, AttributeSet attrs) {
        setOrientation(LinearLayout.VERTICAL);
        if (attrs != null) {
            TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.LoginBaseLayout1);
//            isShowClean = a.getBoolean(R.styleable.MyEditText_myEditTextShowClear, true);
            a.recycle();
            setPadding(0, 0, 0, 0);
            setBackgroundColor(Color.TRANSPARENT);
        }
        userNameEdit = new EditText(mContext, attrs);
        LinearLayout.LayoutParams layoutParams = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 20;
        layoutParams.rightMargin = 0;
//        userNameEdit.setPadding(0,0,0,0);
        userNameEdit.setBackgroundColor(R.color.colorAccent);
        addView(userNameEdit, layoutParams);
       Rect  rect = new Rect(userNameEdit.getPaddingLeft(), userNameEdit.getPaddingTop(),
               userNameEdit.getPaddingRight(), userNameEdit.getPaddingBottom());
       EditText editText = new EditText(mContext,attrs);
        LinearLayout.LayoutParams layoutParams1 = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        layoutParams.leftMargin = 0;
//        layoutParams.bottomMargin = 0;
//        layoutParams.topMargin = 0;
//        layoutParams.rightMargin = 0;
        layoutParams1.setMargins(0,100,0,0);

//        layoutParams.;
//        imageViewLayoutParams.addRule(ALIGN_PARENT_RIGHT);
//        imageViewLayoutParams.addRule(CENTER_VERTICAL);
//
//        imageView.setLayoutParams(imageViewLayoutParams);
//        imageView.setVisibility(GONE);

        editText.setBackgroundColor(R.color.colorPrimary);

        addView(editText,layoutParams1);
    }

}
