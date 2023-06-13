package com.example.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class fragment2Fragment extends Fragment {
        Button post;
        ImageView gambar;
        private static final int PICK_IMAGE_REQUEST = 1;
        EditText deskripsi;
        Uri imageUri;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
            gambar=view.findViewById(R.id.imgpost);
            deskripsi=view.findViewById(R.id.deskripsi);
            post=view.findViewById(R.id.post);

          gambar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                openImagePicker();
                        }
                });
          post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    posting();
                }
            });

            return view;
        }
    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }
    private void posting() {
            if(imageUri!=null){
//        ubah nav
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setTitle("Home");
        ////
        Bundle dataBundle = new Bundle();
        dataBundle.putParcelable("imageUri", imageUri);
        dataBundle.putString("text",deskripsi.getText().toString() );
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FirstFragment targetFragment = (FirstFragment) fragmentManager.findFragmentByTag("FirstFragment");
        Fragment fragment = fragmentManager.findFragmentByTag("FirstFragment");
        Fragment fragment2 = fragmentManager.findFragmentByTag("fragmenpost");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             if (targetFragment != null) {
                 targetFragment.addData(dataBundle);
                 fragmentTransaction.show(fragment);
                 fragmentTransaction.remove(fragment2);
                 fragmentTransaction.commit();
                 Toast.makeText(getContext(), "Post success", Toast.LENGTH_SHORT).show();
             }
            }
            else {
                Toast.makeText(getContext(), "Masukan gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
            }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            imageUri = data.getData();
            gambar.setImageURI(imageUri);
        }
    }


}