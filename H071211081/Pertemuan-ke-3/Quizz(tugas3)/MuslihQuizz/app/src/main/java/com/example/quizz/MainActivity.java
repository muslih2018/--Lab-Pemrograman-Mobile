package com.example.quizz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button login;
    ImageView profil;
    TextInputEditText fullname;

    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hiding the title bar
        getSupportActionBar().hide();
        profil = findViewById(R.id.profil);
        login = findViewById(R.id.login);
        fullname = findViewById(R.id.fullname);

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     String Namalengkap=fullname.getText().toString();
                     if(Namalengkap.isEmpty()){
                        fullname.setError("Nama Tidak Boleh Kosong!");
                     }
                     else {
                     Intent intent = new Intent(getApplicationContext(),profil.class);
                     intent.putExtra("nama", Namalengkap);
                     intent.putExtra("gambar",imageUri);
                     startActivity(intent);}
        }

    });

}
    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && data!=null) {
            imageUri = data.getData();
            profil.setImageURI(imageUri);

        }
    }
}