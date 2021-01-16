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

public class admin_register extends AppCompatActivity implements View.OnClickListener{

    private Button addUser, home;
    EditText input_staffName, input_staffID, input_password, input_cpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        addUser = (Button) findViewById(R.id.add_user);
        home = (Button) findViewById(R.id.home_button);
        input_staffName = findViewById(R.id.input_staff_name);
        input_staffID = findViewById(R.id.input_staff_id);
        input_password = findViewById(R.id.input_password);
        input_cpassword = findViewById(R.id.input_confirm_password);

        addUser.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_user:
                addUser();
                break;
            case R.id.home_button:
                openHome();
                break;
        }
    }

    private void addUser() {
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("users");
        String staffName = input_staffName.getText().toString();
        String staffID = input_staffID.getText().toString();
        String password = input_password.getText().toString();
        String cpassword = input_cpassword.getText().toString();

        int temp, min = 180000, max = 210000;

        if(TextUtils.isEmpty(staffName)) {
            input_staffName.setError("Staff name is required");
            return;
        }
        if(TextUtils.isEmpty(staffID)) {
            input_staffID.setError("Staff ID is required");
            return;
        }
        temp = Integer.parseInt(staffID);
        if (staffID.length() != 6 || temp < min || temp > max){
            input_staffID.setError("Invalid ID");
            return;
        }
        if(TextUtils.isEmpty(password)) {
            input_password.setError("Password is required");
            return;
        }
        if(password.length() < 7) {
            input_password.setError("Password must be more that 7 characters");
            return;
        }
        if(TextUtils.isEmpty(cpassword)) {
            input_cpassword.setError("Password is required");
            return;
        }
        if (TextUtils.equals(cpassword, password)) {
        }
        else {
            input_cpassword.setError("Password does not match");
            return;
        }

        UserHelperClass helperClass = new UserHelperClass(staffName, staffID, password);
        if (temp >= 180000 || temp < 190000){
            reference.child("paramedics").child(staffID).setValue(helperClass);
        }
        else if (temp >= 190000 || temp < 200000){
            reference.child("nurses").child(staffID).setValue(helperClass);
        }
        else if (temp >= 200000 || temp < 210000){
            reference.child("doctors").child(staffID).setValue(helperClass);
        }
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, admin_user_page.class);
        startActivity(intent);
    }

    public void openHome() {
        Intent intent = new Intent(this, admin_home.class);
        startActivity(intent);
    }
}