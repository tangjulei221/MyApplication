package com.example.tjl.myapplication.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.example.tjl.myapplication.R;

/**
 * Created by Tjl on 2016/4/27.
 */
public class MyMoveView extends View {
    int lastX = 0;
    int lastY = 0;
    Scroller Scroller;
    Context context ;

    public MyMoveView(Context context) {
        super(context);
    }

    public MyMoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();

    }

    private void initView() {
        Scroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureWidth(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        float result = 0;
        //获取到测量模式
        int mode = MeasureSpec.getMode(measureSpec);
        //获取测量大小/测量值
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.AT_MOST:
                //说明是wr
                result = getResources().getDisplayMetrics().density * 50;
                result = Math.min(result, size);
                break;
            case MeasureSpec.EXACTLY:
                //说明是ma或者是明确的数字
                result = size;
                break;
        }
        return (int) result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //在调用super之前对cancas进行设置
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.black));
        paint.setAntiAlias(true);

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
        super.onDraw(canvas);
    }

    public MyMoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //下面开始对其进行滑动操作
    //重写view的onTouchEvent方法

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();


        //重写 里面的方法
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录下坐标的位置
                lastX = x;
                lastY = y;

                break;

            case MotionEvent.ACTION_MOVE:
                //就算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                //对控件进行评议的第二种方式
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
                //重新设定处置坐标

//                lastX = x;
//                lastY = y;
                //对控件移动的第三种方式：
//                CoordinatorLayout.LayoutParams layout = (CoordinatorLayout.LayoutParams) getLayoutParams();
//                layout.leftMargin = getLeft() + offsetX;
//                layout.topMargin = getTop() + offsetY;
//                setLayoutParams(layout);
                //对控件移动的第四种方式;
//                ((View)getParent()).scrollBy(-offsetX,-offsetY);

                //对控件移动的第五种方式：使用Scroller
                //对滑动过程是否完成进行判断
//                if (Scroller.computeScrollOffset()){
//                    ((View)getParent()).scrollTo(Scroller.getCurrX(),Scroller.getCurrY());
//                    invalidate();
//                }
//                Scroller.startScroll();

                View parent = (View) getParent();
                Scroller.startScroll(parent.getScrollX(),parent.getScrollY(),-offsetX,-offsetY,1000);
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (Scroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(Scroller.getCurrX(),Scroller.getCurrY());
            invalidate();
        }
    }
}
