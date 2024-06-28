package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText t1,t2,t3;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        t1=(EditText) findViewById(R.id.usname);
        t2=(EditText) findViewById(R.id.passwrd);
        t3=(EditText) findViewById(R.id.cnfmpass);


        b1=(AppCompatButton) findViewById(R.id.regisbtn);
        b2=(AppCompatButton) findViewById(R.id.loginbtn);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preference=getSharedPreferences("loginapp",MODE_PRIVATE);
                SharedPreferences.Editor editor=preference.edit();
                editor.clear();
                editor.apply();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUName=t1.getText().toString();
                String getPass=t2.getText().toString();
                String getConfirmPass=t3.getText().toString();
                Toast.makeText(getApplicationContext(),getUName+" "+getPass+" "+getConfirmPass,Toast.LENGTH_LONG).show();
            }
        });

    }
}