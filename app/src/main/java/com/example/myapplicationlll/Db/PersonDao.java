package com.example.myapplicationlll.Db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplicationlll.model.Person;

import java.util.List;

//Data Access Object
@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertPerson(Person person);
    @Query("select * from Person")
    public List<Person>getPersons();
    @Delete
    public void deletePerson(Person person);
}
