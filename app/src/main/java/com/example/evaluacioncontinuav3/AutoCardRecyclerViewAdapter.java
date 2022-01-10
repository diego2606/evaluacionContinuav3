package com.example.evaluacioncontinuav3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacioncontinuav3.network.AutoEntry;
import com.example.evaluacioncontinuav3.network.ImageRequester;

import java.util.List;

public class AutoCardRecyclerViewAdapter extends RecyclerView.Adapter<AutoCardViewHolder> {
    private List<AutoEntry> autoList;
    private ImageRequester imageRequester;

    AutoCardRecyclerViewAdapter(List<AutoEntry> autoList) {
        this.autoList = autoList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public AutoCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.auto_card, parent, false);
        return new AutoCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull AutoCardViewHolder holder, int position) {
        if (autoList != null & position < autoList.size()) {
            AutoEntry auto = autoList.get(position);
            holder.autoTitle.setText(auto.title);
            holder.autoPrice.setText(auto.price);
            imageRequester.setImageFromUrl(holder.autoImage, auto.url);
        }

    }

    @Override
    public int getItemCount() {
        return autoList.size();
    }
}
