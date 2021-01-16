package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class doc_current_ptinfo extends AppCompatActivity implements View.OnClickListener {

    Button home, btn_ptVital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_current_ptinfo);

        home = (Button) findViewById(R.id.home_button);
        btn_ptVital = (Button) findViewById(R.id.btn_vital);

        home.setOnClickListener(this);
        btn_ptVital.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                openHome();
                break;
            case R.id.btn_vital:
                openPtVital();
                break;
        }
    }

    public void openHome() {
        Intent intent = new Intent(this,doc_home.class);
        startActivity(intent);
    }

    public void openPtVital() {
        Intent intent = new Intent(this, doc_current_ptvital.class);
        startActivity(intent);
    }

}