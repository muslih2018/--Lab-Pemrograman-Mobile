package com.example.resyler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Formatter;

public class MainActivity3 extends AppCompatActivity {


    LinearLayout toprofil;
   //hitung/cek tombol add sudah di klik belum
    int cekadd=0;
    TextView nama2,chat2,waktu;
    ImageView profilorang,back,send;
    RecyclerView recyclerView;
    TextInputEditText pesanwa;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    ArrayList<chatModel>data;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        waktu
        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt = new Formatter();
        fmt.format("%tl:%tM", cal, cal);


        toprofil=findViewById(R.id.toprofil);
        profilorang=findViewById(R.id.profilorang);
        back=findViewById(R.id.back);
        nama2=findViewById(R.id.nama2);
        chat2=findViewById(R.id.chat2);
        waktu=findViewById(R.id.waktu);
        send=findViewById(R.id.send);
        pesanwa=findViewById(R.id.pesanwa);
        String pesan=pesanwa.getText().toString();
        //tagkap user input

//        Intent
        Intent intent=getIntent();
        int gambarprofil=intent.getIntExtra("GAMBAR_DEFAULT",0);
        String namakontak=intent.getStringExtra("TEXT_DEFAULT");
        String nomorDefault=intent.getStringExtra("NOMOR_DEFAULT");
        recyclerView=findViewById(R.id.RecyclerView3);
        recyclerView.setHasFixedSize(true);
//array dari sebelah
        String orang = getIntent().getStringExtra("hilter");
        System.out.println(orang);

        recyclerViewLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

//        chat soekarno
        ArrayList<String> Headline = new ArrayList<>();
        Headline.add("Apa kabar?");
        Headline.add("okelah");
        Headline.add("Yeah");
        ArrayList<String> Subheadline = new ArrayList<>();
        Subheadline.add("07:03");
        Subheadline.add("07:40");
        Subheadline.add("07:50");


        //        chat hilter
        ArrayList<String> Headline1 = new ArrayList<>();
        Headline1.add("maksud mu");
        Headline1.add("kau siapa?");
        Headline1.add("wardek");
        ArrayList<String> Subheadline1 = new ArrayList<>();
        Subheadline1.add("09:03");
        Subheadline1.add("09:40");
        Subheadline1.add("09:50");

        //        chat nazi
        ArrayList<String> Headline2 = new ArrayList<>();
        Headline2.add("gas open war?");
        Headline2.add("lu dimna");
        Headline2.add("nok nok");
        ArrayList<String> Subheadline2 = new ArrayList<>();
        Subheadline2.add("17:03");
        Subheadline2.add("17:40");
        Subheadline2.add("17:50");

        //        chat arga
        ArrayList<String> Headline3 = new ArrayList<>();
        Headline3.add("lol");
        Headline3.add("dasar women");
        Headline3.add("awok2");
        ArrayList<String> Subheadline3 = new ArrayList<>();
        Subheadline3.add("00:03");
        Subheadline3.add("00:40");
        Subheadline3.add("00:50");
        //        chat taufiq
        ArrayList<String> Headline4 = new ArrayList<>();
        Headline4.add("Apa kabar bro?");
        Headline4.add("gas asitensi");
        Headline4.add("gas?");
        ArrayList<String> Subheadline4 = new ArrayList<>();
        Subheadline4.add("18:03");
        Subheadline4.add("18:40");
        Subheadline4.add("18:50");
        //        chat salim
        ArrayList<String> Headline5 = new ArrayList<>();
        Headline5.add("gas main basket?");
        Headline5.add("sebentar malam");
        Headline5.add("Yeah");
        ArrayList<String> Subheadline5 = new ArrayList<>();
        Subheadline5.add("09:03");
        Subheadline5.add("09:40");
        Subheadline5.add("09:50");
        //        chat aqid
        ArrayList<String> Headline6 = new ArrayList<>();
        Headline6.add("ke himpunan ko?");
        Headline6.add("nitip minum");
        Headline6.add("wkwk");
        ArrayList<String> Subheadline6 = new ArrayList<>();
        Subheadline6.add("07:03");
        Subheadline6.add("07:40");
        Subheadline6.add("07:50");
        //        chat juwanda
        ArrayList<String> Headline7 = new ArrayList<>();
        Headline7.add("gas renang sebentar?");
        Headline7.add("mau tidak");
        Headline7.add("deh cueknya");
        ArrayList<String> Subheadline7 = new ArrayList<>();
        Subheadline7.add("05:03");
        Subheadline7.add("05:40");
        Subheadline7.add("05:50");











        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        data=new ArrayList<>();
        for(int i=0;i<Headline.size();i++){
            ///untuk kondisi chat orang
            if(namakontak.equalsIgnoreCase("hilter")){
            data.add(new chatModel(
                    Headline.get(i),
                    Subheadline.get(i)));}
            else if(namakontak.equalsIgnoreCase("soekarno")){
                data.add(new chatModel(
                        Headline1.get(i),
                        Subheadline1.get(i)));}
            else if(namakontak.equalsIgnoreCase("Nazi")){
                data.add(new chatModel(
                        Headline2.get(i),
                        Subheadline2.get(i)));}
            else if(namakontak.equalsIgnoreCase("Arga")){
                data.add(new chatModel(
                        Headline3.get(i),
                        Subheadline3.get(i)));}
            else if(namakontak.equalsIgnoreCase("Tafufiq")){
                data.add(new chatModel(
                        Headline4.get(i),
                        Subheadline4.get(i)));}
            else if(namakontak.equalsIgnoreCase("Salim")){
                data.add(new chatModel(
                        Headline5.get(i),
                        Subheadline5.get(i)));}
            else if(namakontak.equalsIgnoreCase("Aqid")){
                data.add(new chatModel(
                        Headline6.get(i),
                        Subheadline.get(i)));}
            else if(namakontak.equalsIgnoreCase("Juwanda")){
                data.add(new chatModel(
                        Headline7.get(i),
                        Subheadline.get(i)));}

        }

