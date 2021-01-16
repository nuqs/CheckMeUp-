package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                openParaLogin();
                break;
            case R.id.button2:
                //openDocLogin();
                Intent intent = new Intent(this, doc_current.class);
                startActivity(intent);
                break;
            case R.id.button3:
                openAdminLogin();
                break;
        }
    }

    public void openParaLogin() {
        Intent intent = new Intent(this, para_login.class);
        startActivity(intent);
    }

    public void openDocLogin() {
        Intent intent = new Intent(this, doc_login.class);
        startActivity(intent);
    }

    public void openAdminLogin() {
        Intent intent = new Intent(this, admin_login.class);
        startActivity(intent);
    }
}