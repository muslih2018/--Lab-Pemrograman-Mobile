package com.example.fragment;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<DataItem> dataList;
     Uri imageUri;
     LinearLayout toprofil2;
     TextView suggestion;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView = view.findViewById(R.id.tvData);
        dataList = new ArrayList<>();
        // Set  adapter
        adapter = new MyAdapter(getContext(),dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        //ke profil
        toprofil2 = view.findViewById(R.id.to_Profil);
        //kondisi hilangkan text suggestion
        suggestion=view.findViewById(R.id.suggestion);
        return view;
    }
    // Method untuk mendapatkan dataList dari dalam fragment
    public List<DataItem> getDataList() {
        return dataList;
    }


    public void addData(Bundle dataBundle) {
        suggestion.setVisibility(View.GONE);
        String data = dataBundle.getString("text");
        imageUri=dataBundle.getParcelable("imageUri");
        dataList.add(new DataItem(imageUri, data));
        adapter.notifyDataSetChanged();
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private final Context context;
        private List<DataItem> dataList;
        LinearLayout keprofil;

        public MyAdapter(Context context, List<DataItem> dataList) {
            this.dataList = dataList;
            this.context=context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            DataItem dataItem = dataList.get(position);
            holder.imageView.setImageURI(Uri.parse(dataItem.getImageUri()));
            holder.textView.setText(dataItem.getText());
            //keprofil
            holder.keprofil.setOnClickListener(view ->{
                MainActivity mainActivity = (MainActivity) getActivity();
                if (mainActivity != null) {
                    mainActivity.menuProfil();
                }
                });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textView;

            LinearLayout keprofil;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.gambar);
                textView = itemView.findViewById(R.id.desc);
                keprofil =itemView.findViewById(R.id.to_Profil);
            }

        }



    }

}
