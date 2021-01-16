package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class doc_home extends AppCompatActivity implements View.OnClickListener {

    Button btIncoming, btCurrent, btUpdate, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_home);

        btIncoming = findViewById(R.id.btIncoming);
        btCurrent = findViewById(R.id.btCurrent);
        logout = findViewById(R.id.logout);

        btIncoming.setOnClickListener(this);
        btCurrent.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btIncoming:
                openIncoming();
                break;
            case R.id.btCurrent:
                openCurrent();
                break;
            case R.id.logout:
                openLogout();
                break;
        }
    }

    public void openIncoming() {
        Intent intent = new Intent(this,doc_incoming.class);
        startActivity(intent);
    }

    public void openCurrent() {
        Intent intent = new Intent(this, doc_current.class);
        startActivity(intent);
    }

    public void openLogout() {
        Intent intent = new Intent(this, doc_login.class);
        startActivity(intent);
    }
}