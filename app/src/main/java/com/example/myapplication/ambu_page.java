package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ambu_page extends AppCompatActivity implements View.OnClickListener{

    private Button ambu1, ambu2, ambu3, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambu_page);

        ambu1 = (Button) findViewById(R.id.ambu1);
        ambu2 = (Button) findViewById(R.id.ambu2);
        ambu3 = (Button) findViewById(R.id.ambu3);
        home = (Button) findViewById(R.id.home_button);

        ambu1.setOnClickListener(this);
        ambu2.setOnClickListener(this);
        ambu3.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.home_button) {
            openHome();
        }
        else {
            int password = (int) (Math.random() * (99999 - 10000 + 1) + 100000);
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("This is the password");
            alert.setMessage("Password: " + password);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    CardView cardView1 = (CardView) findViewById(R.id.badge1);
                    CardView cardView2 = (CardView) findViewById(R.id.badge2);
                    CardView cardView3 = (CardView) findViewById(R.id.badge3);

                    switch(v.getId()) {
                        case R.id.ambu1:
                            cardView1.setCardBackgroundColor(Color.GREEN);
                            Toast.makeText(getApplicationContext(), "Activated", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.ambu2:
                            cardView2.setCardBackgroundColor(Color.GREEN);
                            break;
                        case R.id.ambu3:
                            cardView3.setCardBackgroundColor(Color.GREEN);
                            break;
                        case R.id.home_button:

                            break;
                    }

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
