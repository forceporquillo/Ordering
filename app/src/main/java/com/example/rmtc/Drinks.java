package com.example.rmtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Drinks extends AppCompatActivity {

    Button viewCD, addCD;
    CheckBox sprite, coke;
    int priceD, totalD, qtyd1, qtyd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        viewCD = (Button) findViewById(R.id.viewCD);
        addCD = (Button) findViewById(R.id.addCD);
        sprite = (CheckBox) findViewById(R.id.sprite);
        coke = (CheckBox) findViewById(R.id.coke);

        viewCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Checkout.class);
                startActivity(intent);
            }
        });

        addCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coke.isChecked() && sprite.isChecked()){
                    if(coke.isChecked() && sprite.isChecked()){
                        qtyd1++;
                        qtyd2++;
                    }
                    priceD = 60 + 50;
                    totalD = totalD + priceD;
                }
                else if(coke.isChecked()){
                    if(coke.isChecked()){
                        qtyd1++;
                    }
                    priceD = 50;
                    totalD = totalD + priceD;
                }
                else if(sprite.isChecked()){
                    if(sprite.isChecked()){
                        qtyd2++;
                    }
                    priceD = 60;
                    totalD = totalD + priceD;
                }
                Toast.makeText(Drinks.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                Intent dIntent = getIntent();
                int totalB = dIntent.getIntExtra("totalB", 0);
                int qtyb1 = dIntent.getIntExtra("qtyb1", 0);
                int qtyb2 = dIntent.getIntExtra("qtyb2", 0);
                int qtyb3 = dIntent.getIntExtra("qtyb3", 0);
                int totalBD = totalB + totalD;
                Intent intent = new Intent(Drinks.this, Addons.class);
                intent.putExtra("totalBD", totalBD);
                intent.putExtra("qtyb1", qtyb1);
                intent.putExtra("qtyb2", qtyb2);
                intent.putExtra("qtyb3", qtyb3);
                intent.putExtra("qtyd1", qtyd1);
                intent.putExtra("qtyd2", qtyd2);
                startActivity(intent);
            }
        });
    }
}
