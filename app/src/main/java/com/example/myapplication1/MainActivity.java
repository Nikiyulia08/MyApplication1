package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adapter.OnPesanClickListener {

    RecyclerView rDoktergigi;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Doktergigi> listDoktergigi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataDummy();
        setupRecyclerView();
    }

    void dataDummy() {
        listDoktergigi = new ArrayList<>();
        listDoktergigi.add(new Doktergigi("Dr. Irwan", "Rs. Ibnu Sina Padang", R.drawable.drlaki, "pesan"));
        listDoktergigi.add(new Doktergigi("Dr. Arifin", "Rs. M.Djamil Padang", R.drawable.drlaki, "pesan"));
        listDoktergigi.add(new Doktergigi("Dr. Lukman", "Rs. Bung Hatta Padang", R.drawable.drlaki, "pesan"));
        listDoktergigi.add(new Doktergigi("Dr. Irfan", "Rs. Umum Padang", R.drawable.drlaki, "pesan"));
        listDoktergigi.add(new Doktergigi("Dr. Syukur", "Rs. Harapan Padang", R.drawable.drlaki, "pesan"));
        listDoktergigi.add(new Doktergigi("Dr. Alam", "Rs. Militer Padang", R.drawable.drlaki, "pesan"));
    }

    void setupRecyclerView() {
        rDoktergigi = findViewById(R.id.rDokter);
        adapter = new Adapter(this, listDoktergigi, this);
        layoutManager = new LinearLayoutManager(this);
        rDoktergigi.setLayoutManager(layoutManager);
        rDoktergigi.setAdapter(adapter);
    }

    @Override
    public void onPesanClick(Doktergigi doktergigi) {
        Intent intent = new Intent(MainActivity.this, PemesananActivity.class);
        intent.putExtra("dokter", doktergigi);
        startActivity(intent);
    }
}
