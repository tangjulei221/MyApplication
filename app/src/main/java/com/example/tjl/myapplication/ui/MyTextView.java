package com.example.tjl.myapplication.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Tjl on 2016/4/26.
 */
public class MyTextView extends TextView {
    private Paint mPaint1 ;
    private Paint mPaint2;

    /**
     * 带有背景和边框的TextView
     * @param context
     */
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint2 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style
        .FILL);

        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    //开始使用onDraw方法进行绘制


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        //对外层进行绘制
        canvas.drawRect(5,5,getMeasuredWidth()-5,getMeasuredHeight()-5,mPaint2);
        canvas.save();
//        canvas.translate(10,0);
        super.onDraw(canvas);//调用父类的绘制方法之前，使用canvans进行绘制
    }
}
