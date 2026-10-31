package com.llanes.foodorderingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tykintro extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tykintro);
        Button getStartedbtn;
        getStartedbtn = (Button) findViewById(R.id.getStartedBtn);
        getStartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
                Toast.makeText(tykintro.this, "Welcome to TYK Canteen!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }


}
