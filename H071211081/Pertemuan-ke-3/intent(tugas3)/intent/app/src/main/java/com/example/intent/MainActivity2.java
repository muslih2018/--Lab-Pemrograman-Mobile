package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {
    Button login;
    ImageView profil;
    TextInputEditText fullname,Username;

    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //hiding the title bar
        getSupportActionBar().hide();
        profil = findViewById(R.id.profil);
        fullname = findViewById(R.id.fullname);
        Username = findViewById(R.id.Username);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });


        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = fullname.getText().toString();
                char[] cArray = str.toCharArray();
                String str2 = Username.getText().toString();
                char[] cArray2 = str2.toCharArray();
                boolean hitungspasi=false;
                boolean hitungspasi2=false;
                int i;
                for (i = 0; i < cArray.length; i++) {

                    String namalengkap = String.valueOf(cArray[0]);
                    String namalengkap2 = String.valueOf(cArray[1]);
                    if(namalengkap.equalsIgnoreCase(" ")&&namalengkap==namalengkap2){
                        hitungspasi=true;
                        break;
                    }

                    }
                for (i = 0; i < cArray2.length; i++) {

                    String namalengkap = String.valueOf(cArray2[0]);
                    String namalengkap2 = String.valueOf(cArray2[1]);
                    if(namalengkap.equalsIgnoreCase(" ") && namalengkap2.equalsIgnoreCase(" ")){
                        hitungspasi2=true;
                        break;
                    }

                }
               if(fullname.getText().toString().isEmpty()){
                   fullname.setError("Field can't be empty");
               }
                else if(hitungspasi==true){
                   fullname.setError("Field can't be empty");
                }
               else if(imageUri==null){
                   Toast.makeText(MainActivity2.this,"Please pick a photo profile first",Toast.LENGTH_SHORT).show();
               }
               else if(Username.getText().toString().isEmpty()){
                   Username.setError("Field can't be empty");
               }
               else if(hitungspasi2==true){
                   fullname.setError("Field can't be empty");
               }  else {

                String Namalengkap=fullname.getText().toString();
                String Username2=Username.getText().toString();
                Praceable praceable = new Praceable( Namalengkap, Username2);
                Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                intent.putExtra("Praceable", praceable);
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