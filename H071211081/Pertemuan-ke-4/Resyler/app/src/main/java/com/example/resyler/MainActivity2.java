package com.example.resyler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView nama2;
    ImageView gambar2,back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nama2=findViewById(R.id.nama2);
        gambar2=findViewById(R.id.gambar2);
        back=findViewById(R.id.back);

        Intent intent=getIntent();
        int gambarprofil=intent.getIntExtra("GAMBAR_DEFAULT",0);
        String namakontak=intent.getStringExtra("TEXT_DEFAULT");

        gambar2.setImageResource(gambarprofil);
        nama2.setText(namakontak);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}