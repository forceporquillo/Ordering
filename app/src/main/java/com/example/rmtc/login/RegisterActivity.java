package com.example.rmtc.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rmtc.BaseActivity;
import com.example.rmtc.MainActivity;
import com.example.rmtc.R;
import com.example.rmtc.User;
import com.example.rmtc.db.LiveDataHelper;
import com.example.rmtc.db.UserRepository;

public class RegisterActivity extends BaseActivity {

    EditText username, password, cpassword, fullname, address, email, phone;
    TextView login, main;
    Button register;

    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userRepository = new UserRepository(getApplication());

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        fullname = (EditText) findViewById(R.id.fullname);
        address = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        register = (Button) findViewById(R.id.btnreg);
        login = (TextView) findViewById(R.id.btnlogin);
        main = (TextView) findViewById(R.id.main);

        register.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String cpass = cpassword.getText().toString();
            String full = fullname.getText().toString();
            String add = address.getText().toString();
            String email1 = email.getText().toString();
            String phone1 = phone.getText().toString();

            if(user.equals("") || pass.equals(""))
                Toast.makeText(RegisterActivity.this, "Please Enter all fields" , Toast.LENGTH_SHORT).show();
            else {
                if (pass.equals(cpass)) {
                    final User mUser = new User(user, full, pass, cpass, add, email1, phone1);
                    Log.e(null, user);
                    checkUser(mUser);
                } else {
                    displayToast("Password doesn't match");
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LoginActivity.class, true);
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.class, true);
            }
        });
    }

    private void saveUser(final User user) {
        displayToast("Registered Successfully");
        userRepository.setUser(user);
        startActivity(LoginActivity.class, true);
    }

    private void checkUser(final User _user) {
        LiveDataHelper.observeOnce(userRepository.getUserLiveData(), users -> {
            if (users.size() > 0) {
                for (User user : users) {
                    if (user.getUsername().equals(_user.getUsername())) {
                        displayToast("User already exists");
                        break;
                    } else {
                        saveUser(_user);
                    }
                }
                return;
            }
            saveUser(_user);
        });
    }
}