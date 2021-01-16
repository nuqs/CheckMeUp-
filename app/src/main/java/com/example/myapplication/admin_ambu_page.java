package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.graphics.Color.GREEN;

public class admin_ambu_page extends AppCompatActivity implements View.OnClickListener{

    private Button ambu1, ambu2, ambu3, home;
    private CardView cardView1, cardView2, cardView3;
    boolean pwAssigned = false;
    int password1 = (int) (Math.random() * (99999 - 10000 + 1) + 100000), password2 = (int) (Math.random() * (99999 - 10000 + 1) + 100000), password3 = (int) (Math.random() * (99999 - 10000 + 1) + 100000);
    String plateNo;

    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    DatabaseReference reference = rootNode.getReference("users").child("ambulance");

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

        cardView1 = (CardView) findViewById(R.id.badge1);
        cardView2 = (CardView) findViewById(R.id.badge2);
        cardView3 = (CardView) findViewById(R.id.badge3);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.home_button:
                openHome();
                break;
            case R.id.ambu1:
                plateNo = getString(R.string.ambu1_plate);
                storePassword(cardView1, plateNo, ambu1, password1);
                break;
            case R.id.ambu2:
                plateNo = getString(R.string.ambu2_plate);
                storePassword(cardView2, plateNo, ambu2, password2);
                break;
            case R.id.ambu3:
                plateNo = getString(R.string.ambu3_plate);
                storePassword(cardView3, plateNo, ambu3, password3);
                break;
        }
    }

    public void openHome() {
        Intent intent = new Intent(this, admin_home.class);
        startActivity(intent);
    }

    public void storePassword(CardView cardview, String plateNo, Button ambu, int password) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        if(pwAssigned == false) {
            cardview.setCardBackgroundColor(GREEN);
            reference.child(plateNo).child("password").setValue(password);
            alert.setTitle(plateNo + "Activated");
            pwAssigned = true;
        }
        alert.setMessage("Password: " + password);
        alert.create().show();

    }
}
