package com.example.quizz;
import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
TextView soal,jumlah,a1,b1,c1,d1,a2,b2,c2,d2,a3,b3,c3,d3;

    public static final int TIMER=1500;
    int lp=1;
    int nmr1=0;
    int skor=0;
    int nmr2=0;
    int nmr3=0;
    int nmr4=0;
    int nmr5=0;

    int skor54;
    String nama2;
    Uri imageUri2;
    LinearLayout hilang;
    CardView abenar,asalah,bbenar,bsalah,cbenar,csalah,dbenar,dsalah;
CardView a,b,c,d;
    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //hiding the title bar
        getSupportActionBar().hide();

        soal = findViewById(R.id.soal);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        a1 = findViewById(R.id.a1);
        b1 = findViewById(R.id.b1);
        c1 = findViewById(R.id.c1);
        d1 = findViewById(R.id.d1);
        a2 = findViewById(R.id.a2);
        b2 = findViewById(R.id.b2);
        c2 = findViewById(R.id.c2);
        d2 = findViewById(R.id.d2);
        a3 = findViewById(R.id.a3);
        b3 = findViewById(R.id.b3);
        c3 = findViewById(R.id.c3);
        d3 = findViewById(R.id.d3);
        abenar = findViewById(R.id.abenar);
        asalah = findViewById(R.id.asalah);
        bbenar = findViewById(R.id.bbenar);
        bsalah = findViewById(R.id.bsalah);
        cbenar = findViewById(R.id.cbenar);
        csalah = findViewById(R.id.csalah);
        dbenar = findViewById(R.id.dbenar);
        dsalah = findViewById(R.id.dsalah);
        hilang = findViewById(R.id.hilang);
        jumlah = findViewById(R.id.jumlah);
        dataQuiz r = new dataQuiz();
        r.ambil();
        Bundle l = this.getIntent().getExtras();
        skor54 = l.getInt("skor52");
        //nama dan gambar dari profil ke actiity 2
        nama2=getIntent().getStringExtra("nama");
        imageUri2 = getIntent().getParcelableExtra("gambar");

    }


