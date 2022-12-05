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

public class RegisterActivity extends AppCompatActivity {
    private TextView textViewRegisterTitle;
    private EditText editTextTextEmailAddress, editTextTextPassword;
    private Button buttonRegister;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textViewRegisterTitle = findViewById(R.id.textViewSignInTitle);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        preferences = getSharedPreferences("UserInfo", 0);
    }

    public void register(View view) {
        String input_email = editTextTextEmailAddress.getText().toString();
        String input_password = editTextTextPassword.getText().toString();

        if (input_email.length() > 0 && input_password.length() > 0){

            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("email", input_email).commit();
            editor.putString("password", input_password).commit();
            editor.apply();

            Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, ListActivity.class);
            startActivity(i);

        }
        else{
            Toast.makeText(this, "Registration process failed", Toast.LENGTH_SHORT).show();
        }
    }
}