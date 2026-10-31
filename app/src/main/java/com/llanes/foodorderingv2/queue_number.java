package com.llanes.foodorderingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class queue_number extends AppCompatActivity {


    private Button mRandomButton;
    private TextView mRandomNumber;


    TextView queueNumberTextView;

    int random;
    int minRandom = 0;
    int maxRandom = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_number);

        mRandomButton = findViewById(R.id.btn_generate_random);
        mRandomNumber = findViewById(R.id.text_random_number);

        mRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();

                random = r.nextInt(maxRandom-minRandom+1)+minRandom;
                mRandomNumber.setText(String.valueOf(random));
                Toast.makeText(queue_number.this, "This is your queue number. Your order has been sent to the email of the canteen. Thank you for ordering!", Toast.LENGTH_LONG).show();

            }
        });



    }
}