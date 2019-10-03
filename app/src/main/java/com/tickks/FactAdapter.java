package com.tickks;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FactAdapter extends BaseAdapter {

  private Activity activity;
  String[] list;
  ColorFactory colorFactory = new ColorFactory();
  String[] colors = colorFactory.colors;

  public FactAdapter(Activity activity, String[] list) {
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

  int indexImage;

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = LayoutInflater.from(activity).inflate(R.layout.fact_item, null);

    ImageView icon = view.findViewById(R.id.imageView);

    String fact = list[position];




    /*for (int i = 0; i < list.length; i++) {
      String c = colors[i];
      if()
    }*/

    int imageResource;

   /* if(position % 2 == 0){
      imageResource = R.drawable.ic_brightness_3_black_24dp;
    }else {
      imageResource = R.drawable.ic_directions_car_black_24dp;
    }*/

    int[] images = {R.drawable.ic_directions_car_black_24dp, R.drawable.ic_brightness_3_black_24dp};


    imageResource = images[indexImage];
    indexImage++;
    if (indexImage >= images.length) {
      indexImage = 0;

    }


    int index = position % colors.length;

    String color = colors[index];


    view.setBackgroundColor(Color.parseColor(color));

    TextView title = view.findViewById(R.id.fact_text);
    title.setText(fact);


    icon.setImageResource(imageResource);


    return view;
  }
}
