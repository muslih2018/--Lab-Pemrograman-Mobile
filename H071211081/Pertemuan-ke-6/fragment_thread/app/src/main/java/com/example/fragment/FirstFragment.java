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

import android.os.Parcelable;
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


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView = view.findViewById(R.id.tvData);
        dataList = new ArrayList<>();
        // Set  adapter
        adapter = new MyAdapter(getContext(),dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ///ubah drawble menjadi uri dan add data ke list
        Resources res = getResources();
        String lorem = getResources().getString(R.string.lorem);
        String uri = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + res.getResourcePackageName(R.drawable.putin) + '/' + res.getResourceTypeName(R.drawable.putin) + '/' + res.getResourceEntryName(R.drawable.putin);
        String uri2 = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + res.getResourcePackageName(R.drawable.bakso) + '/' + res.getResourceTypeName(R.drawable.bakso) + '/' + res.getResourceEntryName(R.drawable.bakso);
        String uri3 = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + res.getResourcePackageName(R.drawable.putin) + '/' + res.getResourceTypeName(R.drawable.putin) + '/' + res.getResourceEntryName(R.drawable.putin);
        String uri4 = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + res.getResourcePackageName(R.drawable.bakso) + '/' + res.getResourceTypeName(R.drawable.bakso) + '/' + res.getResourceEntryName(R.drawable.bakso);
        Uri imageUri4 = Uri.parse(uri);
        Uri imageUri5 = Uri.parse(uri2);
        Uri imageUri6 = Uri.parse(uri3);
        Uri imageUri7 = Uri.parse(uri4);
        dataList.add(new DataItem(imageUri4,imageUri4,lorem,"soeharto"));
        dataList.add(new DataItem(imageUri5,imageUri5,lorem,"jokowi"));
        dataList.add(new DataItem(imageUri6,imageUri6,lorem,"prabowo"));
        dataList.add(new DataItem(imageUri7,imageUri7,lorem,"megawati"));


        return view;
    }
    // Method untuk mendapatkan dataList dari dalam fragment
    public List<DataItem> getDataList() {
        return dataList;
    }


    public void addData(Bundle dataBundle) {
        String data = dataBundle.getString("text");
        imageUri=dataBundle.getParcelable("imageUri");
        dataList.add(new DataItem(imageUri,imageUri, data,"muslih"));
        adapter.notifyDataSetChanged();
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private final Context context;
        private List<DataItem> dataList;


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
            holder.imageView2.setImageURI(Uri.parse(dataItem.getImageUri2()));
            holder.textView.setText(dataItem.getText());
            holder.nama.setText(dataItem.getNama());
            //keprofil dengan merujuk pada pengkondisian data text
            holder.keprofil.setOnClickListener(view -> {
                FragmentManager fragmentManager = getParentFragmentManager();
                FirstFragment fragment = (FirstFragment) fragmentManager.findFragmentByTag("FirstFragment");
                // Panggil dataList dari fragment
                List<DataItem> dataList = fragment.getDataList();
                DataItem firstItem = null;
                if (dataList.get(position).getNama().equalsIgnoreCase("soeharto")) {
                    firstItem = dataList.get(0);
                } else if (dataList.get(position).getNama().equalsIgnoreCase("jokowi")) {
                    firstItem = dataList.get(1);
                } else if (dataList.get(position).getNama().equalsIgnoreCase("prabowo")) {
                    firstItem = dataList.get(2);
                }
                else if (dataList.get(position).getNama().equalsIgnoreCase("megawati")) {
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
            ImageView imageView;
            ImageView imageView2;
            TextView textView,nama;

            LinearLayout keprofil;

            public MyViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.gambar);
                imageView2=itemView.findViewById(R.id.fotopp);
                textView = itemView.findViewById(R.id.desc);
                nama = itemView.findViewById(R.id.nama);
                keprofil =itemView.findViewById(R.id.to_Profil);
            }

        }



    }

}
