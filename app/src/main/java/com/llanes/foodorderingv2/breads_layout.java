package com.llanes.foodorderingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class breads_layout extends AppCompatActivity {

    //for food swiping

    ImageView imageView3;

    TextView quantity, bName, bPrice;

    Button next, previous, plus, minus, atcbtnBreads;

    int i;

    int qtyCounter;

    private int[] textureArrayWin = {R.drawable.futlong, R.drawable.pepperoni, R.drawable.sanwich, R.drawable.hawaiian};

    Button back; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breads_layout);

        FoodCart order = new FoodCart();
        atcbtnBreads = (Button) findViewById(R.id.atcbtnBreads) ;
        atcbtnBreads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(qtyCounter == 0) {
                    return;
                }

                String qty = quantity.getText().toString();
                qty = qty.replaceAll("QTY : ", "");

                String prc = bPrice.getText().toString();
                prc = prc.replaceAll("₱","");

                order.setItemName(bName.getText().toString());
                order.setItemQuantity(Integer.parseInt(qty));
                order.setItemPrice(Double.parseDouble(prc));
                order.addToCart();

                Toast.makeText(breads_layout.this, "Your order was added", Toast.LENGTH_SHORT).show();
            }
        });


        back = (Button) findViewById(R.id.breadBack);
        i = 0;
        qtyCounter = 0;

        //another way to initialize
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opening another activity and closing the current one
                Intent mainIntent = new Intent(breads_layout.this, MainActivity.class);
                startActivity(mainIntent);
                finish();

            }
        });

        //to open the pictures
        imageView3 = findViewById(R.id.imageview3);

        previous = findViewById(R.id.Previous);
        next = findViewById(R.id.Next);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        quantity = findViewById(R.id.qty);
        bName = findViewById(R.id.breadName);
        bPrice = findViewById(R.id.breadPrice);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 0) {
                    return;
                }
                imageView3.setImageResource(textureArrayWin[--i]);
                setFoodDescri(i);

                qtyCounter = 0;
                quantity.setText("QTY : 0");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i == 3) {
                    return;
                }
                imageView3.setImageResource(textureArrayWin[++i]);
                setFoodDescri(i);

                qtyCounter = 0;
                quantity.setText("QTY : 0");
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity.setText("QTY : " + (++qtyCounter));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qtyCounter == 0) {
                    return;
                }
                quantity.setText("QTY : " + (--qtyCounter));
            }
        });


    }

    void setFoodDescri(int imageNumber) {
        String name = "", price = " ";
        switch (imageNumber) {
            case 0:
                name = "Foot Long";
                price = "₱40.00";
                break;
            case 1:
                name = "Pepperoni Pizza";
                price = "₱38.00";
                break;
            case 2:
                name = "sandwhich";
                price = "₱30.00";
                break;
            case 3:
                name = "Hawaiian Pizza";
                price = "₱36.00";
                break;

            default:

        }
        bName.setText(name);
        bPrice.setText(price);

    }
}