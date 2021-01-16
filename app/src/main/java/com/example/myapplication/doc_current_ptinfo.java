package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class doc_current_ptinfo extends AppCompatActivity implements View.OnClickListener {

    Button home, btn_ptVital;
    TextView pt_IDDB, pt_nameDB, pt_genderDB, pt_raceDB, pt_ageDB, pt_roomNoDB, pt_dateDB, pt_injuryDB;
    String sessionID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_current_ptinfo);

        home = (Button) findViewById(R.id.home_button);
        btn_ptVital = (Button) findViewById(R.id.btn_vital);

        pt_IDDB = findViewById(R.id.pt_IDDB);
        pt_nameDB = findViewById(R.id.pt_nameDB);
        pt_genderDB = findViewById(R.id.pt_genderDB);
        pt_raceDB = findViewById(R.id.pt_raceDB);
        pt_ageDB = findViewById(R.id.pt_ageDB);
        pt_roomNoDB = findViewById(R.id.pt_roomNoDB);
        pt_dateDB = findViewById(R.id.pt_dateDB);
        pt_injuryDB = findViewById(R.id.pt_injuryDB);

        sessionID = getIntent().getStringExtra("ptID");

        home.setOnClickListener(this);
        btn_ptVital.setOnClickListener(this);
        pt_IDDB.setOnClickListener(this);
        pt_nameDB.setOnClickListener(this);
        pt_genderDB.setOnClickListener(this);
        pt_raceDB.setOnClickListener(this);
        pt_ageDB.setOnClickListener(this);
        pt_roomNoDB.setOnClickListener(this);
        pt_dateDB.setOnClickListener(this);
        pt_injuryDB.setOnClickListener(this);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("patient").child("patientdetails").child("pt_info").child(sessionID);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot ds) {
                    String patientID = ds.child("pt_ID").getValue().toString();
                    String patientName = ds.child("pt_name").getValue().toString();
                    String patientGender = ds.child("pt_gender").getValue().toString();
                    String patientRace = ds.child("pt_race").getValue().toString();
                    String patientAge = ds.child("pt_age").getValue().toString();
                    String patientRoom = ds.child("pt_roomNo").getValue().toString();
                    String patientDate = ds.child("pt_date").getValue().toString();
                    String patientInjury = ds.child("pt_injury").getValue().toString();

                    pt_IDDB.setText(patientID);
                    pt_nameDB.setText(patientName);
                    pt_genderDB.setText(patientGender);
                    pt_raceDB.setText(patientRace);
                    pt_ageDB.setText(patientAge);
                    pt_roomNoDB.setText(patientRoom);
                    pt_dateDB.setText(patientDate);
                    pt_injuryDB.setText(patientInjury);
                    //PatientInfo patientInfo = new PatientInfo(patientID, patientName, patientGender, patientRace, patientAge, patientRoom, patientDate, patientInjury);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };

        reference.addValueEventListener(eventListener);
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
        intent.putExtra("ptID", sessionID);
        startActivity(intent);
    }

}