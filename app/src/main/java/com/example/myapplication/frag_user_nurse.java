package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class frag_user_nurse extends Fragment {

    Button button1, button2, button3, home;
    ListView listView;

    public frag_user_nurse() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_frag_user_nurse, container, false);

        button1 = v.findViewById(R.id.admin_doc);
        button2 = v.findViewById(R.id.admin_nurse);
        button3 = v.findViewById(R.id.admin_para);

        listView = v.findViewById(R.id.listView);

        //open nurse
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag_user_nurse secondFragment = new frag_user_nurse();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.admin_user_page, secondFragment);
                transaction.commit();
            }
        });

        //open para
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                frag_user_para thirdFragment = new frag_user_para();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.admin_user_page, thirdFragment);
                transaction.commit();
            }
        });

        //open doc
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                frag_user_doc firstFragment = new frag_user_doc();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.admin_user_page, firstFragment);
                transaction.commit();
            }
        });

        ArrayList <User> list = new ArrayList <>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users").child("nurses");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String staffID = ds.child("staffID").getValue().toString();
                    String staffName = ds.child("staffName").getValue().toString();
                    User user = new User(staffID, staffName);
                    list.add(user);
                }
                UserListAdapter adapter = new UserListAdapter(getContext(), R.layout.list_item, list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };

        reference.addValueEventListener(eventListener);

        return v;
    }
}