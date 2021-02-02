package com.example.myapplicationlll.Db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myapplicationlll.model.Person;
@Database(entities = {Person.class}, version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
   public abstract PersonDao personOperations();
    private static  AppDataBase INSTANCE;
    public static AppDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "Osc_Db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
