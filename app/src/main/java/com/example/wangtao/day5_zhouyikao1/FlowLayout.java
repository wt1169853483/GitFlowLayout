package com.example.wangtao.day5_zhouyikao1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;

/**
 * Created by wangtao on 2018/6/10.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class FlowLayout extends ViewGroup{
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //测量宽高

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //配置初始宽度
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);

        //定义属性
        int height =0;
        int width=0;
        int totalHeight=0;
        View childView;
        int lineWidth=0;
        int childWidth=0;
        int childHeight=0;

        for (int i = 0; i <getChildCount() ; i++) {
               childView=getChildAt(i);
               childWidth =childView.getMeasuredWidth();
               childHeight =childView.getMeasuredHeight();
                width =childWidth;
               totalHeight += childHeight;

        }
         height =totalHeight;

        width =widthMode == MeasureSpec.EXACTLY ? widthSize:width;
        height =heightMode==MeasureSpec.EXACTLY? heightSize:height;

        setMeasuredDimension(width,height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //定义属性
        int totalHeight=0;
        View childView;
        int lineWidth=0;
        int childWidth=0;
        int childHeight=0;
        int lineHeight=0;
        for (int i = 0; i <getChildCount() ; i++) {
            childView=getChildAt(i);
            childWidth =childView.getMeasuredWidth();
            childHeight =childView.getMeasuredHeight();
             MarginLayoutParams marginLayoutParams= (MarginLayoutParams) childView.getLayoutParams();

             int leftMargin=  marginLayoutParams.leftMargin;
             int rightMargin=  marginLayoutParams.rightMargin;
            int TopMargin=  marginLayoutParams.topMargin;
            int BottomMargin=  marginLayoutParams.bottomMargin;
            if (i %2 ==0){
                  lineWidth =leftMargin;
                  totalHeight+=lineHeight+TopMargin+BottomMargin;
                  getViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth+rightMargin,totalHeight+childHeight );
                  lineHeight =childHeight+TopMargin+BottomMargin;
                  lineWidth =childWidth+leftMargin+rightMargin;
                  totalHeight += lineHeight;
            }else{
                getViewLayout(childView,lineWidth+leftMargin,totalHeight,lineWidth+childWidth+rightMargin,totalHeight+childHeight );
            }
        }

    }

    private void getViewLayout(View childView, int lineWidth, int totalHeight, int i, int i1) {
        childView.layout(lineWidth,totalHeight,i,i1);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);

    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }
}
