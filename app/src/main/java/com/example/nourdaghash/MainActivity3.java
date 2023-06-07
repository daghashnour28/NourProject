package com.example.nourdaghash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


         textView=(TextView)findViewById(R.id.textCakes)
                 textView.setOnClickListner(new View.OnClickListener()) {
@Override
        public void onClick(View V)  {
    Intent intent=new Intent(MainActivity3.this,MainActivity2.class)
            startActivity(intent);

                Toast.makeText(MainActivity3.this,"CAKES CATEGORY",Toast.LENGTH_SHORT).show();
            }
        }
    }
}