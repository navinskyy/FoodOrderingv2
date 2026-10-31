package com.llanes.foodorderingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class canteenchoose extends AppCompatActivity {
    private Button lctbutton, tykbutton, urbanbutton, logoutbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteenchoose);

        lctbutton = (Button) findViewById(R.id.canteenbtn2);
        lctbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlctcanteen();
            }
        });

        tykbutton = (Button) findViewById(R.id.canteenbtn);
        tykbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opentykcanteen();
            }
        });

        urbanbutton = (Button) findViewById(R.id.canteenbtn3);
        urbanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openurbancanteen();
            }
        });

        logoutbutton = (Button) findViewById(R.id.logoutBTN);
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
                Toast.makeText(canteenchoose.this, "Logout Successful! Thank you for using the app", Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void openlctcanteen(){
        Intent intent = new Intent(this, lctintro.class);
        startActivity(intent);
    }
    public void opentykcanteen(){
        Intent intent = new Intent(this, tykintro.class);
        startActivity(intent);
    }
    public void openurbancanteen(){
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
    }
    public void openlogin(){
        Intent intent = new Intent(this, loginaos.class);
        startActivity(intent);
    }
}