package com.sptpc.app.androidnetjson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import com.sptpc.app.androidnetjson.R;
import com.sptpc.app.androidnetjson.model.Subject2Child;
import com.sptpc.app.androidnetjson.model.Subject2Group;

import java.util.List;

/**
 * Created by wwb on 2018/4/9.
 */
public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Subject2Group> groupList;
    private List<List<Subject2Child>> childrenList;

    public ExpandableListViewAdapter(Context context, List<Subject2Group> groupList, List<List<Subject2Child>> childrenList) {
        this.context = context;
        this.groupList = groupList;
        this.childrenList = childrenList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childrenList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childrenList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Subject2Group subject2Group = groupList.get(groupPosition);
        View view;
        ViewHolderGroup viewHolderGroup;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.subject2_item_group,null);
            viewHolderGroup = new ViewHolderGroup();
            viewHolderGroup.groupText = (TextView) view.findViewById(R.id.group_text);
            view.setTag(viewHolderGroup);
        }else{
            view = convertView;
            viewHolderGroup = (ViewHolderGroup) view.getTag();
        }
        viewHolderGroup.groupText.setText(subject2Group.getName());
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Subject2Child subject2Child = childrenList.get(groupPosition).get(childPosition);
        View view;
        ViewHolderChild viewHolderChild;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.subject2_item_child,null);
            viewHolderChild = new ViewHolderChild();
            viewHolderChild.childID = (TextView) view.findViewById(R.id.child_id);
            viewHolderChild.childTime = (TextView) view.findViewById(R.id.child_time);
            viewHolderChild.childDistance = (TextView) view.findViewById(R.id.child_distance);
            view.setTag(viewHolderChild);
        }else{
            view = convertView;
            viewHolderChild = (ViewHolderChild) view.getTag();
        }
        viewHolderChild.childID.setText(subject2Child.getId());
        viewHolderChild.childTime.setText(subject2Child.getTime());
        viewHolderChild.childDistance.setText(subject2Child.getDistance());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolderGroup{
        TextView groupText;
    }
    class ViewHolderChild{
        TextView childID;
        TextView childTime;
        TextView childDistance;
    }
}