        recyclerViewAdapter=new AdapterRecyclerView(data);
        recyclerView.setAdapter(recyclerViewAdapter);




///recyclerView



        profilorang.setImageResource(gambarprofil);
        nama2.setText(namakontak);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        Formatter finalFmt = fmt;
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String str = pesanwa.getText().toString();
                //nambah chat
                if(namakontak.equalsIgnoreCase("hilter")){
                Headline.add(str);
                Subheadline.add(String.valueOf(finalFmt));}
                if(namakontak.equalsIgnoreCase("soekarno")){
                    Headline1.add(str);
                    Subheadline1.add(String.valueOf(finalFmt));}
                else if(namakontak.equalsIgnoreCase("Nazi")){
                    Headline2.add(str);
                    Subheadline2.add(String.valueOf(finalFmt));}
                else if(namakontak.equalsIgnoreCase("Arga")){
                    Headline3.add(str);
                    Subheadline3.add(String.valueOf(finalFmt));}
                else if(namakontak.equalsIgnoreCase("Tafufiq")){
                    Headline4.add(str);
                    Subheadline4.add(String.valueOf(finalFmt));}
                else if(namakontak.equalsIgnoreCase("Salim")){
                    Headline5.add(str);
                    Subheadline5.add(String.valueOf(finalFmt));}
                else if(namakontak.equalsIgnoreCase("Aqid")){
                    Headline6.add(str);
                    Subheadline6.add(String.valueOf(finalFmt));}
                else if(namakontak.equalsIgnoreCase("Juwanda")){
                    Headline7.add(str);
                    Subheadline7.add(String.valueOf(finalFmt));}
                recyclerView=findViewById(R.id.RecyclerView3);
                recyclerView.setHasFixedSize(true);
//array dari sebelah
                recyclerViewLayoutManager=new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(recyclerViewLayoutManager);
                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

                data=new ArrayList<>();

                    ///untuk kondisi chat orang
                    if(namakontak.equalsIgnoreCase("hilter")){
                        for(int i=0;i<Headline.size();i++){
                        data.add(new chatModel(
                                Headline.get(i),
                                Subheadline.get(i)));}}
                    else if(namakontak.equalsIgnoreCase("soekarno")){
                        for(int i=0;i<Headline1.size();i++){
                        data.add(new chatModel(
                                Headline1.get(i),
                                Subheadline1.get(i)));}}
                    else if(namakontak.equalsIgnoreCase("Nazi")){
                        for(int i=0;i<Headline2.size();i++){
                        data.add(new chatModel(
                                Headline2.get(i),
                                Subheadline2.get(i)));}}
                    else if(namakontak.equalsIgnoreCase("Arga")){
                        for(int i=0;i<Headline3.size();i++){
                        data.add(new chatModel(
                                Headline3.get(i),
                                Subheadline3.get(i)));}}
                    else if(namakontak.equalsIgnoreCase("Tafufiq")){
                        for(int i=0;i<Headline4.size();i++){
                        data.add(new chatModel(
                                Headline4.get(i),
                                Subheadline4.get(i)));}}
                    else if(namakontak.equalsIgnoreCase("Salim")){
                        for(int i=0;i<Headline5.size();i++){
                        data.add(new chatModel(
                                Headline5.get(i),
                                Subheadline5.get(i)));}}
                    else if(namakontak.equalsIgnoreCase("Aqid")){
                        for(int i=0;i<Headline7.size();i++){
                        data.add(new chatModel(
                                Headline6.get(i),
                                Subheadline.get(i)));}}
                    else if(namakontak.equalsIgnoreCase("Juwanda")){
                        for(int i=0;i<Headline1.size();i++){
                        data.add(new chatModel(
                                Headline7.get(i),
                                Subheadline.get(i)));}}
                recyclerViewAdapter=new AdapterRecyclerView(data);
                recyclerView.setAdapter(recyclerViewAdapter);
                }
        });
        toprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),fotoprofil.class);
                intent.putExtra("TEXT_DEFAULT",namakontak);
                intent.putExtra("GAMBAR_DEFAULT",gambarprofil);
                intent.putExtra("NOMOR_DEFAULT",nomorDefault);

                startActivity(intent);
            }
        });



    }


}