package com.example.tjl.myapplication.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tjl on 2016/4/26.
 */
public class MyView extends View {

    public MyView(Context context) {
        super(context);
        //直接在android工程中引用
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //直接在xml中使用
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureWidth(heightMeasureSpec));
    }

    private int  measureWidth(int measureSpec){
        //用于指定默认情况下：wr的时候，会有一个默认的大小
        int result = 0 ;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode){
            case MeasureSpec.EXACTLY:
                //测量的大小就是该自定义view的大小，即：在xml中声明的大小
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
                result = 200;
                result = Math.min(result,specSize);
                break;
            case MeasureSpec.UNSPECIFIED:
                result = 200;
                break;
        }
        return result;
    }

    //自定义控件过程中，先measuer再绘制onDraw（）


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
