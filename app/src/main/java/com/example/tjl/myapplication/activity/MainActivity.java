package com.example.tjl.myapplication.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tjl.myapplication.BaseActivity;
import com.example.tjl.myapplication.R;
import com.example.tjl.myapplication.ResquestEnty.MyResquest;
import com.example.tjl.myapplication.asynktask.MyAsynkTask;

public class MainActivity extends BaseActivity {

    private View btn;

        @Override
        protected void initAvailable() {
            //用于获取intent数据
        }

        @Override
        protected void initView() {
        setContentView(R.layout.activity_base);


        btn = (View) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始使用asynktask请求网络
            }
        });
    }

    @Override
    protected void initData() {
        //请求数据
        MyResquest myResquest = new MyResquest();
        MyAsynkTask myAsynkTask = new MyAsynkTask();
        myAsynkTask.execute(myResquest);
    }
}
