package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private Context context;
    private ArrayList<Doktergigi> listDoktergigi;
    private final OnPesanClickListener pesanClickListener;

    public Adapter(Context context, ArrayList<Doktergigi> listDoktergigi, OnPesanClickListener pesanClickListener) {
        this.context = context;
        this.listDoktergigi = listDoktergigi;
        this.pesanClickListener = pesanClickListener;
    }

    public interface OnPesanClickListener {
        void onPesanClick(Doktergigi doktergigi);
    }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView imgdokter;
        TextView drirwan, desc;
        Button btnPesan;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imgdokter = itemView.findViewById(R.id.imgdokter);
            drirwan = itemView.findViewById(R.id.drirwan);
            desc = itemView.findViewById(R.id.desc);
            btnPesan = itemView.findViewById(R.id.btnPesan);
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemdg, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Doktergigi doktergigi = listDoktergigi.get(position);
        holder.drirwan.setText(doktergigi.getNama());
        holder.desc.setText(doktergigi.getDesk());
        holder.imgdokter.setImageResource(doktergigi.getGambar());

        holder.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pesanClickListener.onPesanClick(doktergigi);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDoktergigi.size();
    }
}