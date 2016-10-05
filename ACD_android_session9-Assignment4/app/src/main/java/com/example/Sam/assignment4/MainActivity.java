package com.example.Sam.assignment4;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mlistView;
    ArrayList<Details> details;
    DataAdapter dataAdapter;

    String name_str,phone_str,dob_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistView = (ListView)findViewById(R.id.listView);
        details=new ArrayList<Details>();



        dataAdapter= new DataAdapter(this,details);
        mlistView.setAdapter(dataAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        View view;

        switch(item.getItemId()){

            case R.id.add_menu:

                final AlertDialog.Builder addDialog = new AlertDialog.Builder(this);
                LayoutInflater inflater = LayoutInflater.from(this);
                view=  inflater.inflate(R.layout.dialogue_layout,null);

                addDialog.setTitle("Add the Details");


                final EditText name = (EditText)view.findViewById(R.id.name_editText);
                final EditText phone = (EditText)view.findViewById(R.id.phone_editText);
                final EditText dob = (EditText)view.findViewById(R.id.dob_editText);

                Button save =(Button)view.findViewById(R.id.save_button);
                Button cancel =(Button)view.findViewById(R.id.cancel_button);

                final AlertDialog alertDialog = addDialog.create();
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        name_str=name.getText().toString();
                        phone_str=phone.getText().toString();
                        dob_str=dob.getText().toString();

                        Details d = new Details(name_str,phone_str,dob_str);
                        details.add(d);

                        dataAdapter.notifyDataSetChanged();

                        Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();


                    }


                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Toast.makeText(MainActivity.this,"Cancelled",Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }

                });
                alertDialog.setView(view);
                alertDialog.show();

        }



        return true;
    }
}