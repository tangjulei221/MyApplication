package com.example.tjl.myapplication.ResponseEnty;

/**
 * Created by Tjl on 2016/4/21.
 */
public class UpdateResponse extends  BaseResponse {
    private String download_url;
    private String internal_ver;
    private String description;

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getInternal_ver() {
        return internal_ver;
    }

    public void setInternal_ver(String internal_ver) {
        this.internal_ver = internal_ver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
