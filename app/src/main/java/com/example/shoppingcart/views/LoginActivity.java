package com.example.shoppingcart.views;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingcart.R;

public class LoginActivity  extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextView loginButton = (TextView) findViewById(R.id.login_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text1 = (EditText) findViewById(R.id.email_input);
                String email = text1.getText().toString();

                EditText text2 = (EditText) findViewById(R.id.password_input);
                String password = text2.getText().toString();

                // Toast.makeText(getBaseContext(), email + " " + password, Toast.LENGTH_LONG).show();
                if (email.equals("user@canteenapp.com") && password.equals("ssssssss")) {
                    Toast.makeText(getBaseContext(), "Logged in Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent( getBaseContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Incorrect email or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


