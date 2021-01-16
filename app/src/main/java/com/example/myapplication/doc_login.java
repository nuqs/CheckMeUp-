package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class doc_login extends AppCompatActivity implements View.OnClickListener{

    private Button home_button,button;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_login);

        home_button = findViewById(R.id.home_button);
        button = findViewById(R.id.button);
        username = findViewById(R.id.login_ambuID);
        password = findViewById(R.id.login_ambuPW);

        home_button.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_button:
                openHome();
                break;
            case R.id.button:
                loginUser(v);
                break;
        }
    }

    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openDocHome() {
        Intent intent = new Intent(this, doc_home.class);
        startActivity(intent);
    }

    private Boolean validateID() {
        String val = username.getText().toString();

        if (val.isEmpty()) {
            username.setError("ID is empty");
            return false;
        } else {
            return true;
        }
    }

    private Boolean validatePW() {
        String val = password.getText().toString();

        if (val.isEmpty()) {
            password.setError("Password is empty");
            return false;
        } else {
            return true;
        }
    }

    private void loginUser(View view) {
        if (!validateID() || !validatePW()){
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        String userEnteredID = username.getText().toString();
        String userEnteredPW = password.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users").child("doctors");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String IDDB = dataSnapshot.child(userEnteredID).child("staffID").getValue().toString();

                if (userEnteredID.equals(IDDB)) {
                    username.setError(null);

                    String passwordDB = dataSnapshot.child(userEnteredID).child("password").getValue().toString();
                    if (passwordDB.equals(userEnteredPW)) {
                        password.setError(null);

                        Toast.makeText(doc_login.this, "Success!", Toast.LENGTH_SHORT).show();
                        openDocHome();
                    } else {
                        Toast.makeText(doc_login.this, "Wrong ID / Password!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    username.setError("Invalid ID" + IDDB + userEnteredID);
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        reference.addListenerForSingleValueEvent(postListener);
    }
}