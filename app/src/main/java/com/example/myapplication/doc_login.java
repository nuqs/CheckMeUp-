package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class doc_login extends AppCompatActivity implements View.OnClickListener{

    private Button home_button,button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_login);

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
                openDocHome();
                break;
        }
    }

    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openDocHome() {
        Intent intent = new Intent(this, doc_home.class);
        startActivity(intent);
    }
}