package com.sptpc.app.androidnetjson.net;

/**
 * Created by wwb on 2018/4/3.
 */
public interface HttpCallBackListener {
    void onFinish(String response);
    void onError(Exception e);
}
