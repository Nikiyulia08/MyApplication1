package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PemesananActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pemesanan);  // Sesuaikan dengan nama layout Anda

        // Ambil data dari intent
        Intent intent = getIntent();
        if (intent != null) {
            Doktergigi doktergigi = intent.getParcelableExtra("dokter");
            if (doktergigi != null) {
                // Tampilkan data dokter pada tampilan
                TextView textPemesanan = findViewById(R.id.textPemesanan);
                TextView textTanggal = findViewById(R.id.textTanggal);

                textPemesanan.setText("Kami ingin mengonfirmasi bahwa jadwal pemesanan dengan dokter " + doktergigi.getNama() + " telah disiapkan.");
                textTanggal.setText("Hari: " + doktergigi.getHari() + "\nTanggal: " + doktergigi.getTanggal() + "\nJam: " + doktergigi.getJam());
            }
        }
    }
}
