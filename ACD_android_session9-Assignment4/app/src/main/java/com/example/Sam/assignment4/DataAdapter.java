package com.example.Sam.assignment4;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Sam Prakash on 03/10/16.
 */

public class DataAdapter extends BaseAdapter {

    Context context;
    ArrayList<Details> arrayList;
    LayoutInflater layoutInflater;

    public DataAdapter(Context context, ArrayList<Details> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Details mdetails = new Details();

        convertView= layoutInflater.inflate(R.layout.custom_listview,parent,false);

        TextView name= (TextView)convertView.findViewById(R.id.name_textView);
        TextView phone= (TextView)convertView.findViewById(R.id.phone_textView);
        TextView dob= (TextView)convertView.findViewById(R.id.dob_textView);

        name.setText(arrayList.get(position).getName());
        phone.setText(arrayList.get(position).getPhone());
        dob.setText(arrayList.get(position).getDob());



        return convertView;

    }
}









