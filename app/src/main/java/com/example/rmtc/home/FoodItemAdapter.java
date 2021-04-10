package com.example.rmtc.home;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rmtc.R;

import java.util.List;

interface ItemListener {

    void addToCart(Items items, int totalPrice, int adapterPosition);
}

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {

    private final List<Items> list;
    final ItemListener listener;

    public FoodItemAdapter(final List<Items> list, final ItemListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.list_items, parent, false);
        return new FoodItemViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
        holder.setItems(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class FoodItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemName;
        private final TextView price;
        private final TextView quantity;
        private final ImageView imageView;
        private final CardView positive;
        private final CardView negative;

        private final ItemListener listener;

        public FoodItemViewHolder(@NonNull View itemView, ItemListener listener) {
            super(itemView);

            this.listener = listener;

            itemName = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            imageView = itemView.findViewById(R.id.item_image);
            positive = itemView.findViewById(R.id.positive);
            negative = itemView.findViewById(R.id.negative);
        }

        @SuppressLint("SetTextI18n")
        public void setItems(Items items) {
            itemName.setText(items.getBurgerName());
            price.setText("PHP " + items.getPriceString());

            Glide.with(imageView)
                    .load(items.getBurgerUrl())
                    .into(imageView);

            quantity.setText(String.valueOf(items.getQuantity()));

            positive.setOnClickListener(v -> {
                setEnabled();
                int quantity = items.getQuantity();
                int temp = quantity + 1;
                items.setQuantity(temp);
                setQuantity(String.valueOf(temp));
                listener.addToCart(items, items.getTotal(), getAdapterPosition());
            });

            negative.setOnClickListener(v -> {
                if (items.getQuantity() > 0) {
                    setEnabled();
                    int quantity = items.getQuantity();
                    int temp = quantity - 1;
                    items.setQuantity(temp);
                    setQuantity(String.valueOf(temp));
                    listener.addToCart(items, items.getTotal(), getAdapterPosition());
                } else {
                    quantity.setAlpha(.5f);
                    negative.setAlpha(.5f);
                    negative.setEnabled(false);
                }
            });
        }

        private void setQuantity(final String textQ) {
            quantity.setText(textQ);
        }

        private void setEnabled() {
            quantity.setAlpha(1f);
            negative.setAlpha(1f);
            negative.setEnabled(true);
            negative.invalidate();
        }

    }
}
