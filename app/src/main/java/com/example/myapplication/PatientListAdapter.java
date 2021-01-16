package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PatientListAdapter extends ArrayAdapter<Patient> {
    private Context mContext;
    int mResource;

    public PatientListAdapter(@NonNull Context context, int resource, ArrayList <Patient> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String ptID = getItem(position).getPtID();
        String roomNo = getItem(position).getRoomNo();
        String ptName = getItem(position).getPtName();

        Patient patient = new Patient(ptID, roomNo, ptName);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvID = convertView.findViewById(R.id.row_ptID);
        TextView tvRoomNo = convertView.findViewById(R.id.row_ptRoom);
        TextView tvName = convertView.findViewById(R.id.row_ptName);

        tvID.setText(ptID);
        tvRoomNo.setText(roomNo);
        tvName.setText(ptName);

        return convertView;
    }
}
