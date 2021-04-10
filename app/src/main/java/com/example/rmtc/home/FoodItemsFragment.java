package com.example.rmtc.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rmtc.R;

import java.util.HashMap;

public class FoodItemsFragment extends Fragment implements ItemListener {

    private final HashMap<String, Items> hashMap = new HashMap<>();

    public FoodItemsFragment() {
        // Required empty public constructor
    }

    public enum FoodType {
        BURGER, DRINKS, ADD_ONS
    }

    interface ViewCartItems {
        void onAddToCart(HashMap<String, Items> hashMap);
    }

    private ViewCartItems viewCartItems;

    public static FoodItemsFragment newInstance(FoodType type) {
        final FoodItemsFragment fragment = new FoodItemsFragment();
        Bundle args = new Bundle();
        args.putSerializable("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        viewCartItems = (ViewCartItems)(context);
    }

    @Override
    public void addToCart(Items items, int totalPrice, int adapterPosition) {
        hashMap.put(items.getBurgerName(), items);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_burgers, container, false);

        FoodItemAdapter adapter;

        if (getArguments() != null) {
            final FoodType type = (FoodType) getArguments().getSerializable("type");

            if (type == FoodType.BURGER) {
                adapter = new FoodItemAdapter(FoodItems.getBurgers(), this);
            } else if (type == FoodType.DRINKS) {
                adapter = new FoodItemAdapter(FoodItems.getDrinks(), this);
            } else {
                adapter = new FoodItemAdapter(FoodItems.getAddOns(), this);
            }

            final RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
            recyclerView.setAdapter(adapter);
        }

        view.findViewById(R.id.button_cart).setOnClickListener(v -> {
            viewCartItems.onAddToCart(hashMap);
            requireActivity().onBackPressed();
        });

        return view;
    }
}