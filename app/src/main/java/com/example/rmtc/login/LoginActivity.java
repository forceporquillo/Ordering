package com.example.rmtc.login;

import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rmtc.BaseActivity;
import com.example.rmtc.home.HomeActivity;
import com.example.rmtc.MainActivity;
import com.example.rmtc.R;
import com.example.rmtc.User;
import com.example.rmtc.db.UserRepository;

public class LoginActivity extends BaseActivity {

    EditText username, password;
    TextView register, main;
    Button btnlogin;

    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // create instance of user repository
        userRepository = new UserRepository(getApplication());

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnlogin1);
        register = (TextView) findViewById(R.id.btnreg1);
        main = (TextView) findViewById(R.id.main1);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    // check if user exist, otherwise start an intent.
                    userRepository.getCurrentUser(user, pass).observe(LoginActivity.this, _user -> {
                        if(_user != null){
                            Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            storeUserAsSession(user);
                            startActivity(HomeActivity.class, true);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        register.setOnClickListener(v -> startActivity(RegisterActivity.class, true));
        main.setOnClickListener(v -> startActivity(MainActivity.class, true));
    }

    @SuppressWarnings("deprecation")
    private void storeUserAsSession(final String username) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("user_login", username).apply();
    }
}