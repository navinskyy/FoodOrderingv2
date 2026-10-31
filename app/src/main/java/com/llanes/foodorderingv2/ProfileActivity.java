package com.llanes.foodorderingv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    Button back; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        back = (Button) findViewById(R.id.backToHome); //initialize

        //another way to add listener
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opening another activity and closing the current one
                Intent mainIntent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }
}
