package com.example.nourdaghash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class SignInActivity extends AppCompatActivity {
    private TextView textViewSignInTitle;
    private EditText editTextTextEmailAddress, editTextTextPassword;
    private Button buttonSignIn;

    private final String valid_email = "admin";
    private final String valid_password = "1";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        textViewSignInTitle = findViewById(R.id.textViewSignInTitle);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);

        preferences = getSharedPreferences("UserInfo", 0);
    }

    public void signIn(View view) {
        String input_email = editTextTextEmailAddress.getText().toString();
        String input_password = editTextTextPassword.getText().toString();

        String savedE = preferences.getString("email","");
        String savedP = preferences.getString("password", "");

        if ((input_email.equals(savedE)) && (input_password.equals(savedP)))
        {
            Intent i = new Intent(this, ListActivity.class);
            startActivity(i);
        }
        else {
            if(input_email.equals("") || input_password.equals(""))
                Toast.makeText(this, "Empty Values,Please make sure to fill all fields", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this,"Incorrect Values",Toast.LENGTH_SHORT).show();
            }
        }
    }

}