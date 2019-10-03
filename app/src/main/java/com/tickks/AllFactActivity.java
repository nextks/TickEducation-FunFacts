package com.tickks;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class AllFactActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_all_fact);


    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager
        .beginTransaction()
        .add(R.id.main_layout,new AllFactFragment(), "ALL_FACTS")
        .commit();


  }
}
