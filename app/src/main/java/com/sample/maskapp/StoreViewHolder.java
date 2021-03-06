package com.sample.maskapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class StoreViewHolder extends RecyclerView.ViewHolder {
    private ImageView pharmacy;
    private TextView name, address, distance, createdAt, stockAt;

    public StoreViewHolder(@NonNull View itemView) {
        super(itemView);
        pharmacy = itemView.findViewById(R.id.pharmacy);
        name = itemView.findViewById(R.id.name);
        address = itemView.findViewById(R.id.address);
        distance =  itemView.findViewById(R.id.distance);
        createdAt = itemView.findViewById(R.id.created_at);
        stockAt = itemView.findViewById(R.id.stock_at);
    }
    public void bind(Store store, String distanceAsText) {
        pharmacy.setColorFilter(getStockColor(store.remain_stat));
        name.setText(store.name);
        address.setText(store.addr);
        distance.setText(distanceAsText);
        createdAt.setText(store.created_at);
        stockAt.setText(store.stock_at);
    }

    private int getStockColor(String remainStat) {
        if("plenty".equals(remainStat)) return ContextCompat.getColor(pharmacy.getContext(), R.color.stockPlenty);
        if("Some".equals(remainStat)) return ContextCompat.getColor(pharmacy.getContext(), R.color.stockSome);
        if("Few".equals(remainStat)) return ContextCompat.getColor(pharmacy.getContext(), R.color.stockFew);
        if("empty".equals(remainStat)) return ContextCompat.getColor(pharmacy.getContext(), R.color.stockEmpty);
        if("break".equals(remainStat)) return ContextCompat.getColor(pharmacy.getContext(), R.color.stockBreak);
        return 0;
    }


}
