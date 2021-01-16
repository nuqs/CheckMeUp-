package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class admin_register extends AppCompatActivity implements View.OnClickListener{

    private Button addUser, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        addUser = (Button) findViewById(R.id.add_user);
        home = (Button) findViewById(R.id.home_button);

        addUser.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            openHome();
        }
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("User Created!");
            alert.setMessage("Please wait for a few minutes before accessing into your account");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_SHORT).show();
                    }
            });
            alert.create().show();
        }
    }

    public void openHome() {
        Intent intent = new Intent(this, admin_home.class);
        startActivity(intent);
    }
}