package com.example.grocerylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter{
    ArrayList<String> arrayList;
   LayoutInflater context;
    public CustomAdapter(LayoutInflater context, ArrayList<String> arrayList) {
     this.arrayList=arrayList;
     this.context=context;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      if(convertView == null){
          convertView = context.inflate(R.layout.list_row, null);
      }

        return view;
    }
}