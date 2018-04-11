package com.sptpc.app.androidnetjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sptpc.app.androidnetjson.model.Subject2Child;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this,ZhihuActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this,Subject2Activity.class));
                break;
        }
    }
}
