package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class profil extends AppCompatActivity {
    int skor54;
    TextView nama,skorterbaik;
    Button play;
    ImageView profil2;
    Uri imageUri2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        //hiding the title bar
        getSupportActionBar().hide();
        nama=findViewById(R.id.nama);
        profil2=findViewById(R.id.profil2);
        skorterbaik=findViewById(R.id.skorterbaik);
        play=findViewById(R.id.play);
        String nama2=getIntent().getStringExtra("nama");
        nama.setText(nama2);
        imageUri2 = getIntent().getParcelableExtra("gambar");
        profil2.setImageURI(imageUri2);
        Bundle l = this.getIntent().getExtras();
        skor54 = l.getInt("skor52");
        String skotrterbaik100 = Integer.toString(skor54);
        skorterbaik.setText(skotrterbaik100);


        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                intent.putExtra("nama",nama2 );
                intent.putExtra("gambar",imageUri2);
                Bundle b = new Bundle();
                b.putInt("skor52", skor54);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

        });
    }


}