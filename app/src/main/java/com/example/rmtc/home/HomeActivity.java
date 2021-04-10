package com.example.rmtc.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rmtc.BaseActivity;
import com.example.rmtc.OrderingActivity;
import com.example.rmtc.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomeActivity extends BaseActivity implements FoodItemsFragment.ViewCartItems {

    TextView burger, drink, addon;

    private ViewCardAdapter adapter = null;

    private HashMap<String, Items> hashMap = new HashMap<>();

    private RelativeLayout relativeLayout;

    private final List<Items> itemsList = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView bg = findViewById(R.id.bg);
        AnimationDrawable animationDrawable = (AnimationDrawable) bg.getDrawable();
        animationDrawable.start();

        burger = (TextView) findViewById(R.id.items);
        drink = (TextView) findViewById(R.id.drinks);
        addon = (TextView) findViewById(R.id.addons);

        burger.setOnClickListener(v -> showItems(FoodItemsFragment.FoodType.BURGER));
        drink.setOnClickListener(v -> showItems(FoodItemsFragment.FoodType.DRINKS));
        addon.setOnClickListener(v -> showItems(FoodItemsFragment.FoodType.ADD_ONS));

        relativeLayout = findViewById(R.id.container);

        final RecyclerView recyclerView = findViewById(R.id.recylcerview1);
        final Button checkout = findViewById(R.id.checkout);
        final ProgressBar progressBar = findViewById(R.id.progressbar);

        findViewById(R.id.view_cart_1).setOnClickListener(v -> {
            if (relativeLayout.getVisibility() == View.GONE) {
                relativeLayout.setVisibility(View.VISIBLE);
            }
            if (adapter == null) {
                adapter = new ViewCardAdapter(itemsList);
                recyclerView.setAdapter(adapter);
            } else {
                adapter.update(itemsList);
            }

            displayTotalPrice();
        });

        checkout.setOnClickListener(v -> {
            checkout.setText("Processing");
            progressBar.setVisibility(View.VISIBLE);

            checkout.postDelayed(() -> {
                checkout.setText("Order Processed...");
                progressBar.setVisibility(View.INVISIBLE);
                checkout.setTextColor(Color.parseColor("#3DDC84"));

                checkout.postDelayed(() -> {
                    startActivity(OrderingActivity.class, false);
                }, 2000L);

            }, 4000);
        });
    }

    @Override
    public void onBackPressed() {
        if (relativeLayout.getVisibility() == View.VISIBLE) {
            relativeLayout.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressLint("SetTextI18n")
    private void displayTotalPrice() {
        int total = 0;

        for (Items item : itemsList) {
            total += item.getTotal();
        }

        @SuppressLint("DefaultLocale") String strTotal = String.format("%,d", total);
        TextView totalPrice = findViewById(R.id.total_price);
        totalPrice.setText("Total Price: " + strTotal);
    }

    private void showItems(FoodItemsFragment.FoodType type) {
        final Fragment fragment = FoodItemsFragment.newInstance(type);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_view, fragment, "Burger")
                .addToBackStack("Burger")
                .commit();
    }

    @Override
    public void onAddToCart(HashMap<String, Items> hashMap) {
        itemsList.addAll(new ArrayList<>(hashMap.values()));
    }
}