package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class user_page extends AppCompatActivity implements View.OnClickListener{

    Button home, addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        frag_user_doc firstFragment = new frag_user_doc();
        FragmentManager manager = getSupportFragmentManager();

        getSupportFragmentManager().beginTransaction().add(R.id.admin_user_page, firstFragment).commit();

        home = (Button) findViewById(R.id.home_button);
        addUser = (Button) findViewById(R.id.add_user);

        home.setOnClickListener(this);
        addUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            openHome();
        }
        if (v.getId() == R.id.add_user) {
            openRegistration();
        }
    }

    public void openHome() {
        Intent intent = new Intent(this, admin_home.class);
        startActivity(intent);
    }

    public void openRegistration() {
        Intent intent = new Intent(this, admin_register.class);
        startActivity(intent);
    }
}