package com.example.rmtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {

    Button checkout;
    TextView totalC, qtyCB1, qtyCB2, qtyCB3, qtyCD1, qtyCD2, qtyCA1, qtyCA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkout = (Button) findViewById(R.id.check);
        totalC = (TextView) findViewById(R.id.totalC);
        qtyCB1 = (TextView) findViewById(R.id.qtycb1);
        qtyCB2 = (TextView) findViewById(R.id.qtycb2);
        qtyCB3 = (TextView) findViewById(R.id.qtycb3);
        qtyCD1 = (TextView) findViewById(R.id.qtycd1);
        qtyCD2 = (TextView) findViewById(R.id.qtycd2);
        qtyCA1 = (TextView) findViewById(R.id.qtyca1);
        qtyCA2 = (TextView) findViewById(R.id.qtyca2);
        ProgressBar process = findViewById(R.id.process);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkout.setText("Processing");
                process.setVisibility(View.VISIBLE);

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        checkout.setText("Order Processed...");
                        process.setVisibility(View.INVISIBLE);
                        checkout.setTextColor(Color.parseColor("#3DDC84"));
                        startActivity(new Intent(getApplicationContext(), OrderingActivity.class));
                    }
                },4000);
            }
        });

        Intent cIntent = getIntent();
        int totalBDA = cIntent.getIntExtra("totalBDA", 0);
        int qtyb1 = cIntent.getIntExtra("qtyb1", 0);
        int qtyb2 = cIntent.getIntExtra("qtyb2", 0);
        int qtyb3 = cIntent.getIntExtra("qtyb3", 0);
        int qtyd1 = cIntent.getIntExtra("qtyd1", 0);
        int qtyd2 = cIntent.getIntExtra("qtyd2", 0);
        int qtya1 = cIntent.getIntExtra("qtya1", 0);
        int qtya2 = cIntent.getIntExtra("qtya2", 0);
        totalC.setText("Total Price: " + String.valueOf(totalBDA));
        if(qtyb1 > 0){
            qtyCB1.setText("Hamburger                Qty: " + String.valueOf(qtyb1));
        }
        else if(qtyb1 == 0){
            qtyCB1.setVisibility(View.GONE);
        }
        if(qtyb2 > 0){
            qtyCB2.setText("Cheeseburger         Qty: " + String.valueOf(qtyb2));
        }
        else if(qtyb2 == 0){
            qtyCB2.setVisibility(View.GONE);
        }
        if(qtyb3 > 0){
            qtyCB3.setText("Bacon-Cheeseburger Qty: " + String.valueOf(qtyb3));
        }
        else if(qtyb3 == 0){
            qtyCB3.setVisibility(View.GONE);
        }
        if(qtyd1 > 0){
            qtyCD1.setText("Coke                                Qty: " + String.valueOf(qtyd1));
        }
        else if(qtyd1 == 0){
            qtyCD1.setVisibility(View.GONE);
        }
        if(qtyd2 > 0){
            qtyCD2.setText("Sprite                              Qty: " + String.valueOf(qtyd2));
        }
        else if(qtyd2 == 0){
            qtyCD2.setVisibility(View.GONE);
        }
        if(qtya1 > 0){
            qtyCA1.setText("Extra Cheese            Qty: " + String.valueOf(qtya1));
        }
        else if(qtya1 == 0){
            qtyCA1.setVisibility(View.GONE);
        }
        if(qtya2 > 0){
            qtyCA2.setText("French Fries              Qty: " + String.valueOf(qtya2));
        }
        else if(qtya2 == 0){
            qtyCA2.setVisibility(View.GONE);
        }
    }
}