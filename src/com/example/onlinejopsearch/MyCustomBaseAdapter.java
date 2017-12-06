package com.example.onlinejopsearch;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
public class MyCustomBaseAdapter extends BaseAdapter {
    private static ArrayList<String[]> searchArrayList;
    private LayoutInflater mInflater;
    public MyCustomBaseAdapter(Context context, ArrayList<String[]> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }
    public int getCount() {
        return searchArrayList.size();
    }
    public Object getItem(int position) {
        return searchArrayList.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.applyjop, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.textView1);
            holder.txtCityState = (TextView) convertView
                    .findViewById(R.id.textView2);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.textView3);
            holder.t = (TextView) convertView.findViewById(R.id.textView4);
            holder.tt = (TextView) convertView.findViewById(R.id.textView5);
            holder.ttt = (TextView) convertView.findViewById(R.id.textView6);
            holder.tttt = (TextView) convertView.findViewById(R.id.textView7);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String []s=searchArrayList.get(position);
        holder.txtName.setText(s[0]);
        holder.txtCityState.setText(s[3]); 
        holder.txtPhone.setText(s[6]); 
        holder.t.setText(s[1]);
        holder.tt.setText(s[2]);
        holder.ttt.setText(s[4]);
        holder.tttt.setText(s[5]);
        return convertView;
    }
    static class ViewHolder {
        TextView txtName;
        TextView txtCityState;
        TextView txtPhone;
        TextView t;
        TextView tt;
        TextView ttt;
        TextView tttt;
    }
}
