package com.example.intent;
        import android.os.Parcel;
        import android.os.Parcelable;
        import androidx.annotation.NonNull;

public class Praceable implements Parcelable {

    private String  username, nama;


    protected Praceable(Parcel in) {
        nama = in.readString();
        username = in.readString();

    }

    public static final Creator<Praceable> CREATOR = new Creator<Praceable>() {
        @Override
        public Praceable createFromParcel(Parcel in) {
            return new Praceable(in);
        }

        @Override
        public Praceable[] newArray(int size) {
            return new Praceable[size];
        }
    };

    Praceable(String nama, String username) {

        this.nama = nama;
        this.username = username;

    }



    public String getNama() {
        return nama;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(username);
    }
}