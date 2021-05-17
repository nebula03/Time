package com.example.capstone.group;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.capstone.bean.GroupListBean;

public class GroupListAdapter extends BaseAdapter {
    private Context context;
    private GroupListBean[] listBeans;
    public GroupListAdapter(Context context, GroupListBean[] listBeans) {
        this.context = context;
        this.listBeans = listBeans;

        Log.d("ListView", "GroupListBean[0] : " + listBeans[0].getName());
    }

    @Override
    public int getCount() {
        if(listBeans != null) return this.listBeans.length;
        else return -1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            GroupListElementView elementView;
            if(convertView == null) {
                elementView = new GroupListElementView(this.context);
            } else {
                elementView = (GroupListElementView) convertView;
            }
            Log.d("ListView", "넣으려는 데이터 index : " + position);
            Log.d("ListView", "넣으려는 데이터 name : " + listBeans[position].getName());
            elementView.setData(listBeans[position]);
            return elementView;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
