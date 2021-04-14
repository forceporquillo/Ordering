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

/**
 * A recyclerView adapter that binds item into a recyclable list manner
 * which let users scroll the list when finding a item.
 *
 * This adapter is used to attach the add to cart items
 */
public class ViewCardAdapter extends RecyclerView.Adapter<ViewCardAdapter.ViewCardViewHolder> {

    private final List<Items> itemsList;

    /**
     * Instantiate adapter with set of list items
     * @param itemsList items to be displayed
     */
    public ViewCardAdapter(final List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    /**
     * Every time we add an item to the cart
     * it invalidates the list, adding all items and redraws the list again
     * @param list items to be added to the itemList
     */
    public void update(final List<Items> list) {
        itemsList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * Creates itemViews of the layout view card items list.
     * It uses inflater mechanism to attach the views to the adapter itself.
     *
     * @param parent the parent view of the adapter
     * @param viewType return current position of itemView
     * @return new instance of ViewCardViewHolder
     */
    @NonNull
    @Override
    public ViewCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.view_card_list_items, parent, false);
        return new ViewCardViewHolder(view);
    }

    /**
     * Bind the items to the viewItem delegates backed by its index or position
     * @param holder the view to add the items
     * @param position position of the viewholder
     */
    @Override
    public void onBindViewHolder(@NonNull ViewCardViewHolder holder, int position) {
        holder.bind(itemsList.get(position));
    }

    /**
     * return total count of items in the adapter
     * @return
     */
    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    /**
     * A holder that holds the itemView which inflates from the adapter
     */
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

            // load image url using glide library
            // and set the image to the imageView
            Glide.with(image)
                    .load(items.getBurgerUrl())
                    .into(image);

            itemName.setText(items.getBurgerName());
            view.setText("Quantity: " + items.getQuantity());
        }
    }
}
