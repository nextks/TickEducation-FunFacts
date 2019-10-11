package com.tickks.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FactDAO {

  @Query("SELECT * FROM fact")
  List<Fact> getFacts();

  @Insert
  int saveFact(Fact fact);

  @Update
  void updateFact(Fact fact);

}
