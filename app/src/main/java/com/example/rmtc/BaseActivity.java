package com.example.rmtc;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Base class from the activity which contains a helper function for starting an activity.
 */
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
