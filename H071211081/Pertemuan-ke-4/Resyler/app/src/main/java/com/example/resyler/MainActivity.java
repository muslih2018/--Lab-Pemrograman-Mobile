package com.example.resyler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager recyclerViewLayoutManager;
ArrayList<itemModel>data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hiding the title bar

        getSupportActionBar().hide();
        recyclerView=findViewById(R.id.RecyclerView2);
        recyclerView.setHasFixedSize(true);

        recyclerViewLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
//        dekorasi gari di masing masing item
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        data=new ArrayList<>();
        for(int i=0;i<myitem.nama.length;i++){
            data.add(new itemModel(
                    myitem.nama[i],
                    myitem.nomortelepon[i],
                    myitem.gambar[i]));
        }
        adapter=new Adapter(this,data);
        recyclerView.setAdapter(adapter);

    }
}