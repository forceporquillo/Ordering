package com.example.rmtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Burgers extends AppCompatActivity {

    Button viewCB, addCB;
    CheckBox chbrg, hmbrg, bcbrg;
    int priceB, totalB, qtyb1, qtyb2, qtyb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burgers);

        viewCB = (Button) findViewById(R.id.viewCB);
        addCB = (Button) findViewById(R.id.addCB);
        chbrg = (CheckBox) findViewById(R.id.chbrg);
        hmbrg = (CheckBox) findViewById(R.id.hmbrg);
        bcbrg = (CheckBox) findViewById(R.id.bcbrg);


        viewCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Checkout.class);
                startActivity(intent);
            }
        });

        addCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(hmbrg.isChecked() && chbrg.isChecked() && bcbrg.isChecked()){
                    if(hmbrg.isChecked() && chbrg.isChecked() && bcbrg.isChecked()) {
                        qtyb1++;
                        qtyb2++;
                        qtyb3++;
                    }
                    priceB = 80 + 100 + 120;
                    totalB = totalB + priceB;
                }
                else if(hmbrg.isChecked() && chbrg.isChecked()){
                    if(hmbrg.isChecked() && chbrg.isChecked()){
                        qtyb1++;
                        qtyb2++;
                    }
                    priceB = 80 + 100;
                    totalB = totalB + priceB;
                }
                else if(hmbrg.isChecked() && bcbrg.isChecked()){
                    if(hmbrg.isChecked() && bcbrg.isChecked()){
                        qtyb1++;
                        qtyb3++;
                    }
                    priceB = 80 + 120;
                    totalB = totalB + priceB;
                }
                else if(chbrg.isChecked() && bcbrg.isChecked()){
                    if(chbrg.isChecked() && bcbrg.isChecked()){
                        qtyb2++;
                        qtyb3++;
                    }
                    priceB = 100 + 120;
                    totalB = totalB + priceB;
                }
                else if(hmbrg.isChecked()){
                    if(hmbrg.isChecked()){
                        qtyb1++;
                    }
                    priceB = 80;
                    totalB = totalB + priceB;
                }
                else if(chbrg.isChecked()){
                    if(chbrg.isChecked()){
                        qtyb2++;
                    }
                    priceB = 100;
                    totalB = totalB + priceB;
                }
                else if(bcbrg.isChecked()){
                    if(bcbrg.isChecked()){
                        qtyb3++;
                    }
                    priceB = 120;
                    totalB = totalB + priceB;
                }
                Toast.makeText(Burgers.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Burgers.this, Drinks.class);
                intent.putExtra("totalB", totalB);
                intent.putExtra("qtyb1", qtyb1);
                intent.putExtra("qtyb2", qtyb2);
                intent.putExtra("qtyb3", qtyb3);
                startActivity(intent);
            }

        });

    }
}