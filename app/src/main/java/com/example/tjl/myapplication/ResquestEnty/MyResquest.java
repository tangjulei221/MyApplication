package com.example.tjl.myapplication.ResquestEnty;

import java.io.Serializable;

/**
 * Created by Tjl on 2016/4/21.
 */
public class MyResquest implements Serializable {

    public  String version;
    public String service_type;
    public String sign;

    public MyResquest() {
        this.version = "1.2.4";
        this.service_type = "Interface.version";
    }
}
