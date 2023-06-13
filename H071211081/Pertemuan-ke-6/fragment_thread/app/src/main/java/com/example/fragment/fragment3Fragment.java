package com.example.fragment;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class fragment3Fragment extends Fragment {

    private SearchView searchView;
    private RecyclerView recyclerView;
    private static fragment3Fragment.MyAdapter adapter;
    private static List<DataItem> dataList;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        //recrview
        recyclerView = view.findViewById(R.id.tvData);
        adapter = new fragment3Fragment.MyAdapter(getContext(),dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
////thread
        progressBar=view.findViewById(R.id.progressBar);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            try {
//simulate process in background thread
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(30);
                    int percentage = i * 10;
                    handler.post(() -> {
//update ui in main thread
                        if (percentage == 100) {
                            progressBar.setVisibility(View.GONE);
                        } else {
                            progressBar.setVisibility(View.VISIBLE);
                        }
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ///cari
        recyclerView.setVisibility(View.GONE);
        searchView=view.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterlist(newText);
                return true;
            }

            private void filterlist(String text) {
                List<DataItem> filteredList=new ArrayList<>();
                for (DataItem dataItem:dataList){
                    if(dataItem.getNama().toLowerCase().contains(text.toLowerCase())){
                        filteredList.add(dataItem);
                    }
                }
                if (filteredList.isEmpty()){
                    recyclerView.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "Tidak ada data", Toast.LENGTH_SHORT).show();
                }
                else {
                    executor.execute(() -> {
                        try {
//simulate process di background thread
                            for (int i = 0; i <= 10; i++) {
                                Thread.sleep(30);
                                int percentage = i * 10;
                                handler.post(() -> {
//update ui di main thread
                                    if (percentage == 100) {
//                                       adapter menampilkan sesuai  daftar yang  difilter
                                        adapter.setFilteredList(filteredList);
                                        recyclerView.setVisibility(View.VISIBLE);
                                        progressBar.setVisibility(View.GONE);
                                    } else {
                                        recyclerView.setVisibility(View.GONE);
                                        progressBar.setVisibility(View.VISIBLE);
                                    }
                                });
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
//
                }
            }
        });
        return view;
    }

    public static void addData(Bundle bundle) {
        dataList = bundle.getParcelableArrayList("dataList");
    }

    private class MyAdapter extends RecyclerView.Adapter<fragment3Fragment.MyAdapter.MyViewHolder> {

        private final Context context;
        private List<DataItem> dataList;



        public MyAdapter(Context context, List<DataItem> dataList) {
            this.dataList = dataList;
            this.context=context;
        }
        //method yang menerima parameter filteredList dengan tipe List<DataItem>.
        public void setFilteredList(List<DataItem>filteredList){
            this.dataList=filteredList;
            notifyDataSetChanged();
        }
        @NonNull
        @Override
        public fragment3Fragment.MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cari_list, parent, false);
            return new fragment3Fragment.MyAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull fragment3Fragment.MyAdapter.MyViewHolder holder, int position) {
            DataItem dataItem = dataList.get(position);
            holder.imageView2.setImageURI(Uri.parse(dataItem.getImageUri2()));
            holder.nama.setText(dataItem.getNama());
            //keprofil dengan merujuk pada pengkondisian data text
            holder.keprofil.setOnClickListener(view -> {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragment3Fragment fragment = (fragment3Fragment) fragmentManager.findFragmentByTag("fragmentcari");
                // Panggil dataList dari fragment
                List<DataItem> dataList = fragment.getDataList();
                DataItem firstItem = null;
                if (dataList.get(position).getNama().equals("soeharto")) {
                    firstItem = dataList.get(0);
                } else if (dataList.get(position).getNama().equals("jokowi")) {
                    firstItem = dataList.get(1);
                } else if (dataList.get(position).getNama().equals("prabowo")) {
                    firstItem = dataList.get(2);
                }
                else if (dataList.get(position).getNama().equals("megawati")) {
                    firstItem = dataList.get(3);
                }
                else {
                    firstItem = dataList.get(4);
                }
                Uri firstItemUri = Uri.parse(firstItem.getImageUri2());
                String firstItemString = firstItem.getNama();
                Intent intent = new Intent(getContext(), profilview.class);
                intent.putExtra("imageUri", firstItemUri.toString());
                intent.putExtra("text", firstItemString);
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView2;
            TextView nama;

            LinearLayout keprofil;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView2=itemView.findViewById(R.id.fotopp);
                nama = itemView.findViewById(R.id.nama);
                keprofil =itemView.findViewById(R.id.to_Profil);
            }

        }



    }
/////ambildata dari data list
    private List<DataItem> getDataList() {
        return dataList;
    }
}