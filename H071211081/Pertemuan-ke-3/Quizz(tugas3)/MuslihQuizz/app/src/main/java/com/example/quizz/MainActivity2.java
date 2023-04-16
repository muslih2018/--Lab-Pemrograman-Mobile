package com.example.quizz;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ImageView profil2;
    TextView nama,skor2,skorterbaik,newbestscore;
    public static final int TIMER=3000;
    Button login2;
    Uri imageUri2;
    LinearLayout skorbaruanimasi,skorbaruanimasistandar;
    int skorterbaik22=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the title bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main2);
        profil2=findViewById(R.id.profil2);
        nama=findViewById(R.id.nama);
        login2=findViewById(R.id.login2);
        skor2=findViewById(R.id.skor);
        skorterbaik=findViewById(R.id.skorterbaik);
        newbestscore=findViewById(R.id.newbestscore);
        skorbaruanimasi=findViewById(R.id.skorbaruanimasi);
        skorbaruanimasistandar=findViewById(R.id.skorbaruanimasistandar);
        Bundle b = this.getIntent().getExtras();
        int skor55=b.getInt("skor55");
        int skor54=b.getInt("skor54");

        if(skor54>skor55){
            skorterbaik22=skor54;
            skorbaruanimasi.setVisibility(View.GONE);
            skorbaruanimasistandar.setVisibility(View.VISIBLE);
        }
        else {
            skorbaruanimasistandar.setVisibility(View.GONE);
            skorterbaik22=skor55;
            newbestscore.setText("New Best Score : ");
            skorbaruanimasi.setVisibility(View.VISIBLE);
        }

        String str2 = Integer.toString(skor55);
        String str3 = Integer.toString(skorterbaik22);
        skorterbaik.setText(str3);
        skor2.setText(str2);
        String nama2=getIntent().getStringExtra("nama");
        nama.setText(nama2);
        imageUri2 = getIntent().getParcelableExtra("gambar");


        login2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),profil.class);
                intent.putExtra("nama",nama2 );
                intent.putExtra("gambar",imageUri2);
                Bundle b = new Bundle();
                b.putInt("skor52", skorterbaik22);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });


    }

}