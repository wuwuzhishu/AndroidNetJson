package com.sptpc.app.androidnetjson.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wwb on 2018/4/3.
 */
public class HttpUtil {
    public static void sendHttpRequest(final String address, final HttpCallBackListener httpCallBackListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);//创建URL对象，传入网络地址
                    connection = (HttpURLConnection) url.openConnection();//打开连接
                    connection.setRequestMethod("GET");//设置连接请求的方法：GET或POST
                    connection.setConnectTimeout(8000);//设置连接超时的毫秒数
                    connection.setReadTimeout(8000);//设置读取超时的毫秒数
//                    connection.setDoInput(true);
//                    connection.setDoOutput(true);
                    InputStream in = connection.getInputStream();//获取服务器返回的输入流
                    //对输入流进行读取
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    if (httpCallBackListener != null){
                        httpCallBackListener.onFinish(response.toString());
                    }
                }catch (Exception e){
                    if(httpCallBackListener != null){
                        httpCallBackListener.onError(e);
                    }
                }finally {
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
}
