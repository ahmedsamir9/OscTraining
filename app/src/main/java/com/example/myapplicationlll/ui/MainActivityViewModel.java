package com.example.myapplicationlll.ui;

import android.app.Application;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplicationlll.Db.AppDataBase;
import com.example.myapplicationlll.model.Person;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
   public MutableLiveData<List<Person>>persons = new MutableLiveData<>();
    private Context context;
    private  AppDataBase dataBase;
    public MainActivityViewModel(Context context ,String x) {
        this.context =context;
        dataBase = AppDataBase.getDatabase(context);
    }

    public void addPerson(Person person){
        Log.d("lol","add persons");
        dataBase.personOperations().insertPerson(person);
    }
    public void getPersons(){
        Log.d("lol","get persons");

        persons.setValue(dataBase.personOperations().getPersons());
    }
}
