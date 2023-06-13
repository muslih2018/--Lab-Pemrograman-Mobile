package com.example.tugas_satu_bangun_ruang;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private View balok;
    private View kerucut;
    private View bola;

    EditText panjang,lebar,tinggi,tinggi_kerucut,jari_jarikerucut,jari_jaribola;
    Button button_hasil_balok,button_hasil_kerucut,button_hasil_bola;
    TextView hasil_text_kerucut,hasil_text_bola,hasil_text_balok;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//      spiner
        spinner = findViewById(R.id.spinner);
        bola = findViewById(R.id.bola);
        balok = findViewById(R.id.balok);
        kerucut = findViewById(R.id.kerucut);

        String[] daftarBangunRuang = {"Pilih Bangun Ruang","Balok", "Kerucut","bola"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daftarBangunRuang);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 1:
                        bola.setVisibility(View.GONE);
                        balok.setVisibility(View.VISIBLE);
                        kerucut.setVisibility(View.GONE);
                        break;
                    case 2:
                        bola.setVisibility(View.GONE);
                        balok.setVisibility(View.GONE);
                        kerucut.setVisibility(View.VISIBLE);
                        break;
                    case 3 :
                        bola.setVisibility(View.VISIBLE);
                        balok.setVisibility(View.GONE);
                        kerucut.setVisibility(View.GONE);
                        break;
                    default:
                        bola.setVisibility(View.GONE);
                        balok.setVisibility(View.GONE);
                        kerucut.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //      mesin balok
        panjang = findViewById(R.id.panjang);
        lebar = findViewById(R.id.lebar);
        tinggi = findViewById(R.id.tinggi);
        button_hasil_balok = findViewById(R.id.button_hasil_balok);
        hasil_text_balok= findViewById(R.id.hasil_text_balok);

        button_hasil_balok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(panjang.getText().toString().isEmpty()){
                    panjang.setError("Field ini tidak boleh kosong");
                }
                else if (lebar.getText().toString().isEmpty()) {
                    lebar.setError("Field ini tidak boleh kosong");
                }
                else if (tinggi.getText().toString().isEmpty()) {
                    tinggi.setError("Field ini tidak boleh kosong");
                }
                else {
                    double apanjang =Integer.valueOf(panjang.getText().toString());
                    double alebar =Integer.valueOf(lebar.getText().toString());
                    double atinggi =Integer.valueOf(tinggi.getText().toString());
                    double ahasil = apanjang * alebar * atinggi;
                    hasil_text_balok.setText(String.valueOf(String.format("%.2f",ahasil)));}

            }
        });
//      mesin kerucut
        jari_jarikerucut = findViewById(R.id.jari_jarikerucut);
        tinggi_kerucut = findViewById(R.id.tinggi_kerucut);
        button_hasil_kerucut = findViewById(R.id.button_hasil_kerucut);
        hasil_text_kerucut= findViewById(R.id.hasil_text_kerucut);

        button_hasil_kerucut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jari_jarikerucut.getText().toString().isEmpty()){
                    jari_jarikerucut.setError("Field ini tidak boleh kosong");
//                    Toast.makeText(MainActivity.this,"jari-jari masih kosong",Toast.LENGTH_SHORT).show();
                }
                else if(tinggi_kerucut.getText().toString().isEmpty()){
//                    Toast.makeText(MainActivity.this,"tinggi masih kosong",Toast.LENGTH_SHORT).show();
                    tinggi_kerucut.setError("Field ini tidak boleh kosong");
                }
                else{
                    double apanjang =Integer.valueOf(jari_jarikerucut.getText().toString());
                    double atinggi =Integer.valueOf(tinggi_kerucut.getText().toString());
                    double ahasil =  (Math.PI*Math.pow(apanjang,2)* atinggi)/3;
                    hasil_text_kerucut.setText(String.valueOf(String.format("%.2f",ahasil)));}

            }
        });



//      mesin bola V = (4/3) x π x r3


        jari_jaribola = findViewById(R.id.jari_jaribola);
        button_hasil_bola = findViewById(R.id.button_hasil_bola);
        hasil_text_bola= findViewById(R.id.hasil_text_bola);

        button_hasil_bola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jari_jaribola.getText().toString().isEmpty()){
                    jari_jaribola.setError("Field ini tidak boleh kosong");
                }
                else {
                    double jari_jari =Integer.valueOf(jari_jaribola.getText().toString());
                    double ahasil = 4*(Math.PI*Math.pow(jari_jari,3))/3;
                    hasil_text_bola.setText(String.valueOf(String.format("%.2f",ahasil)));}

            }
        });
    }
}

