package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class frag_user_doc extends Fragment{

    Button button1, button2, button3, home;

    public frag_user_doc() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_frag_user_doc, container, false);

        button1 = v.findViewById(R.id.admin_doc);
        button2 = v.findViewById(R.id.admin_nurse);
        button3 = v.findViewById(R.id.admin_para);

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


        return v;
    }
}