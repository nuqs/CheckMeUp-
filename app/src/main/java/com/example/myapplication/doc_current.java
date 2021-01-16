package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class doc_current extends AppCompatActivity implements View.OnClickListener{

    Button home;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_current);

        listView = findViewById(R.id.listView);
        home = (Button) findViewById(R.id.home_button);
        home.setOnClickListener(this);

        ArrayList <Patient> list = new ArrayList <>();
        ArrayList <String>listID = new <String>ArrayList();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("patient").child("patientdetails").child("pt_info");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String pt_id = ds.child("pt_ID").getValue().toString();
                    String pt_roomNo = ds.child("pt_roomNo").getValue().toString();
                    String pt_Name = ds.child("pt_name").getValue().toString();

                    Patient patient = new Patient(pt_id, pt_roomNo, pt_Name);
                    list.add(patient);
                    listID.add(pt_id);
                }
                PatientListAdapter adapter = new PatientListAdapter(getApplicationContext(), R.layout.list_item_patient, list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };

        reference.addValueEventListener(eventListener);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), doc_current_ptinfo.class);
                    intent.putExtra("ptID", listID.get(position));
                    startActivity(intent);
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                openHome();
                break;
        }
    }

    public void openHome() {
        Intent intent = new Intent(this, doc_home.class);
        startActivity(intent);
    }
}