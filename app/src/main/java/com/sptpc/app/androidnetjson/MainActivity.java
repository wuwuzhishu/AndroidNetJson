package com.sptpc.app.androidnetjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.sptpc.app.androidnetjson.model.City;
import com.sptpc.app.androidnetjson.net.HttpCallBackListener;
import com.sptpc.app.androidnetjson.net.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ListView listView;
    private List<String> dataList = new ArrayList<>();
    private List<City> cityList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        listView = (ListView)findViewById(R.id.listview);
        adapter = new  ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str = "http://guolin.tech/api/china";

                HttpUtil.sendHttpRequest(str, new HttpCallBackListener() {
                    @Override
                    public void onFinish(String response) {
                        cityList.clear();
                        dataList.clear();
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++){
                                City city = new City();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                city.setID(jsonObject.getInt("id"));
                                city.setName(jsonObject.getString("name"));
                                cityList.add(city);
                            }

                            for (int i=0;i < cityList.size();i++){
                                dataList.add(cityList.get(i).getName());
                            }
//                            for(City c:cityList){
//                                dataList.add(c.getName());
//                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                                button.setText("测试");
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
