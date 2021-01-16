package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_login extends AppCompatActivity implements View.OnClickListener {

    private Button home_button;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        home_button = findViewById(R.id.home_button);
        button = findViewById(R.id.button);

        home_button.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                openHome();
                break;
            case R.id.button:
                openAdminHome();
                break;
        }
    }

    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openAdminHome() {
        Intent intent = new Intent(this, admin_home.class);
        startActivity(intent);
    }

}