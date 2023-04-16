package com.example.myapplication;

import static java.lang.Double.isNaN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hasiltext;
    Button satu,dua,tiga,empat,lima,enam,tujuh,delapan,sembilan,nol,ac,del,samadengan,kurang,tambah,bagi,kali;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hiding the title bar
        getSupportActionBar().hide();
        //button dan teks
        hasiltext = findViewById(R.id.hasiltext);
        satu = findViewById(R.id.satu);
        dua = findViewById(R.id.dua);
        tiga = findViewById(R.id.tiga);
        empat = findViewById(R.id.empat);
        lima = findViewById(R.id.lima);
        enam = findViewById(R.id.enam);
        tujuh = findViewById(R.id.tujuh);
        delapan = findViewById(R.id.delapan);
        sembilan = findViewById(R.id.sembilan);
        nol = findViewById(R.id.nol);
        ac = findViewById(R.id.ac);
        samadengan = findViewById(R.id.samadengan);
        del = findViewById(R.id.del);
        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        bagi = findViewById(R.id.bagi);
        kali = findViewById(R.id.kali);
        final int[] k = {1};

        int i;
        nol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;
                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false || k[0]==0){
                    hasiltext.setText("0");
                    k[0]=1;
                }
                    else {
                        if (cArray[0] == '-') {
                            hasiltext.setText("0");
                        } else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText("0");
                            } else {
                                hasiltext.setText(hasiltext.getText() + "0");
                            }
                        }
                    }}

        });
        satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                    if(z==false || k[0]==0){
                        hasiltext.setText("1");
                        k[0]=1;
                    }
                    else {
                        if(cArray[0]=='-'){
                            hasiltext.setText("1");
                        }

                        else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText(str.substring(0, str.length() - 1));
                                hasiltext.setText(hasiltext.getText() + "1");


                            } else {
                                hasiltext.setText(hasiltext.getText() + "1");


                            }
                        }
                    }


            }
        });
        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false || k[0]==0){
                    hasiltext.setText("2");
                    k[0]=1;
                }
                    else {
                        if (cArray[0] == '-') {
                            hasiltext.setText("2");
                        } else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText(str.substring(0, str.length() - 1));
                                hasiltext.setText(hasiltext.getText() + "2");
                            } else {
                                hasiltext.setText(hasiltext.getText() + "2");
                            }
                        }
                    }

            }
        });
        tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false || k[0]==0){
                    hasiltext.setText("3");
                    k[0]=1;
                }
                    else {
                      if(cArray[0]=='-'){
                        hasiltext.setText("3");
                }
                    else {
                        if (hasiltext.getText().toString().equals("0")) {
                        hasiltext.setText(str.substring(0, str.length() - 1));
                        hasiltext.setText(hasiltext.getText() + "3");
                    } else {
                        hasiltext.setText(hasiltext.getText() + "3");
                    }
                }

            }
                }
        });
        empat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false || k[0]==0){
                    hasiltext.setText("4");
                    k[0]=1;
                }
                    else {
                        if (cArray[0] == '-') {
                            hasiltext.setText("4");
                        } else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText(str.substring(0, str.length() - 1));
                                hasiltext.setText(hasiltext.getText() + "4");
                            } else {
                                hasiltext.setText(hasiltext.getText() + "4");
                            }
                        }
                    }}
        });
        lima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false || k[0]==0){
                    hasiltext.setText("5");
                    k[0]=1;
                }
                    else {
                        if (cArray[0] == '-') {
                            hasiltext.setText("5");
                        } else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText(str.substring(0, str.length() - 1));
                                hasiltext.setText(hasiltext.getText() + "5");
                            } else {
                                hasiltext.setText(hasiltext.getText() + "5");
                            }
                        }
                    }}
        });
        enam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false || k[0]==0){
                    hasiltext.setText("6");
                    k[0]=1;
                }
                    else {
                        if (cArray[0] == '-') {
                            hasiltext.setText("6");
                        } else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText(str.substring(0, str.length() - 1));
                                hasiltext.setText(hasiltext.getText() + "6");
                            } else {
                                hasiltext.setText(hasiltext.getText() + "6");
                            }
                        }
                    }}
        });
        tujuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false || k[0]==0){
                    hasiltext.setText("7");
                    k[0]=1;
                }
                    else {
                        if (cArray[0] == '-') {
                            hasiltext.setText("7");
                        } else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText(str.substring(0, str.length() - 1));
                                hasiltext.setText(hasiltext.getText() + "7");
                            } else {
                                hasiltext.setText(hasiltext.getText() + "7");
                            }
                        }
                    }}
        });
        delapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false|| k[0]==0){
                    hasiltext.setText("8");
                    k[0]=1;
                }
                    else {
                        if (cArray[0] == '-') {
                            hasiltext.setText("8");
                        } else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText(str.substring(0, str.length() - 1));
                                hasiltext.setText(hasiltext.getText() + "8");
                            } else {
                                hasiltext.setText(hasiltext.getText() + "8");
                            }
                        }

                    }}
        });
        sembilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean z=true;

                for (int i = 0; i < cArray.length; i++) {
                    if (cArray[i] == '.') {
                        z = false;
                    }
                }
                if(z==false || k[0]==0){
                    hasiltext.setText("9");
                    k[0]=1;
                }
                    else {
                        if (cArray[0] == '-') {
                            hasiltext.setText("9");
                        } else {
                            if (hasiltext.getText().toString().equals("0")) {
                                hasiltext.setText(str.substring(0, str.length() - 1));
                                hasiltext.setText(hasiltext.getText() + "9");
                            } else {
                                hasiltext.setText(hasiltext.getText() + "9");
                            }
                        }
                    }}
        });


        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                k[0]=1;
                int i;
                boolean z=true;
                boolean k=false;
                for (i = 0; i < cArray.length; i++) {
                    String operasi = String.valueOf(cArray[i]);
                    if (cArray[i] == '.'||(operasi.equalsIgnoreCase("+"))||(operasi.equalsIgnoreCase("-"))||(operasi.equalsIgnoreCase("/"))||(operasi.equalsIgnoreCase("X"))) {
                         k=true;
                         z=false;
                        
                    }}
                if (k==true || z==false) {

                } else if (str.substring(str.length() - 1).equals("X") || str.substring(str.length() - 1).equals("-") || str.substring(str.length() - 1).equals("/") || str.substring(str.length() - 1).equals("+")) {
                    hasiltext.setText(str.substring(0, str.length() - 1));
                    hasiltext.setText(hasiltext.getText() + "+");
                } else {
                    hasiltext.setText(hasiltext.getText() + "+");
                }

            }
        });
        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                k[0]=1;
                int i;
                boolean k=false;
                boolean z=true;
                for (i = 0; i < cArray.length; i++) {
                    String operasi = String.valueOf(cArray[i]);
                    if (cArray[i] == '.'||(operasi.equalsIgnoreCase("+"))||(operasi.equalsIgnoreCase("-"))||(operasi.equalsIgnoreCase("/"))||(operasi.equalsIgnoreCase("X"))) {
                        k=true;
                        z=false;
                    }}
                if (k==true || z==false) {

                }
                else if( str.substring(str.length() - 1).equals("X")||str.substring(str.length() - 1).equals("-")||str.substring(str.length() - 1).equals("/")||str.substring(str.length() - 1).equals("+")) {
                    hasiltext.setText(str.substring(0, str.length()-1));
                    hasiltext.setText(hasiltext.getText()+"-");
                }
                else {
                    hasiltext.setText(hasiltext.getText()+"-");}

            }
        });
        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                k[0]=1;
                int i;
                boolean k=false;
                boolean z=true;
                for (i = 0; i < cArray.length; i++) {
                    String operasi = String.valueOf(cArray[i]);
                    if (cArray[i] == '.'||(operasi.equalsIgnoreCase("+"))||(operasi.equalsIgnoreCase("-"))||(operasi.equalsIgnoreCase("/"))||(operasi.equalsIgnoreCase("X"))) {
                        k=true;
                        z=false;
                    }}
                if (k==true || z==false) {

                }
                else if( str.substring(str.length() - 1).equals("X")||str.substring(str.length() - 1).equals("-")||str.substring(str.length() - 1).equals("/")||str.substring(str.length() - 1).equals("+")) {
                    hasiltext.setText(str.substring(0, str.length()-1));
                    hasiltext.setText(hasiltext.getText()+"X");
                }
                else {
                    hasiltext.setText(hasiltext.getText()+"X");}

            }
        });
        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                k[0]=1;
                int i;
                boolean k=false;
                boolean z=true;
                for (i = 0; i < cArray.length; i++) {
                    String operasi = String.valueOf(cArray[i]);
                    if (cArray[i] == '.'||(operasi.equalsIgnoreCase("+"))||(operasi.equalsIgnoreCase("-"))||(operasi.equalsIgnoreCase("/"))||(operasi.equalsIgnoreCase("X"))) {
                        k=true;
                        z=false;
                    }}
                if (k==true || z==false) {

                }
                else if( str.substring(str.length() - 1).equals("X")||str.substring(str.length() - 1).equals("-")||str.substring(str.length() - 1).equals("/")||str.substring(str.length() - 1).equals("+")) {
                    hasiltext.setText(str.substring(0, str.length()-1));
                    hasiltext.setText(hasiltext.getText()+"/");
                }
                else {
                    hasiltext.setText(hasiltext.getText()+"/");}

            }
        });


        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hasiltext.setText("0");

            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(hasiltext.getText());
                char[] cArray = str.toCharArray();
                boolean k=false;
                int i;
                for (i = 0; i < cArray.length; i++) {
                    String operasi = String.valueOf(cArray[i]);
                    if (cArray[i] == '.') {
                        k=true;
                    }}

               if(cArray[0]=='-'||k==true){
                   hasiltext.setText("0");
               }
               else {
                if(hasiltext.getText().toString().length()==1){
                    hasiltext.setText("0");
                }
                else  {
                    hasiltext.setText(str.substring(0, str.length()-1));
                }}
            }
        });

