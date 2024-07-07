package com.example.myapplication;

import static com.example.myapplication.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText quoiText;
    private EditText number1;
    private EditText number2;
    private EditText number3;

    @SuppressLint("MissingInflatedId")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        quoiText = findViewById(id.quoiText);
        number1= findViewById(id.Number1);
        number2= findViewById(id.Number2);
        number3 = findViewById(id.result);

        Button quoiBtn= findViewById(id.quoibtn);
        Button suppBtn = findViewById(id.deletbtn);

        quoiBtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String quoiMessage= quoiText.getText().toString();

                showToast(quoiMessage);
            }
        });

        suppBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                quoiText.setText("");
            }
        });

        Button googleBtn = findViewById(id.googlebtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch browser with www.google.com
                String url = "http://www.google.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        Button settings= findViewById(id.seetbtn);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivity(intent);
            }
        });

        Button addBtn= findViewById(id.addbtn);
        addBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                double n1= 0;
                double n2= 0;
                if(number1.getText().toString().isEmpty())
                {
                    n1= 0;

                }else {
                    n1= Float.parseFloat(number1.getText().toString());
                }
                if(number2.getText().toString().isEmpty())
                {
                    n2= 0;

                }else {
                    n2= Float.parseFloat(number2.getText().toString());
                }


                double n3= (n1+n2);
                number3.setText(String.valueOf(n3));

            }
        });

        Button call212= findViewById(id.callbtn);

        call212.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String phoneNumber = "212"; // Specify your phone number here

                // Create an Intent with ACTION_DIAL and the phone number URI
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));

                    startActivity(intent);


            }
        });

        Button sousActivity= findViewById(id.sousActivityBtn);
        sousActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, PlanifiedActivities.class);
                startActivity(intent);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}