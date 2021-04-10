package com.example.rmtc.home;

import android.util.Log;

public class Items {

    private String burgerName;
    private String burgerUrl;
    private String priceString;
    private int quantity = 0;

    public Items(final String burgerName, final String burgerUrl, final String priceString) {
        this.burgerName = burgerName;
        this.burgerUrl = burgerUrl;
        this.priceString = priceString;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public void setBurgerUrl(String burgerUrl) {
        this.burgerUrl = burgerUrl;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPriceString() {
        return priceString;
    }

    public void setQuantity(int quantity) {
        Log.e(null, "Hello " + String.valueOf(quantity));
        this.quantity = quantity;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public String getBurgerUrl() {
        return burgerUrl;
    }

    public int getTotal() {
        return quantity * Integer.parseInt(this.priceString);
    }
}
