package com.example.myapplicationlll.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String name;
    @ColumnInfo
    int attadnace;
    public Person() {
    }

    @Ignore
    public Person(String name, int attadnace) {
        this.name = name;
        this.attadnace = attadnace;
    }
    @Ignore
    public Person(int id, String name, int attadnace) {
        this.id = id;
        this.name = name;
        this.attadnace = attadnace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttadnace() {
        return attadnace;
    }

    public void setAttadnace(int attadnace) {
        this.attadnace = attadnace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
