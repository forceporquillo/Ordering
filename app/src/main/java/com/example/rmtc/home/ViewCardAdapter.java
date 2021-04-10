package com.example.rmtc.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rmtc.R;

import java.util.List;

public class ViewCardAdapter extends RecyclerView.Adapter<ViewCardAdapter.ViewCardViewHolder> {

    private final List<Items> itemsList;

    public ViewCardAdapter(final List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public void update(final List<Items> list) {
        itemsList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.view_card_list_items, parent, false);
        return new ViewCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewCardViewHolder holder, int position) {
        holder.bind(itemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    static class ViewCardViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView view;
        private final TextView itemName;

        public ViewCardViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.item_image);
            view = itemView.findViewById(R.id.quantity);
            itemName = itemView.findViewById(R.id.item_name1);
        }

        @SuppressLint("SetTextI18n")
        public void bind(final Items items) {
            Glide.with(image)
                    .load(items.getBurgerUrl())
                    .into(image);

            itemName.setText(items.getBurgerName());
            view.setText("Quantity: " + items.getQuantity());
        }
    }
}
