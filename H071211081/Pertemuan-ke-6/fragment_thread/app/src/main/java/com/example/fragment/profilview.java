package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class profilview extends AppCompatActivity {
    ImageView imgpost2;
    TextView textcoba;
    ProgressBar progressBar;
    LinearLayout layoutprofil;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilview);
        imgpost2=findViewById(R.id.imgpost2);
        textcoba=findViewById(R.id.textcoba);
        progressBar=findViewById(R.id.progressBar);
        layoutprofil=findViewById(R.id.layoutprofil);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            try {
//simulate process in background thread
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(100);
                    int percentage = i * 10;
                    handler.post(() -> {
//update ui in main thread
                        if (percentage == 100) {
                            Intent intent = getIntent();
                            String imageUriString = intent.getStringExtra("imageUri");
                            Uri imageUri = Uri.parse(imageUriString);
                            String text = intent.getStringExtra("text");
                            imgpost2.setImageURI(imageUri);
                            textcoba.setText(text);
                            layoutprofil.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                        } else {
                            layoutprofil.setVisibility(View.GONE);
                            progressBar.setVisibility(View.VISIBLE);
                        }
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }

}