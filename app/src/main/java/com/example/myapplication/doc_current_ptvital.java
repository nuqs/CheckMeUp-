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

public class doc_current_ptvital extends AppCompatActivity implements View.OnClickListener{

    Button home, btn_ptinfo, btn_update;
    String sessionID;
    TextView pt_dateDB, pt_timeDB, pt_bp1DB, pt_bp2DB, pt_pulserateDB, pt_painlevelDB, pt_medicationDB, pt_remarksDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_current_ptvital);

        home = (Button) findViewById(R.id.home_button);
        btn_ptinfo = (Button) findViewById(R.id.btn_info);
        btn_update = (Button) findViewById(R.id.btn_update);

        pt_dateDB = findViewById(R.id.pt_dateDB);
        pt_timeDB = findViewById(R.id.pt_timeDB);
        pt_bp1DB = findViewById(R.id.pt_bp1DB);
        pt_bp2DB = findViewById(R.id.pt_bp2DB);
        pt_pulserateDB = findViewById(R.id.pt_pulserateDB);
        pt_painlevelDB = findViewById(R.id.pt_painlevelDB);
        pt_medicationDB = findViewById(R.id.pt_medicationDB);
        pt_remarksDB = findViewById(R.id.pt_remarksDB);

        home.setOnClickListener(this);
        btn_ptinfo.setOnClickListener(this);
        btn_update.setOnClickListener(this);

        sessionID = getIntent().getStringExtra("ptID");

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("patient").child("patientdetails").child("pt_vital").child(sessionID);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot ds) {
                if(ds.exists()) {
                    String date = ds.child("date").getValue().toString();
                    String time = ds.child("time").getValue().toString();
                    String bp1 = ds.child("bp1").getValue().toString();
                    String bp2 = ds.child("bp2").getValue().toString();
                    String pulse = ds.child("pulse").getValue().toString();
                    String pain = ds.child("pain").getValue().toString();
                    String medic = ds.child("medication").getValue().toString();
                    String remark = ds.child("remarks").getValue().toString();

                    pt_dateDB.setText(date);
                    pt_timeDB.setText(time);
                    pt_bp1DB.setText(bp1);
                    pt_bp2DB.setText(bp2);
                    pt_pulserateDB.setText(pulse);
                    pt_painlevelDB.setText(pain);
                    pt_medicationDB.setText(medic);
                    pt_remarksDB.setText(remark);
                } else {
                    pt_dateDB.setText(R.string.null_value);
                    pt_timeDB.setText(R.string.null_value);
                    pt_bp1DB.setText(R.string.null_value);
                    pt_bp2DB.setText(R.string.null_value);
                    pt_pulserateDB.setText(R.string.null_value);
                    pt_painlevelDB.setText(R.string.null_value);
                    pt_medicationDB.setText(R.string.null_value);
                    pt_remarksDB.setText(R.string.null_value);
                }

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
        intent.putExtra("ptID", sessionID);
        startActivity(intent);
    }

    public void openDocUpdate() {
        Intent intent = new Intent(this, doc_update.class);
        intent.putExtra("ptID", sessionID);
        startActivity(intent);
    }
}