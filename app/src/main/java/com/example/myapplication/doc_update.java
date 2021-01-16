package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class doc_update extends AppCompatActivity implements View.OnClickListener{

    Button home, btn_update;
    EditText bp1, bp2, pulse, pain, medic, remarks;
    String sessionID;

    Date date1 = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat(("dd/MM/yyyy"));
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_update);

        home = (Button) findViewById(R.id.home_button);
        btn_update = (Button) findViewById(R.id.btn_update);

        bp1 = findViewById(R.id.systole);
        bp2 = findViewById(R.id.diastole);
        pulse = findViewById(R.id.pulse_rate);
        pain = findViewById(R.id.pain_level);
        medic = findViewById(R.id.medication);
        remarks = findViewById(R.id.remarks);

        home.setOnClickListener(this);
        btn_update.setOnClickListener(this);

        sessionID = getIntent().getStringExtra("ptID");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home_button) {
            openHome();
        }
        else {
            updatePtVital();
        }
    }

    private void updatePtVital() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("patient").child("patientdetails").child("pt_vital");
        String date = dateFormat.format(date1);
        String time = timeFormat.format(date1);
        String pt_bp1 = bp1.getText().toString();
        String pt_bp2 = bp2.getText().toString();
        String pt_pulse = pulse.getText().toString();
        String pt_pain = pain.getText().toString();
        String pt_medic = medic.getText().toString();
        String pt_remarks = remarks.getText().toString();

        if(TextUtils.isEmpty(pt_bp1)) {
            bp1.setError("Systole required");
            return;
        }
        if(TextUtils.isEmpty(pt_bp2)) {
            bp2.setError("Diastole required");
            return;
        }
        if(TextUtils.isEmpty(pt_pulse)) {
            pulse.setError("Pulse rate required");
            return;
        }
        if(TextUtils.isEmpty(pt_pain)) {
            pain.setError("Pain level required");
            return;
        }
        if(Integer.parseInt(pt_pain) > 10 || Integer.parseInt(pt_pain) < 1 ) {
            pain.setError("Invalid input");
        }
        if(TextUtils.isEmpty(pt_medic)) {
            medic.setError("Medications required");
            return;
        }

        PatientVital ptVital = new PatientVital(date, time, pt_bp1, pt_bp2, pt_pulse, pt_pain, pt_medic, pt_remarks);
        reference.child(sessionID).setValue(ptVital);
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, doc_current_ptvital.class);
        intent.putExtra("ptID", sessionID);
        startActivity(intent);
    }

    public void openHome() {
        Intent intent = new Intent(this,doc_home.class);
        startActivity(intent);
    }
}