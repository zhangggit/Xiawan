package com.example.zhanggang.shangyueyizhou;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 类作用：自定义View
 * 时  间：2017/9/2 - 8:16.
 * 创建人：张刚
 */

public class MyView extends LinearLayout {

    onClickLener onClickLener;

    public void setOnClickLener(MyView.onClickLener onClickLener) {
        this.onClickLener = onClickLener;
    }

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //加载布局
        LayoutInflater.from(context).inflate(R.layout.item,this);
        //获取控件
        TextView back = findViewById(R.id.back);
        TextView more = findViewById(R.id.more);
        TextView title = findViewById(R.id.title_item);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        //获取自定义属性
        String titlecontent = typedArray.getString(R.styleable.MyView_textcontent);
        float titlefontsize = typedArray.getDimension(R.styleable.MyView_textfontsize, 18);
        int titlefontcolor = typedArray.getColor(R.styleable.MyView_textfontcolor, Color.GREEN);
        int titlebg = typedArray.getColor(R.styleable.MyView_textbg, Color.BLUE);

        String backcontent = typedArray.getString(R.styleable.MyView_backcontent);
        float backfontsize = typedArray.getDimension(R.styleable.MyView_backfontsize, 18);
        int backfontcolor = typedArray.getColor(R.styleable.MyView_backfontcolor, Color.GREEN);
        int backbg = typedArray.getColor(R.styleable.MyView_backbg, Color.BLUE);

        String morecontent = typedArray.getString(R.styleable.MyView_morecontent);
        float morefontsize = typedArray.getDimension(R.styleable.MyView_morefontsize, 18);
        int morefontcolor = typedArray.getColor(R.styleable.MyView_backfontcolor, Color.GREEN);
        int morebg = typedArray.getColor(R.styleable.MyView_morebg, Color.BLUE);
        //赋值
        title.setText(titlecontent); title.setTextSize(titlefontsize);
        title.setTextColor(titlefontcolor); title.setBackgroundColor(titlebg);

        back.setText(backcontent);back.setTextSize(backfontsize);
        back.setTextColor(backfontcolor);back.setBackgroundColor(backbg);

        more.setText(morecontent); more.setTextSize(morefontsize);
        more.setTextColor(morefontcolor); more.setBackgroundColor(morebg);
        //返回监听
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickLener!=null){
                    onClickLener.getBack(view);
                }
            }
        });
        //更多监听
        more.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickLener!=null){
                    onClickLener.getMore(view);
                }
            }
        });


    }
    //接口
    public interface onClickLener{
        void getBack(View view);
        void getMore(View view);
    }


}
