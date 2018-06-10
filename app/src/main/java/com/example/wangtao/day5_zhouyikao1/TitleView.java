package com.example.wangtao.day5_zhouyikao1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by wangtao on 2018/6/10.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class TitleView extends LinearLayout implements View.OnClickListener{

    private TextView textView;
    private Button leftBtn;
    private Button rightBtn;
    private IncanInterface incanInterface;
    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        InitView(context,attrs);
    }

    private void InitView(Context context,AttributeSet attrs) {
        View inflate = inflate(context, R.layout.title_item, this);
        textView = inflate.findViewById(R.id.title_tv);
        leftBtn = inflate.findViewById(R.id.title_left_btn);
        rightBtn = inflate.findViewById(R.id.title_right_btn);

        textView.setOnClickListener(this);
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        InitData(context,attrs);
    }

    private void InitData(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleView);

        textView.setText(typedArray.getString(R.styleable.TitleView_title_tv));
        textView.setTextSize(typedArray.getDimension(R.styleable.TitleView_title_tv_size,25));
        textView.setTextColor(typedArray.getColor(R.styleable.TitleView_title_tv_color, Color.RED));
        leftBtn.setText(typedArray.getString(R.styleable.TitleView_title_left_btn));
        rightBtn.setText(typedArray.getString(R.styleable.TitleView_title_tight_btn));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.title_tv:
                 incanInterface.getText();
                 break;
             case R.id.title_left_btn:
                 incanInterface.getLeftBtn();
                 break;
             case R.id.title_right_btn:
                 incanInterface.getRightBtn();
                 break;
         }
    }

    //回调函数
    public interface IncanInterface{
        void getText();
        void getLeftBtn();
        void getRightBtn();
    }
   public void getIncanInterface(IncanInterface incanInterface){
        this.incanInterface=incanInterface;
   }

}
