package com.tickks.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.tickks.R;
import com.tickks.data.Fact;
import com.tickks.factory.ColorFactory;
import com.tickks.factory.FactFactory;
import com.tickks.network.FunFactsService;
import com.tickks.network.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

  FactFactory factFactory;
  ColorFactory colorFactory = new ColorFactory();

  TextView factText;
  Button showAnotherFactButton;
  private ConstraintLayout mainView;
  Button showAllFacts;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    factFactory = new FactFactory(this);

    factText = findViewById(R.id.fun_fact_view);
    mainView = findViewById(R.id.main_layout);
    showAnotherFactButton = findViewById(R.id.show_another_fact);
    showAllFacts = findViewById(R.id.show_all);


    showAnotherFactButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        changeFact();
      }
    });

    showAllFacts.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, AllFactActivity.class);
        startActivity(intent);
      }
    });

    getFunFactFromInternet();

  }

  private void getFunFactFromInternet() {
    Retrofit retrofit = RetrofitBuilder.retrofit;

    FunFactsService funFacts = retrofit.create(FunFactsService.class);

    funFacts.getAllFacts().enqueue(new Callback<List<Fact>>() {
      @Override
      public void onResponse(Call<List<Fact>> call, Response<List<Fact>> response) {
        if (response.isSuccessful()) {
          List<Fact> factList = response.body();
          factFactory.addFactList(factList);
          Toast.makeText(MainActivity.this, "List updated", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(MainActivity.this, "Please check your request or server", Toast.LENGTH_SHORT).show();
        }
      }

      @Override
      public void onFailure(Call<List<Fact>> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void changeFact() {
    String randomFact = factFactory.getFact();
    String randomColor = colorFactory.getColor();
    int color = Color.parseColor(randomColor);
    factText.setText(randomFact);
    mainView.setBackgroundColor(color);
    showAnotherFactButton.setTextColor(color);
  }

}
