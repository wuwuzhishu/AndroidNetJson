package com.sptpc.app.androidnetjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.sptpc.app.androidnetjson.adapter.ExpandableListViewAdapter;
import com.sptpc.app.androidnetjson.model.Subject2Child;
import com.sptpc.app.androidnetjson.model.Subject2Group;

import java.util.ArrayList;
import java.util.List;

public class Subject2Activity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private List<Subject2Group> groupList;
    private List<List<Subject2Child>> childrenList;
    private ExpandableListAdapter expandableListAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject2);

        getGroupData();
        getChildrenData();
        initView();

    }

    public void initView(){
        expandableListView = (ExpandableListView) findViewById(R.id.expand_list);
        expandableListAdapter = new ExpandableListViewAdapter(Subject2Activity.this,groupList,childrenList);
        expandableListView.setAdapter(expandableListAdapter);
//        expandableListView.setGroupIndicator(null);//不显示指示器

        //设置默认为展开状态
//        for (int i = 0; i < expandableListAdapter.getGroupCount(); i++) {
//            expandableListView.expandGroup(i);//
//        }
    }

    //得到父列表数据
    public void getGroupData(){
        groupList = new ArrayList<>();

        Subject2Group subject2Group = new Subject2Group("中医院站");
        groupList.add(subject2Group);
        subject2Group = new Subject2Group("联想大厦站");
        groupList.add(subject2Group);

    }

    //得到子列表数据
    public void getChildrenData(){
        childrenList = new ArrayList<>();

        List<Subject2Child> subject2ChildList1,subject2ChildList2;
        Subject2Child subject2Child1,subject2Child2;

        subject2ChildList1 = new ArrayList<>();
        subject2Child1 = new Subject2Child("1号","5分钟","100米");
        subject2ChildList1.add(subject2Child1);
        subject2Child1 = new Subject2Child("2号","6分钟","1000米");
        subject2ChildList1.add(subject2Child1);
        childrenList.add(subject2ChildList1);

        subject2ChildList2 = new ArrayList<>();
        subject2Child2 = new Subject2Child("1号","5分钟","300米");
        subject2ChildList2.add(subject2Child2);
        subject2Child2 = new Subject2Child("2号","7分钟","1200米");
        subject2ChildList2.add(subject2Child2);
        childrenList.add(subject2ChildList2);
    }
}
