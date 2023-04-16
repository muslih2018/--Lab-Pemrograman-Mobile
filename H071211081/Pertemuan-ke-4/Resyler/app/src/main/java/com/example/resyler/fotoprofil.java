package com.example.resyler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class fotoprofil extends AppCompatActivity {
    ImageView gambar2,back;
    TextView nama2,nomortelpon;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotoprofil);
        gambar2=findViewById(R.id.gambar2);
        nama2=findViewById(R.id.nama2);
        back=findViewById(R.id.back);
        nomortelpon=findViewById(R.id.nomortelpon);
        Intent intent=getIntent();
        int gambarprofil=intent.getIntExtra("GAMBAR_DEFAULT",0);
        String namakontak=intent.getStringExtra("TEXT_DEFAULT");
        String nomorDefault=intent.getStringExtra("NOMOR_DEFAULT");

        gambar2.setImageResource(gambarprofil);
        nama2.setText(namakontak);
        nomortelpon.setText(nomorDefault);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                intent.putExtra("TEXT_DEFAULT",namakontak);
                intent.putExtra("GAMBAR_DEFAULT",gambarprofil);
                intent.putExtra("NOMOR_DEFAULT",nomorDefault);
                startActivity(intent);
            }
        });

    }
}