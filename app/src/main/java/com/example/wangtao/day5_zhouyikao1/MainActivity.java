package com.example.wangtao.day5_zhouyikao1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TitleView.IncanInterface {

    private FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TitleView viewById = findViewById(R.id.main_title);
        viewById.getIncanInterface(this);
        flowLayout = findViewById(R.id.main_flow);
    }

    @Override
    public void getText() {
           flowLayout.removeAllViews();
    }

    @Override
    public void getLeftBtn() {
         flowLayout.removeViewAt(0);
    }

    @Override
    public void getRightBtn() {
        Toast.makeText(MainActivity.this,"右侧",Toast.LENGTH_LONG).show();
        TextView textView =new TextView(MainActivity.this);
        textView.setText("张三");
        textView.setBackgroundColor(Color.RED);
        /*ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        */
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,10,10,10);//4个参数按顺序分别是左上右下
        textView.setLayoutParams(layoutParams);
        textView.setWidth(getWindowManager().getDefaultDisplay().getWidth()/2);
        textView.setHeight(200);
        flowLayout.addView(textView);

    }
}
