package com.example.rmtc;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class OrderingActivity extends AppCompatActivity {

    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        logout = (TextView) findViewById(R.id.logO);

        String sessionName = PreferenceManager.getDefaultSharedPreferences(this).getString("user_login", "");

        final TextView username = findViewById(R.id.username);

        username.setText(sessionName);

        final TextView number = findViewById(R.id.mobileNumber);


        String randNumber = String.valueOf(100000000 + new Random().nextInt(900000000));

        number.setText("You can call or text our rider for an update: 09" + randNumber);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}