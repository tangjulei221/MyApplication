package com.example.tjl.myapplication.asynktask;

import android.annotation.TargetApi;
import android.database.CursorJoiner;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;

import com.example.tjl.myapplication.ResquestEnty.MyResquest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tjl on 2016/4/21.
 */
@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class MyAsynkTask<Params,Progress,Result> extends AsyncTask<Params,Progress,Result> {


    @Override
    protected Result doInBackground(Params... params) {
            //获取excute传过来的数据
            MyResquest myResquest = (MyResquest) params[0];
            List<BasicNameValuePair> paramsList = new ArrayList<>();
            paramsList.add(new BasicNameValuePair("version",myResquest.version));
            paramsList.add(new BasicNameValuePair("service_type",myResquest.service_type));
        //开始执行网络访问操作
        doPostMessage(null);
        return null;
    }

    private void doPostMessage(String tag) {
        //创建一个流对象
        InputStream inputStream = null;
        //使用HttpPost
        HttpPost request = new HttpPost("http://weixin.xianhuahua.com/app/interface/xianhuahua");
        request.addHeader("Accept-Encoding", "gzip");
        //对tag进行判断
        if (TextUtils.isEmpty(tag)){
            request.addHeader("If-None-Match", tag);
        }
        //开始使用HttpClient进行操作。
        HttpClient HttpClient = new HttpClient();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //该方法是在准备是调用
    }

    @Override
    protected void onPostExecute(Result result) {
        super.onPostExecute(result);
        //该方法是在线程结束时，调用
    }
}
