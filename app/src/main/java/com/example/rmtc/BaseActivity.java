package com.example.rmtc;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void displayToast(final String message) {
        Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected <T> void startActivity(final Class<T> tClass, final boolean finish) {
        Intent intent = new Intent(getApplicationContext(), tClass);
        startActivity(intent);

        if (finish) {
            finish();
        }
    }

}
