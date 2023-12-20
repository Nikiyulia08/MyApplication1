package com.example.myapplication1;

import android.os.Parcel;
import android.os.Parcelable;

public class Doktergigi implements Parcelable {
    private String nama, desk, hari, tanggal, jam; // Perbaiki atribut yang sesuai dengan yang digunakan pada PemesananActivity
    private Integer gambar;
    private String pesan;

    public Doktergigi(String nama, String desk, Integer gambar, String pesan) {
        this.nama = nama;
        this.desk = desk;
        this.gambar = gambar;
        this.pesan = pesan;
    }

    protected Doktergigi(Parcel in) {
        nama = in.readString();
        desk = in.readString();
        if (in.readByte() == 0) {
            gambar = null;
        } else {
            gambar = in.readInt();
        }
        pesan = in.readString();
    }

    public static final Creator<Doktergigi> CREATOR = new Creator<Doktergigi>() {
        @Override
        public Doktergigi createFromParcel(Parcel in) {
            return new Doktergigi(in);
        }

        @Override
        public Doktergigi[] newArray(int size) {
            return new Doktergigi[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public String getDesk() {
        return desk;
    }

    public Integer getGambar() {
        return gambar;
    }

    public String getPesan() {
        return pesan;
    }

    public String getHari() {
        return hari;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(desk);
        if (gambar == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(gambar);
        }
        dest.writeString(pesan);
    }
}
