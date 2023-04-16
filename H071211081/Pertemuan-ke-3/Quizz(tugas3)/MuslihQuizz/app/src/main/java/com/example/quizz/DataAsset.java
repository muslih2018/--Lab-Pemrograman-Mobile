package com.example.quizz;

public class DataAsset {
    private  int id;
    private String soal;
    private String a;
    private String b;
    private String c;
    private String d;


    public DataAsset(int id,String soal, String a, String b, String c, String d) {
        this.id = id;
        this.soal = soal;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }



    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
