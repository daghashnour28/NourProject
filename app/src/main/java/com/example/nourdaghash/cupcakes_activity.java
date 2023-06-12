package com.example.nourdaghash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class cupcakes_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSignInTitle = findViewById(R.id.textViewSignInTitle);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonSignIn = findViewById(R.id.button);

        preferences = getSharedPreferences("UserInfo", 0);
    }






}