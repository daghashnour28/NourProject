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
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }


    textViewSignInTitle = findViewById(R.id.textViewSignInTitle);
    editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
    editTextTextPassword = findViewById(R.id.editTextTextPassword);
    buttonSignIn = findViewById(R.id.buttonSignIn);
}

    public void login(View view) {
        String input_email = editTextTextEmailAddress.getText().toString();
        String input_password = editTextTextPassword.getText().toString();

        String savedE = preferences.getString("username","");
        String savedP = preferences.getString("password", "");

        if ((input_email.equals(savedE)) && (input_password.equals(savedP)))
        {
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        }
        else {
            if(editTextTextEmailAddress.getText().toString().equals("") &&
                    editTextTextPassword.getText().toString().equals("")) {
                Toast.makeText(this, "Empty Values,Please Insert", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Incorrect Values",Toast.LENGTH_SHORT).show();
            }

        }
    }

    /*
     this method loads the menu design into this activity
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // in case user chose Setting menu
        if (item.getItemId() == R.id.settings_menu) {
            //open the setting activity when the about menu item selected
            //this is from where, and the second parameter is to where
            Intent i = new Intent(this, onMenuItemSelected().class);
            startActivity(i);
        } else if (item.getItemId() == R.id.settings_menu) {
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Back button was pressed!");
        dialog.setMessage("Are you sure you want to Exit");
        // in case the user No, Nothing Happen , the dialog closes
        dialog.setNegativeButton("No", null);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SignInActivity.this.finish();
            }
        });
        // dialog.setIcon(R.drawable.ic_baseline_whatshot_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    public void register(View view) {
        Intent i_register = new Intent(this, MainActivity2.class);
        startActivity(i_register);

    }




}