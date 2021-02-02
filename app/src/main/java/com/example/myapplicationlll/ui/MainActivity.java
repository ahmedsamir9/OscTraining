package com.example.myapplicationlll.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicationlll.Db.AppDataBase;
import com.example.myapplicationlll.R;
import com.example.myapplicationlll.databinding.ActivityMainBinding;
import com.example.myapplicationlll.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ItemAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    MainActivityViewModel mainActivityViewModel;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        ViewModelFactory factory = new ViewModelFactory(this);
        mainActivityViewModel = new ViewModelProvider(this,factory).get(MainActivityViewModel.class);
        mainActivityViewModel.getPersons();
        initView();
        onClick();
        subscribeToLiveData();
    }
    void subscribeToLiveData(){
        mainActivityViewModel.persons.observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                adapter.setNewPersons(people);
            }
        });
    }
    void initView(){
        adapter = new ItemAdapter(new ArrayList<>());
        adapter.setOnSelectItem(new ItemAdapter.OnSelectItem() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this,"Position on List "+position,Toast.LENGTH_LONG).show();
            }
        });
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        activityMainBinding.itemRecyclerView.setAdapter(adapter);
        activityMainBinding.itemRecyclerView.setLayoutManager(layoutManager);
    }
    public void onClick(){
        activityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = activityMainBinding.nameFeiled.getText().toString();
                String attendance = activityMainBinding.attendanceFeiled.getText().toString();
                Person person =new Person(name,Integer.parseInt(attendance));
                Toast.makeText(MainActivity.this,"LOL team ",Toast.LENGTH_SHORT).show();
                adapter.addNewPerson(person);
                mainActivityViewModel.addPerson(person);
            }
        });
    }
}
