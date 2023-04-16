package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    ImageView pop,profil;
    TextView Namalengkap,Username,desk;
    Uri imageUri2;
    Uri imageUri4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //hiding the title bar
        getSupportActionBar().hide();
        pop = findViewById(R.id.pop);
        desk = findViewById(R.id.desk);
        profil= findViewById(R.id.profil);
        Namalengkap= findViewById(R.id.Namalengkap);
        Username= findViewById(R.id.Username);
        Namalengkap.setText(getIntent().getStringExtra("namalengkap"));
        Username.setText(getIntent().getStringExtra("username"));
        desk.setText(getIntent().getStringExtra("desk"));
        imageUri2 = getIntent().getParcelableExtra("gambar");
        profil.setImageURI(imageUri2);
        imageUri4 = getIntent().getParcelableExtra("gambar4");
        pop.setImageURI(imageUri4);
    }
}