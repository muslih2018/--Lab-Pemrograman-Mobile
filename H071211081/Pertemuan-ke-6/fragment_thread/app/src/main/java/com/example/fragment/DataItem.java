package com.example.fragment;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DataItem  implements Parcelable {
    private String imageUri;
    private String imageUri2;
    private String text;
    private String nama;

    public DataItem(Uri imageUri,Uri imageUri2,String text,String nama) {
        this.imageUri = String.valueOf(imageUri);
        this.imageUri2 = String.valueOf(imageUri2);
        this.text = text;
        this.nama=nama;
    }

    protected DataItem(Parcel in) {
        imageUri = in.readString();
        imageUri2 = in.readString();
        text = in.readString();
        nama = in.readString();
    }

    public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel in) {
            return new DataItem(in);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };

    public String getImageUri() {
        return imageUri;
    }
    public String getImageUri2() {
        return imageUri2;
    }
    public String getText() {
        return text;
    }
    public String getNama() {
        return nama;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(imageUri);
        parcel.writeString(nama);
        parcel.writeString(imageUri2);
        parcel.writeString(text);
    }

}