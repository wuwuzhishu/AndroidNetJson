package com.sptpc.app.androidnetjson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.sptpc.app.androidnetjson.adapter.NewsAdapter;
import com.sptpc.app.androidnetjson.model.News;
import com.sptpc.app.androidnetjson.net.HttpCallBackListener;
import com.sptpc.app.androidnetjson.net.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ZhihuActivity extends AppCompatActivity {
    private Button button;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();

    private List<News> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu);

        button = (Button) findViewById(R.id.button);

        listView = (ListView)findViewById(R.id.listview);
//        adapter = new ArrayAdapter<>(ZhihuActivity.this,android.R.layout.simple_list_item_1,dataList);
//        listView.setAdapter(adapter);
        newsAdapter = new NewsAdapter(this,R.layout.list_item_news,newsList);
        listView.setAdapter(newsAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str = "https://news-at.zhihu.com/api/4/news/latest";

                HttpUtil.sendHttpRequest(str, new HttpCallBackListener() {
                    @Override
                    public void onFinish(String response) {
                        dataList.clear();
                        newsList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("stories");
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject storyJsonObject = jsonArray.getJSONObject(i);
                                String title = storyJsonObject.getString("title");
                                dataList.add(title);
                                JSONArray imgJsonArray =  storyJsonObject.getJSONArray("images");
                                String imgUrl = (String)imgJsonArray.get(0);
                                dataList.add(imgUrl);
//                                Bitmap bitmap = BitmapFactory.decodeFile(imgUrl);
                                Bitmap bitmap = BitmapFactory.decodeStream(new URL(imgUrl).openStream());
                                News news = new News();
                                news.setImageBitmap(bitmap);
//                                news.setImageID(R.mipmap.ic_launcher);
                                news.setTitle(title);
                                newsList.add(news);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                adapter.notifyDataSetChanged();
                                newsAdapter.notifyDataSetChanged();
//                                button.setText("测试");
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.i("----------------","error");
                    }
                });
            }
        });
    }
}
