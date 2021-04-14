package com.example.rmtc.home;

import java.util.ArrayList;
import java.util.List;

/**
 * A fake model data source which stores food items
 */
public class FoodItems {

    public static List<Items> getBurgers() {
        final List<Items> items = new ArrayList<>();

        items.add(
                new Items(
                        "Hamburger 1",
                        "https://comicvine1.cbsistatic.com/uploads/scale_small/2/28140/1561271-hamburger.jpeg",
                        "80"
                )
        );

        items.add(
                new Items(
                        "Hamburger 2",
                        "https://comicvine1.cbsistatic.com/uploads/scale_small/2/28140/1561271-hamburger.jpeg",
                        "80"
                )
        );

        items.add(
                new Items(
                        "Hamburger 3",
                        "https://comicvine1.cbsistatic.com/uploads/scale_small/2/28140/1561271-hamburger.jpeg",
                        "80"
                )
        );

        items.add(
                new Items(
                        "Hamburger 4",
                        "https://comicvine1.cbsistatic.com/uploads/scale_small/2/28140/1561271-hamburger.jpeg",
                        "80"
                )
        );

        items.add(
                new Items(
                        "Hamburger 5",
                        "https://comicvine1.cbsistatic.com/uploads/scale_small/2/28140/1561271-hamburger.jpeg",
                        "80"
                )
        );

        items.add(
                new Items(
                        "Hamburger 6",
                        "https://comicvine1.cbsistatic.com/uploads/scale_small/2/28140/1561271-hamburger.jpeg",
                        "80"
                )
        );

        items.add(
                new Items(
                        "Hamburger 7",
                        "https://comicvine1.cbsistatic.com/uploads/scale_small/2/28140/1561271-hamburger.jpeg",
                        "80"
                )
        );

        return items;
    }

    public static List<Items> getDrinks() {
        final List<Items> items = new ArrayList<>();

        items.add(
                new Items(
                        "Coke",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcX2iF_9zuO-EgP2ABtcaRMUu08bYQYnfIfOhUeLURIplmzNhJQs1ct0hS8THq5pWqIKI&usqp=CAU",
                        "50"
                )
        );

        items.add(
                new Items(
                        "Sprite",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxJxIyt81c5lo70LnzE6bk4RFnft-NCa7OSQYXKRYkCDyxHbTIk3r9R4M6WVl52fuBknE&usqp=CAU",
                        "60"
                )
        );

        return items;
    }

    public static List<Items> getAddOns() {
        final List<Items> items = new ArrayList<>();

        items.add(
                new Items(
                        "Cheese",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbk0RjLR2EjUIStPjxIGPu92IhQSpNuRauuoH54yAOP28zwhXAK6ZbCgLKVgjp1vkv75Q&usqp=CAU",
                        "10"
                )
        );

        items.add(
                new Items(
                        "French Fries",
                        "https://static.toiimg.com/thumb/54659021.cms?width=1200&height=900",
                        "40"
                )
        );

        return items;
    }
}
