package com.sptpc.app.androidnetjson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sptpc.app.androidnetjson.R;
import com.sptpc.app.androidnetjson.model.News;

import java.util.List;

/**
 * Created by wwb on 2018/4/9.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private int resourceID;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        this.resourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        ViewHolder viewHolder;
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.textView = (TextView) view.findViewById(R.id.textView);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
//        viewHolder.imageView.setImageResource(news.getImageID());
        viewHolder.imageView.setImageBitmap(news.getImageBitmap());
        viewHolder.textView.setText(news.getTitle());
        return view;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
