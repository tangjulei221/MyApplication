package com.example.tjl.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public abstract class   BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAvailable();;
        initView();
        initData();
    }

    //定义抽象方法，用来填充布局，初始化控件，填充数据
    protected  abstract  void initAvailable();
    protected  abstract  void  initView();
    protected  abstract  void initData();

}
