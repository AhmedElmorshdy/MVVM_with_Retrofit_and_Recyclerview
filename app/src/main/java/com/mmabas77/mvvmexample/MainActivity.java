package com.mmabas77.mvvmexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mmabas77.mvvmexample.UI.ModelViewModel;
import com.mmabas77.mvvmexample.pojo.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ModelAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Model>models;

    ModelViewModel modelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelViewModel = ViewModelProviders.of(this).get(ModelViewModel.class);

        recyclerView = findViewById(R.id.recy);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        modelViewModel = ViewModelProviders.of(this).get(ModelViewModel.class);
        modelViewModel.getData();

        modelViewModel.listMutableLiveData.observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                adapter = new ModelAdapter(models,MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });



    }





}