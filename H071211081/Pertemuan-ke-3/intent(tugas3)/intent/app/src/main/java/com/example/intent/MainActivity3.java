package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.time.Instant;

public class MainActivity3 extends AppCompatActivity {
      Button upload;
      ImageView gambar3;
      Uri imageUri4;
    TextView lp;
    EditText deskripsi;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //hiding the title bar
        getSupportActionBar().hide();
        upload = findViewById(R.id.upload);
        deskripsi = findViewById(R.id.deskripsi);
        Praceable praceable = getIntent().getParcelableExtra("Praceable");
        String namalengkap=praceable.getNama();
        String username=praceable.getUsername();
        Intent intent=getIntent();
        Uri imageUri =intent.getParcelableExtra("gambar");

        gambar3 = findViewById(R.id.gambar3);
        gambar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageUri4==null){
                    Toast.makeText(MainActivity3.this,"Please pick a post photo first",Toast.LENGTH_SHORT).show();
                }
                else {
                    String desk = deskripsi.getText().toString();
                    Intent bukasatuw = new Intent(getApplicationContext(), MainActivity4.class);
                    bukasatuw.putExtra("gambar", imageUri);
                    bukasatuw.putExtra("gambar4", imageUri4);
                    bukasatuw.putExtra("namalengkap", namalengkap);
                    bukasatuw.putExtra("username", username);
                    bukasatuw.putExtra("desk", desk);
                    startActivity(bukasatuw);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && data!=null) {
            imageUri4 = data.getData();
            gambar3.setImageURI(imageUri4);

        }
    }
}
