package com.example.fragment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnHome, btnPost,btnProfil,btnCari;
    FirstFragment FirstFragment;
    fragment2Fragment fragment2Fragment;

    fragmentprofil fragmentprofil;
    fragment3Fragment fragment3Fragment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHome = findViewById(R.id.home);
        btnPost = findViewById(R.id.post);
        btnProfil = findViewById(R.id.profil);
        btnCari = findViewById(R.id.cari);
        btnHome.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnProfil.setOnClickListener(this);
        btnCari.setOnClickListener(this);
        getSupportActionBar().setTitle("Home");
        menuHome();
    }
    //////'semua fragment method
    void menuHome() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag("FirstFragment");
        Fragment fragment2 = fragmentManager.findFragmentByTag("fragmenprofil");
        Fragment fragment3 = fragmentManager.findFragmentByTag("fragmenpost");
        Fragment fragment4 = fragmentManager.findFragmentByTag("fragmentcari");

        // Sembunyikan Fragment sebelumnya (jika ada)

        if(fragment != null){
            if(fragment3 != null && fragment2 != null && fragment4 != null && fragment3.isVisible()&& fragment2.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment4);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment3 != null && fragment2 != null && fragment3.isVisible()&& fragment2.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment3 != null && fragment4 != null && fragment3.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment2 != null && fragment4 != null && fragment2.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment2);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment3 != null && fragment3.isVisible() ){
                fragmentTransaction.hide(fragment3);
            }
            if(fragment2 != null && fragment2.isVisible() ){
                fragmentTransaction.hide(fragment2);
            }
            if(fragment4 != null && fragment4.isVisible() ){
                fragmentTransaction.hide(fragment4);
            }
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        }

        else {
            FirstFragment = new FirstFragment();
            FragmentTransaction ft = getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container,FirstFragment, "FirstFragment");
            if(fragment3 != null && fragment2 != null && fragment4 != null && fragment3.isVisible()&& fragment2.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment4);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment3 != null && fragment2 != null && fragment3.isVisible()&& fragment2.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment3 != null && fragment4 != null && fragment3.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment2 != null && fragment4 != null && fragment2.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment2);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment3 != null && fragment3.isVisible() ){
                fragmentTransaction.hide(fragment3);
            }
            if(fragment2 != null && fragment2.isVisible() ){
                fragmentTransaction.hide(fragment2);
            }
            if(fragment4 != null && fragment4.isVisible() ){
                fragmentTransaction.hide(fragment4);
            }
            fragmentTransaction.commit();
                ft.commit();

        }
    }
    void menuPost() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag("FirstFragment");
        Fragment fragment2 = fragmentManager.findFragmentByTag("fragmenprofil");
        Fragment fragment3 = fragmentManager.findFragmentByTag("fragmenpost");
        Fragment fragment4 = fragmentManager.findFragmentByTag("fragmentcari");

        // Sembunyikan Fragment sebelumnya (jika ada)

        if(fragment3 != null){
            if(fragment != null && fragment2 != null && fragment4 != null && fragment.isVisible()&& fragment2.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment2);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment != null && fragment2 != null && fragment.isVisible()&& fragment2.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment != null && fragment4 != null && fragment.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment2 != null && fragment4 != null && fragment2.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment2);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment != null && fragment.isVisible() ){
                fragmentTransaction.hide(fragment);
            }
            if(fragment2 != null && fragment2.isVisible() ){
                fragmentTransaction.hide(fragment2);
            }
            if(fragment4 != null && fragment4.isVisible() ){
                fragmentTransaction.hide(fragment4);
            }
            fragmentTransaction.show(fragment3);
            fragmentTransaction.commit();

        }

        else {
            fragment2Fragment = new fragment2Fragment();
            FragmentTransaction ft = getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container,fragment2Fragment, "fragmenpost");
            if(fragment != null && fragment2 != null && fragment4 != null && fragment.isVisible()&& fragment2.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment2);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment != null && fragment2 != null && fragment.isVisible()&& fragment2.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment != null && fragment4 != null && fragment.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment2 != null && fragment4 != null && fragment2.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment2);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment != null && fragment.isVisible() ){
                fragmentTransaction.hide(fragment);
            }
            if(fragment2 != null && fragment2.isVisible() ){
                fragmentTransaction.hide(fragment2);
            }
            if(fragment4 != null && fragment4.isVisible() ){
                fragmentTransaction.hide(fragment4);
            }
            fragmentTransaction.commit();
            ft.commit();

        }
    }
    void menuProfil() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag("FirstFragment");
        Fragment fragment2 = fragmentManager.findFragmentByTag("fragmenprofil");
        Fragment fragment3 = fragmentManager.findFragmentByTag("fragmenpost");
        Fragment fragment4 = fragmentManager.findFragmentByTag("fragmentcari");

        // Sembunyikan Fragment sebelumnya (jika ada)

        if(fragment2 != null){
            if(fragment != null && fragment3 != null&& fragment4 != null && fragment.isVisible()&& fragment4.isVisible()&& fragment3.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment != null && fragment3 != null && fragment.isVisible()&& fragment3.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment3);
            }
            if(fragment != null && fragment4 != null && fragment.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment3 != null && fragment4 != null && fragment3.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment != null && fragment.isVisible() ){
                fragmentTransaction.hide(fragment);
            }
            if(fragment3 != null&& fragment3.isVisible() ){
                fragmentTransaction.hide(fragment3);
            }
            if(fragment4 != null&& fragment4.isVisible() ){
                fragmentTransaction.hide(fragment4);
            }
            fragmentTransaction.show(fragment2);
            fragmentTransaction.commit();


        }

        else {
            fragmentprofil = new fragmentprofil();
            FragmentTransaction ft = getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragmentprofil, "fragmenprofil");
            if(fragment != null && fragment3 != null&& fragment4 != null && fragment.isVisible()&& fragment4.isVisible()&& fragment3.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment != null && fragment3 != null && fragment.isVisible()&& fragment3.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment3);
            }
            if(fragment != null && fragment4 != null && fragment.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment3 != null && fragment4 != null && fragment3.isVisible()&& fragment4.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment4);
            }
            if(fragment != null && fragment.isVisible() ){
                fragmentTransaction.hide(fragment);
            }
            if(fragment3 != null&& fragment3.isVisible() ){
                fragmentTransaction.hide(fragment3);
            }
            if(fragment4 != null&& fragment4.isVisible() ){
                fragmentTransaction.hide(fragment4);
            }
                 fragmentTransaction.commit();
                 ft.commit();
        }

    }
    void menuCari() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag("FirstFragment");
        Fragment fragment2 = fragmentManager.findFragmentByTag("fragmenprofil");
        Fragment fragment3 = fragmentManager.findFragmentByTag("fragmenpost");
        Fragment fragment4 = fragmentManager.findFragmentByTag("fragmentcari");
        ///hapus fragmencari/4/fragment3fragment kalau ada
        if(fragment4!=null){
        fragmentTransaction.remove(fragment4);}
        else {

        }
        // Sembunyikan Fragment sebelumnya (jika ada)
            fragment3Fragment = new fragment3Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction().add(R.id.container, fragment3Fragment, "fragmentcari");

            if(fragment != null && fragment3 != null&& fragment2 != null && fragment.isVisible()&& fragment2.isVisible()&& fragment3.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment != null && fragment3 != null && fragment.isVisible()&& fragment3.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment3);
            }
            if(fragment != null && fragment2 != null && fragment.isVisible()&& fragment2.isVisible()){
                fragmentTransaction.hide(fragment);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment3 != null && fragment2 != null && fragment3.isVisible()&& fragment2.isVisible()){
                fragmentTransaction.hide(fragment3);
                fragmentTransaction.hide(fragment2);
            }
            if(fragment != null && fragment.isVisible() ){
                fragmentTransaction.hide(fragment);
            }
            if(fragment3 != null&& fragment3.isVisible() ){
                fragmentTransaction.hide(fragment3);
            }
            if(fragment2 != null&& fragment2.isVisible() ){
                fragmentTransaction.hide(fragment2);
            }
            fragmentTransaction.commit();
            ft.commit();


    }
    ////onclick
    @Override
    public void onClick(View v) {
        if (v == btnHome) {
            if( getSupportActionBar().getTitle().toString().equalsIgnoreCase("Home")){}
            else {
                getSupportActionBar().setTitle("Home");
                menuHome();}
        }
        if (v == btnPost) {
            if( getSupportActionBar().getTitle().toString().equalsIgnoreCase("Post")){}
            else {
                getSupportActionBar().setTitle("Post");
                menuPost();
            }
        }
        if (v == btnProfil) {
            if( getSupportActionBar().getTitle().toString().equalsIgnoreCase("Profil")){}
            else {
            getSupportActionBar().setTitle("Profil");
            menuProfil();}
        }
        if (v == btnCari) {
            if( getSupportActionBar().getTitle().toString().equalsIgnoreCase("Cari")){}
            else {
                ///kirimdata ke framen3fragment
                FirstFragment FirstFragment = (FirstFragment) getSupportFragmentManager().findFragmentByTag("FirstFragment");
                List<DataItem> dataList = FirstFragment.getDataList();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("dataList", new ArrayList<>(dataList));
                fragment3Fragment.addData(bundle);
                getSupportActionBar().setTitle("Cari");
                menuCari();}
        }


    }
}
