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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber,editTextNumber2;
    Button buttonbplus,buttonminus;
    TextView textviewresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            Intent i=new Intent(this,AboutActivity.class);
            startActivity(i);
        }else if (item.getItemId()==R.id.settings_menu){

        }
        return true;
    }
    public void goToLogIn(View view){
        Intent i = new Intent(this, registerActivityLifecycleCallbacks().class);
        startActivity(i);
    }

    public void signup(View view){
        Intent i = new Intent(this, signUp.class);
        startActivity(i);
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
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_cake_24);
        AlertDialog alertDialog= dialog.create();
        alertDialog.show();

    }
}