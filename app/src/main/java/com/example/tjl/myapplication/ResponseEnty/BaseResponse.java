package com.example.tjl.myapplication.ResponseEnty;

import java.io.Serializable;

/**
 * Created by Tjl on 2016/4/21.
 */
public class BaseResponse implements Serializable{

    private String rsp_code;
    private String rsp_msg;

    public String getRsp_code() {
        return rsp_code;
    }

    public void setRsp_code(String rsp_code) {
        this.rsp_code = rsp_code;
    }

    public String getRsp_msg() {
        return rsp_msg;
    }

    public void setRsp_msg(String rsp_msg) {
        this.rsp_msg = rsp_msg;
    }
}
