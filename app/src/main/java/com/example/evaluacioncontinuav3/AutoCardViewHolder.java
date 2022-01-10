package com.example.evaluacioncontinuav3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class AutoCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView autoImage;
    public TextView autoTitle;
    public TextView autoPrice;

    public AutoCardViewHolder(@NonNull View itemView) {
        super(itemView);
        autoImage = itemView.findViewById(R.id.auto_image);
        autoTitle = itemView.findViewById(R.id.auto_title);
        autoPrice = itemView.findViewById(R.id.auto_price);
    }
}
