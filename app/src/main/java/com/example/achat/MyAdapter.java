package com.example.achat;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;


class MyAdapter extends ArrayAdapter<purshase> {


    private Context context;
    private int resource;


    public MyAdapter(Context context , int resource, ArrayList<purshase> object) {
        super(context, resource,object);
        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
       String product = getItem(position).getItem();
       String quantity = getItem(position).getQte();

       purshase purshase = new purshase(product,quantity);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);

        TextView tvproduct = (TextView) convertView.findViewById(R.id.txt1);
        TextView tvqyantity = (TextView) convertView.findViewById(R.id.txt2);

    tvproduct.setText(product);
    tvqyantity.setText(quantity);
     return convertView;



    }



}