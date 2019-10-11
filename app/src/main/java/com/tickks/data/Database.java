package com.tickks.data;

import androidx.room.RoomDatabase;


@androidx.room.Database(entities = {Fact.class}, version = 1)
public abstract class Database extends RoomDatabase {


}
