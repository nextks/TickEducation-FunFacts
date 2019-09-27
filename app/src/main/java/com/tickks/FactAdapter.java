package com.tickks;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FactAdapter extends BaseAdapter {

  private Activity activity;
  String[] list;

  public FactAdapter(Activity activity,String[] list) {
    this.activity = activity;
    this.list = list;
  }

  @Override
  public int getCount() {
    return list.length;
  }

  @Override
  public String getItem(int position) {
    return list[position];
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {



    return null;
  }
}
