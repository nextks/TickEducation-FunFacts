package com.tickks.data;

import android.content.Context;

import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@androidx.room.Database(entities = {Fact.class}, version = 1)
public abstract class Database extends RoomDatabase {

  public abstract FactDAO factDao();


  private static Database INSTANCE;

  public static synchronized Database getDatabase(Context context) {
    if (INSTANCE == null) {
      synchronized (Object.class){
        INSTANCE = Room.
            databaseBuilder(context.getApplicationContext(),
                Database.class,
                "fun_fact_database")
            .allowMainThreadQueries()
            .build();
      }

    }
    return INSTANCE;
  }
}
