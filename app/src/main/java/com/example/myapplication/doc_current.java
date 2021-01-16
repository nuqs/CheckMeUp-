package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

public class doc_current extends AppCompatActivity implements View.OnClickListener{

    TableRow pt_details;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_current);

        pt_details = findViewById(R.id.pt_details);
        pt_details.setOnClickListener(this);

        home = (Button) findViewById(R.id.home_button);
        home.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pt_details:
                openDoc_ptDetails();
                break;
            case R.id.home_button:
                openHome();
                break;
        }
    }

    public void openDoc_ptDetails() {
        Intent intent = new Intent(this, doc_current_ptinfo.class);
        startActivity(intent);
    }

    public void openHome() {
        Intent intent = new Intent(this, doc_home.class);
        startActivity(intent);
    }
}