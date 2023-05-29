package com.example.nourdaghash.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nourdaghash.Adapter.CategoryAdapter;
import com.example.nourdaghash.Domain.CategoryDomain;
import com.example.nourdaghash.R;
import com.example.nourdaghash.Receiver;
import com.example.nourdaghash.RegisterActivity;
import com.example.nourdaghash.SignInActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button buttonGoLogIn,buttonGoToRegister;
    private TextView textViewBakey;
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView.recyclerViewCategory,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setLayoutDirection(textViewBakey.LAYOUT_DIRECTION_INHERIT);
        recyclerViewCategory();

        private void recyclerViewCategory(){
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            recyclerViewCategory=findViewById(R.id.view1);
            recyclerViewCategory.setLayoutManager(linearLayoutManager);

            ArrayList<CategoryDomain> categoryList=new ArrayList<>();
            categoryList.add(new CategoryDomain("cakes","cake.png"));
            categoryList.add(new CategoryDomain("cookies","cookie.png"));
            categoryList.add(new CategoryDomain("cupcakes","cupcake.jpg"));

            adapter=new CategoryAdapter(categoryList);
            recyclerViewCategory.setAdapter(adapter)
        }


        buttonGoLogIn = findViewById(R.id.buttonGoSignIn);
        buttonGoToRegister = findViewById(R.id.buttonGoToRegister);
        textViewBakey = findViewById(R.id.textViewBakey);

        Intent notification = new Intent(this, Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast (this, 1, notification, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 3000, pendingIntent);
    }

    public void goToSignIn(View view){
        Intent i = new Intent(this, SignInActivity.class);
        startActivity(i);
    }

    public void goToRegister(View view){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }



}