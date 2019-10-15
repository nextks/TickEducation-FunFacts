package com.tickks.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FactDAO {

  @Query("SELECT * FROM fact")
  List<Fact> getFacts();

  @Insert
  void saveFact(Fact fact);

  @Insert
  void saveAllFact(List<Fact> facts);

  @Update
  void updateFact(Fact fact);

  @Delete
  void deleteFact(Fact fact);
}