///mesin kalkolator

        samadengan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String str = String.valueOf(hasiltext.getText());
                    char[] cArray = str.toCharArray();
                    int i;
                    for (i = 0; i < cArray.length; i++) {
                        String operasi = String.valueOf(cArray[i]);
                        if(str.charAt(str.length() - 1) =='-'||str.charAt(str.length() - 1) =='+'||str.charAt(str.length() - 1) =='/'||str.charAt(str.length() - 1) =='X'){

                        }
                        else {
                            if (operasi.equals("/")) {
                                String[] parts = str.split("/");
                                String number1 = parts[0];
                                String number2 = parts[1];
                                double numbera = Integer.valueOf(number1.toString());
                                double numberb = Integer.valueOf(number2.toString());
                                double ahasil = numbera / numberb;
                                if(isNaN(ahasil) || ahasil == Double.POSITIVE_INFINITY ){
                                    Toast.makeText(MainActivity.this,"Cannot divided by zero",Toast.LENGTH_SHORT).show();
                                }  else {
                                    hasiltext.setText(String.valueOf(ahasil));
                                }

                            } else if (operasi.equals("-")) {
                                String[] parts = str.split("-");
                                String number1 = parts[0];
                                String number2 = parts[1];
                                int numbera = Integer.valueOf(number1.toString());
                                int numberb = Integer.valueOf(number2.toString());
                                int ahasil = numbera - numberb;
                                hasiltext.setText(String.valueOf(ahasil));
                                k[0] =0;
                            } else if (operasi.equals("X")) {
                                String[] parts = str.split("X");
                                String number1 = parts[0];
                                String number2 = parts[1];
                                int numbera = Integer.valueOf(number1.toString());
                                int numberb = Integer.valueOf(number2.toString());
                                int ahasil = numbera * numberb;
                                hasiltext.setText(String.valueOf(ahasil));
                                k[0] =0;
                            }
                            //tambah
                            else if (operasi.equals("+")) {
                                cArray[i]=']';
                                //tanda tambah tidak bisa di split
                                String hasil22 = new String(cArray);
                                String[] parts = hasil22.split("]");
                                String number1 = parts[0];
                                String number2 = parts[1];
                                int numbera = Integer.valueOf(number1.toString());
                                int numberb = Integer.valueOf(number2.toString());
                                int ahasil = numbera + numberb;
                                hasiltext.setText(String.valueOf(ahasil));
                                k[0] =0;
                            }

                        }

                    }
                }
                catch(Exception e) {
                    Toast.makeText(MainActivity.this,"Can't calculate number more than 32 bit",Toast.LENGTH_SHORT).show();
                }

            }

        });


    }}