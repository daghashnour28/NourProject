package com.example.nourdaghash.;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonregister;
    EditText editTextTextEmailAddress, editTextTextPassword;
    Button buttonlogin;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextEmailAddress = findViewById(R.id.editTextEmail);
        editTextTextPassword = findViewById(R.id.editTextPassword);
        buttonlogin = findViewById(R.id.buttonLogin);

        preferences = getSharedPreferences("userinfo", 0);
    }

    public void login(View view) {
        String input_mail = editTextTextEmailAddress.getText().toString();
        String input_password = editTextTextEmailAddress.getText().toString();

        String savedE = preferences.getString("username","");
        String savedP = preferences.getString("password", "");

        if ((input_mail.equals(savedE)) && (input_password.equals(savedP)))
        {
            Intent i = new Intent(this, CategoryActivity.class);
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
        getMenuInflater().inflate(R.menu.menu, menu);
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
        } else if (item.getItemId() == R.id.help_menu) {
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
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_whatshot_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    public void register(View view) {
        Intent i_register = new Intent(this, RegisterActivity.class);
        startActivity(i_register);

    }
}