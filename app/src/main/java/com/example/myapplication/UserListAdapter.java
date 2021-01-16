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

public class UserListAdapter extends ArrayAdapter<User> {

    private Context mContext;
    int mResource;

    public UserListAdapter(@NonNull Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String staffID = getItem(position).getStaffID();
        String staffName = getItem(position).getStaffName();

        User user = new User(staffID, staffName);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvID = convertView.findViewById(R.id.row_staffID);
        TextView tvName = convertView.findViewById(R.id.row_staffName);

        tvID.setText(staffID);
        tvName.setText(staffName);

        return convertView;
    }
}
