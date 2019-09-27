package com.tickks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AllFactActivity extends AppCompatActivity {

  FactFactory factFactory = new FactFactory();

  ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_all_fact);

    listView = findViewById(R.id.list_view);

    String[] facts = factFactory.faktet;

    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, facts);

    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AllFactActivity.this, "You have selected item: " + position, Toast.LENGTH_SHORT).show();
      }
    });


    FactAdapter ourAdapter = new FactAdapter(this,facts);
  }
}