void reload(){

    int pertanyaan=8;
    double randomQuis=Math.random()*pertanyaan;
    dataQuiz r=new dataQuiz();
    r.ambil();
    String str2 = Integer.toString(lp);
    jumlah.setText(str2);

}

    public class dataQuiz {
        int pertanyaan=8;

        double randomQuis=Math.random()*pertanyaan;

        void  ambil(){

            List<DataAsset> list = new ArrayList<>();
            list.add(new DataAsset(1, "Apa ibu kota negara indonesia?", "Ambon", "Makassar", "London", "Jakarta"));
            list.add(new DataAsset(2, "Siapa Hokage ke 7 di anime naruto?", "Kakashi", "Naruto", "Saksuke", "Madara"));
            list.add(new DataAsset(3, "Apa ibukota dari negara Denmark?", "Veljle", "Odense", "Kopenhagen", "Randers"));
            list.add(new DataAsset(4, "Orang pertama yang pergi ke luar angkasa?", "Neil Armstrong", "Yuri Gagarin", "Edwin Buzz Aldrin", "Alan Shepard"));
            list.add(new DataAsset(5, "Siapa presiden pertama indonesia?", "Soekarna", "Eren", "Megawati", "Jokowi"));
            list.add(new DataAsset(6, "Yang pernah menjajah indonesia Kecuali?", "Belanda", "Inggris", "Amerika", "Jepang"));
            list.add(new DataAsset(7, "Gunung tertinggi di Indonesia?", "Gunung Bromo", "Gunung Ngga Pulu", "Gunung Rinjani", "Gunung Jaya"));
            list.add(new DataAsset(8, "Planet paling panas di Tata Surya kita?", "Mars", "Venus", "Pluto", "Merkurius"));

            if(lp<=5){
            if(randomQuis<=1 && nmr1<1){
                    for (DataAsset obj : list) {
                        if (obj.getID() == (1)) {
                            soal.setText(obj.getSoal());
                            a1.setText(obj.getA());
                            b1.setText(obj.getB());
                            c1.setText(obj.getC());
                            d1.setText(obj.getD());
                            a2.setText(obj.getA());
                            b2.setText(obj.getB());
                            c2.setText(obj.getC());
                            d2.setText(obj.getD());
                            a3.setText(obj.getA());
                            b3.setText(obj.getB());
                            c3.setText(obj.getC());
                            d3.setText(obj.getD());

                            d.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    dbenar.setVisibility(View.VISIBLE);
                                    new Handler().postDelayed(this::resetButton,TIMER);

                                }
                                private void resetButton(){
                                    lp = lp + 1;
                                    nmr1 = nmr1 + 1;
                                    skor = skor + 100;
                                    dbenar.setVisibility(View.GONE);
                                    reload();
                                }

                            });


                            b.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    bsalah.setVisibility(View.VISIBLE);
                                    new Handler().postDelayed(this::resetButton,TIMER);
                                }
                                private void resetButton(){
                                    lp = lp + 1;
                                    nmr1 = nmr1 + 1;
                                    bsalah.setVisibility(View.GONE);
                                    reload();
                                }

                            });
                            c.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    csalah.setVisibility(View.VISIBLE);
                                    new Handler().postDelayed(this::resetButton,TIMER);
                                }
                                private void resetButton(){
                                    lp = lp + 1;
                                    nmr1 = nmr1 + 1;
                                    csalah.setVisibility(View.GONE);
                                    reload();
                                }
                            });
                            a.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    asalah.setVisibility(View.VISIBLE);
                                    new Handler().postDelayed(this::resetButton,TIMER);
                                }
                                private void resetButton(){
                                    lp = lp + 1;
                                    nmr1 = nmr1 + 1;
                                    asalah.setVisibility(View.GONE);
                                    reload();
                                }
                            });


                    }
                }
            }
            else if(randomQuis>1 && randomQuis<=2 && nmr2<1) {
                for (DataAsset obj : list) {
                    if (obj.getID() == (2)) {
                        soal.setText(obj.getSoal());
                        a1.setText(obj.getA());
                        b1.setText(obj.getB());
                        c1.setText(obj.getC());
                        d1.setText(obj.getD());
                        a2.setText(obj.getA());
                        b2.setText(obj.getB());
                        c2.setText(obj.getC());
                        d2.setText(obj.getD());
                        a3.setText(obj.getA());
                        b3.setText(obj.getB());
                        c3.setText(obj.getC());
                        d3.setText(obj.getD());

                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                bbenar.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);

                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                skor = skor + 100;
                                bbenar.setVisibility(View.GONE);
                                reload();
                            }

                        });


                        a.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                asalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                asalah.setVisibility(View.GONE);
                                reload();
                            }

                        });
                        c.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                csalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                csalah.setVisibility(View.GONE);
                                reload();
                            }
                        });
                        d.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                dsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                dsalah.setVisibility(View.GONE);
                                reload();
                            }
                        });


                    }
                }
            }
            else if(randomQuis>2 && randomQuis<=3 && nmr3<1){
                for (DataAsset obj : list) {
                    if (obj.getID() == (3)) {
                        soal.setText(obj.getSoal());
                        soal.setText(obj.getSoal());
                        a1.setText(obj.getA());
                        b1.setText(obj.getB());
                        c1.setText(obj.getC());
                        d1.setText(obj.getD());
                        a2.setText(obj.getA());
                        b2.setText(obj.getB());
                        c2.setText(obj.getC());
                        d2.setText(obj.getD());
                        a3.setText(obj.getA());
                        b3.setText(obj.getB());
                        c3.setText(obj.getC());
                        d3.setText(obj.getD());

                        c.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                cbenar.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);

                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                skor = skor + 100;
                                cbenar.setVisibility(View.GONE);
                                reload();
                            }

                        });


                        b.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                bsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                bsalah.setVisibility(View.GONE);
                                reload();
                            }

                        });
                        a.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                asalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                asalah.setVisibility(View.GONE);
                                reload();
                            }
                        });
                        d.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                dsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                dsalah.setVisibility(View.GONE);
                                reload();
                            }
                        });


                    }
                }
            }
            else if(randomQuis >3 && randomQuis <=4 && nmr4<1) {
                for (DataAsset obj : list) {
                    if (obj.getID() == (4)) {
                        soal.setText(obj.getSoal());
                        soal.setText(obj.getSoal());
                        a1.setText(obj.getA());
                        b1.setText(obj.getB());
                        c1.setText(obj.getC());
                        d1.setText(obj.getD());
                        a2.setText(obj.getA());
                        b2.setText(obj.getB());
                        c2.setText(obj.getC());
                        d2.setText(obj.getD());
                        a3.setText(obj.getA());
                        b3.setText(obj.getB());
                        c3.setText(obj.getC());
                        d3.setText(obj.getD());

                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                bbenar.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);

                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                skor = skor + 100;
                                bbenar.setVisibility(View.GONE);
                                reload();
                            }

                        });


                        a.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                asalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                asalah.setVisibility(View.GONE);
                                reload();
                            }

                        });
                        c.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                csalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                csalah.setVisibility(View.GONE);
                                reload();
                            }
                        });
                        d.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                dsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                dsalah.setVisibility(View.GONE);
                                reload();
                            }
                        });


                    }
                }
            }
            else if(randomQuis >4 && randomQuis <=5 && nmr5<1) {
                for (DataAsset obj : list) {
                    if (obj.getID() == (5)) {
                        soal.setText(obj.getSoal());
                        a1.setText(obj.getA());
                        b1.setText(obj.getB());
                        c1.setText(obj.getC());
                        d1.setText(obj.getD());
                        a2.setText(obj.getA());
                        b2.setText(obj.getB());
                        c2.setText(obj.getC());
                        d2.setText(obj.getD());
                        a3.setText(obj.getA());
                        b3.setText(obj.getB());
                        c3.setText(obj.getC());
                        d3.setText(obj.getD());

                        a.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                abenar.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);

                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                skor = skor + 100;
                                abenar.setVisibility(View.GONE);
                                reload();
                            }

                        });


                        b.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                bsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                bsalah.setVisibility(View.GONE);
                                reload();
                            }

                        });
                        c.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                csalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                csalah.setVisibility(View.GONE);
                                reload();
                            }
                        });
                        d.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                dsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                dsalah.setVisibility(View.GONE);
                                reload();
                            }
                        });


                    }
                }
            }
            else if(randomQuis >5 && randomQuis <=6 && nmr5<1) {
                for (DataAsset obj : list) {
                    if (obj.getID() == (6)) {
                        soal.setText(obj.getSoal());
                        a1.setText(obj.getA());
                        b1.setText(obj.getB());
                        c1.setText(obj.getC());
                        d1.setText(obj.getD());
                        a2.setText(obj.getA());
                        b2.setText(obj.getB());
                        c2.setText(obj.getC());
                        d2.setText(obj.getD());
                        a3.setText(obj.getA());
                        b3.setText(obj.getB());
                        c3.setText(obj.getC());
                        d3.setText(obj.getD());

                        c.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                cbenar.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);

                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                skor = skor + 100;
                                cbenar.setVisibility(View.GONE);
                                reload();
                            }

                        });


                        b.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                bsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                bsalah.setVisibility(View.GONE);
                                reload();
                            }

                        });
                        a.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                asalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                asalah.setVisibility(View.GONE);
                                reload();
                            }
                        });
                        d.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                dsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                dsalah.setVisibility(View.GONE);
                                reload();
                            }
                        });


                    }
                }
            }
            else if(randomQuis >6 && randomQuis <=7 && nmr5<1) {
                for (DataAsset obj : list) {
                    if (obj.getID() == (7)) {
                        soal.setText(obj.getSoal());
                        a1.setText(obj.getA());
                        b1.setText(obj.getB());
                        c1.setText(obj.getC());
                        d1.setText(obj.getD());
                        a2.setText(obj.getA());
                        b2.setText(obj.getB());
                        c2.setText(obj.getC());
                        d2.setText(obj.getD());
                        a3.setText(obj.getA());
                        b3.setText(obj.getB());
                        c3.setText(obj.getC());
                        d3.setText(obj.getD());

                        d.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                dbenar.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);

                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                skor = skor + 100;
                                dbenar.setVisibility(View.GONE);
                                reload();
                            }

                        });


                        b.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                bsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                bsalah.setVisibility(View.GONE);
                                reload();
                            }

                        });
                        c.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                csalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                csalah.setVisibility(View.GONE);
                                reload();
                            }
                        });
                        a.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                asalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                asalah.setVisibility(View.GONE);
                                reload();
                            }
                        });


                    }
                }
            }
            else if(randomQuis >7 && randomQuis <=8 && nmr5<1) {
                for (DataAsset obj : list) {
                    if (obj.getID() == (8)) {
                        soal.setText(obj.getSoal());
                        a1.setText(obj.getA());
                        b1.setText(obj.getB());
                        c1.setText(obj.getC());
                        d1.setText(obj.getD());
                        a2.setText(obj.getA());
                        b2.setText(obj.getB());
                        c2.setText(obj.getC());
                        d2.setText(obj.getD());
                        a3.setText(obj.getA());
                        b3.setText(obj.getB());
                        c3.setText(obj.getC());
                        d3.setText(obj.getD());

                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                bbenar.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                skor = skor + 100;
                                bbenar.setVisibility(View.GONE);
                                reload();
                            }

                        });


                        a.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                asalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                asalah.setVisibility(View.GONE);
                                reload();
                            }

                        });
                        c.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                csalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                csalah.setVisibility(View.GONE);
                                reload();
                            }
                        });
                        d.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                dsalah.setVisibility(View.VISIBLE);
                                new Handler().postDelayed(this::resetButton,TIMER);
                            }
                            private void resetButton(){
                                lp = lp + 1;
                                nmr1 = nmr1 + 1;
                                dsalah.setVisibility(View.GONE);
                                reload();
                            }
                        });


                    }
                }
            }
            else {
                reload();
            }
            }
            else {
                hilang.setVisibility(View.GONE);
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("nama",nama2);
                intent.putExtra("gambar",imageUri2);
                Bundle b = new Bundle();
                b.putInt("skor54",skor54);
                b.putInt("skor55", skor);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }


        }




    }
}