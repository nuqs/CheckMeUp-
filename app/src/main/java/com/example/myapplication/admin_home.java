package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admin_home extends AppCompatActivity implements View.OnClickListener {

    private Button user, ambu, logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        user = findViewById(R.id.user);
        ambu = findViewById(R.id.ambu);
        logout = findViewById(R.id.logout);

        user.setOnClickListener(this);
        ambu.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user:
                openUser();
                break;
            case R.id.ambu:
                openAmbulance();
                break;
            case R.id.logout:
                openLogout();
                break;
        }
    }

    public void openUser() {
        Intent intent = new Intent(this,admin_user_page.class);
        startActivity(intent);
    }

    public void openAmbulance() {
        Intent intent = new Intent(this, admin_ambu_page.class);
        startActivity(intent);
    }

    public void openLogout() {
        Intent intent = new Intent(this, admin_login.class);
        startActivity(intent);
    }

}