package com.example.nourdaghash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);

        // make an array list
        ArrayList<String> arrayList = new ArrayList<>();

        // add item to arrayList
        arrayList.add("Banana");
        arrayList.add("apple");
        //initialize the adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        //connect adapter to array
        listView.setAdapter(arrayAdapter);

        // handle items clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListActivity.this, "clicked item" + i + "" + arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("back button was pressed!");
        dialog.setMessage("are you sure you want to Exit");
        //in case the user chose No,Nothing happens,the dialog class
        dialog.setNegativeButton("No",null);
        //when the user clicks on the yes button the application closes
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ListActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_cake_24);
        AlertDialog alertDialog= dialog.create();
        alertDialog.show();

    }

    //this method loads the menu design into this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //in case user chose about menu
        if(item.getItemId()==R.id.about_menu){
            //open the about activity when the about menu item selected
            Intent i =new Intent(this,AboutActivity.class);
            startActivity(i);
        }
        else if (item.getItemId()==R.id.settings_menu){

        }
        return true;
    }
}