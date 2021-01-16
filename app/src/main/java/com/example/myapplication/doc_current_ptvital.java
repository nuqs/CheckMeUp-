package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class doc_current_ptvital extends AppCompatActivity implements View.OnClickListener{

    Button home, btn_ptinfo, btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_current_ptvital);

        home = (Button) findViewById(R.id.home_button);
        btn_ptinfo = (Button) findViewById(R.id.btn_info);
        btn_update = (Button) findViewById(R.id.btn_update);

        home.setOnClickListener(this);
        btn_ptinfo.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                openHome();
                break;
            case R.id.btn_info:
                openPtInfo();
                break;
            case R.id.btn_update:
                openDocUpdate();
                break;
        }
    }

    public void openHome() {
        Intent intent = new Intent(this,doc_home.class);
        startActivity(intent);
    }

    public void openPtInfo() {
        Intent intent = new Intent(this, doc_current_ptinfo.class);
        startActivity(intent);
    }

    public void openDocUpdate() {
        Intent intent = new Intent(this, doc_update.class);
        startActivity(intent);
    }
}