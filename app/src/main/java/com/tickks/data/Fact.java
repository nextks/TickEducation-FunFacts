package com.tickks.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fact")
public class Fact {

  public Fact() {
  }

  public Fact(String text) {
    this.text = text;
  }

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  private int id;
  @ColumnInfo(name = "fact_text")
  private String text;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
