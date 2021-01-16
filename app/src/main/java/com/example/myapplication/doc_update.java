package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class doc_update extends AppCompatActivity implements View.OnClickListener{

    Button home, btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_update);

        home = (Button) findViewById(R.id.home_button);
        btn_update = (Button) findViewById(R.id.btn_update);

        home.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            openHome();
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Checkup updated!");
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    openPtVital();
                }
            });
            builder.create().show();
        }
    }

    public void openPtVital() {
        Toast.makeText(getApplicationContext(), "Updated!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, doc_current_ptvital.class);
        startActivity(intent);
    }

    public void openHome() {
        Intent intent = new Intent(this,doc_home.class);
        startActivity(intent);
    }
}